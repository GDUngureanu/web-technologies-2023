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
import web.technologies.lab10.request.ProductRequest;
import web.technologies.lab10.response.ProductResponse;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    private ProductRequest productRequest;

    @BeforeEach
    void setUp() {
        productRequest = new ProductRequest();
        productRequest.setName("Test Product");
        productRequest.setDescription("Test Description");
        productRequest.setPrice(99.99);
    }

    @Test
    void createProductTest() throws Exception {
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Test Product"));
    }

    @Test
    void getAllProductsTest() throws Exception {
        mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isOk());

        mockMvc.perform(get("/products"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isArray());
    }

    @Test
    void getProductByIdTest() throws Exception {
        String responseString = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        ProductResponse productResponse = objectMapper.readValue(responseString, ProductResponse.class);

        mockMvc.perform(get("/products/" + productResponse.getId()))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(productResponse.getId()));
    }

    @Test
    void getProductByIdNotFoundTest() throws Exception {
        mockMvc.perform(get("/products/999"))
            .andExpect(status().isNotFound());
    }

    @Test
    void updateProductTest() throws Exception {
        String responseString = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        ProductResponse productResponse = objectMapper.readValue(responseString, ProductResponse.class);

        productRequest.setName("Updated Product");

        mockMvc.perform(put("/products/" + productResponse.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Updated Product"));
    }

    @Test
    void updateProductNotFoundTest() throws Exception {
        mockMvc.perform(put("/products/999")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isNotFound());
    }

    @Test
    void deleteProductTest() throws Exception {
        String responseString = mockMvc.perform(post("/products")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(productRequest)))
            .andExpect(status().isOk())
            .andReturn().getResponse().getContentAsString();

        ProductResponse productResponse = objectMapper.readValue(responseString, ProductResponse.class);

        mockMvc.perform(delete("/products/" + productResponse.getId()))
            .andExpect(status().isOk());

        mockMvc.perform(get("/products/" + productResponse.getId()))
            .andExpect(status().isNotFound());
    }

    @Test
    @Sql(scripts = "classpath:sql/insert-products.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/cleanup-products.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void getProductById_WithSql() throws Exception {
        mockMvc.perform(get("/products/11"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Test Product"));
    }

    @Test
    @Sql(scripts = "classpath:sql/insert-products.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(scripts = "classpath:sql/cleanup-products.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void updateProduct_WithSql() throws Exception {
        ProductRequest updatedProduct = new ProductRequest();
        updatedProduct.setName("Updated Product");
        updatedProduct.setDescription("Updated Description");
        updatedProduct.setPrice(199.99);

        mockMvc.perform(put("/products/11")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(updatedProduct)))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.name").value("Updated Product"));
    }

    @Test
    @Sql(scripts = "classpath:sql/insert-products.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void deleteProduct_WithSql() throws Exception {
        mockMvc.perform(delete("/products/11"))
            .andExpect(status().isOk());

        mockMvc.perform(get("/products/11"))
            .andExpect(status().isNotFound());
    }
}
