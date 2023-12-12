package web.technologies.lab10.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import web.technologies.lab10.request.CustomerRequest;
import web.technologies.lab10.response.CustomerResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CustomerControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private CustomerRequest customerRequest;

    @BeforeEach
    void setUp() {
        customerRequest = new CustomerRequest();
        customerRequest.setName("John Doe");
        customerRequest.setEmail("johndoe@example.com");
    }

    @Test
    void createCustomerTest() throws Exception {
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    void getAllCustomersTest() throws Exception {
        mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerRequest)))
            .andExpect(status().isOk());

        mockMvc.perform(get("/customers"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getCustomerByIdTest() throws Exception {
        String response = mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerRequest)))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        CustomerResponse customerResponse = objectMapper.readValue(response, CustomerResponse.class);

        mockMvc.perform(get("/customers/" + customerResponse.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(customerResponse.getId()));
    }

    @Test
    void getCustomerByIdNotFoundTest() throws Exception {
        mockMvc.perform(get("/customers/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateCustomerTest() throws Exception {
        String response = mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerRequest)))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        CustomerResponse customerResponse = objectMapper.readValue(response, CustomerResponse.class);
        customerRequest.setName("Jane Doe");

        mockMvc.perform(put("/customers/" + customerResponse.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Jane Doe"));
    }

    @Test
    void deleteCustomerTest() throws Exception {
        String response = mockMvc.perform(post("/customers")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(customerRequest)))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        CustomerResponse customerResponse = objectMapper.readValue(response, CustomerResponse.class);

        mockMvc.perform(delete("/customers/" + customerResponse.getId()))
            .andExpect(status().isOk());

        mockMvc.perform(get("/customers/" + customerResponse.getId()))
            .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = "classpath:sql/insert-customers.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/cleanup-customers.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void getCustomerById_WithSql() throws Exception {
        mockMvc.perform(get("/customers/11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("John Doe"));
    }

    @Test
    @Sql(scripts = "classpath:sql/insert-customers.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/cleanup-customers.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void updateCustomer_WithSql() throws Exception {
        CustomerRequest updatedCustomer = new CustomerRequest();
        updatedCustomer.setName("Jane Doe");
        updatedCustomer.setEmail("janedoe@example.com");

        mockMvc.perform(put("/customers/11")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedCustomer)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Jane Doe"));
    }

    @Test
    @Sql(scripts = "classpath:sql/insert-customers.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void deleteCustomer_WithSql() throws Exception {
        mockMvc.perform(delete("/customers/11"))
            .andExpect(status().isOk());

        mockMvc.perform(get("/customers/11"))
            .andExpect(status().isNotFound());
    }
}

