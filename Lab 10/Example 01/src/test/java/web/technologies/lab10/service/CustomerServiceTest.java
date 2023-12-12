package web.technologies.lab10.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import web.technologies.lab10.entity.Customer;
import web.technologies.lab10.repository.CustomerRepository;
import web.technologies.lab10.request.CustomerRequest;
import web.technologies.lab10.response.CustomerResponse;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerService customerService;

    private CustomerRequest customerRequest;
    private Customer customer;
    private CustomerResponse customerResponse;

    @BeforeEach
    void setUp() {
        // Setup test data
        customerRequest = new CustomerRequest();
        customerRequest.setName("John Doe");
        customerRequest.setEmail("johndoe@example.com");

        customer = new Customer();
        customer.setId(1L);
        customer.setName("John Doe");
        customer.setEmail("johndoe@example.com");

        customerResponse = new CustomerResponse();
        customerResponse.setId(1L);
        customerResponse.setName("John Doe");
        customerResponse.setEmail("johndoe@example.com");
    }

    @Test
    void createCustomerTest() {
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);
        CustomerResponse response = customerService.createCustomer(customerRequest);

        assertNotNull(response);
        assertEquals(customer.getId(), response.getId());
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void getAllCustomersTest() {
        when(customerRepository.findAll()).thenReturn(Collections.singletonList(customer));
        var responses = customerService.getAllCustomers();

        assertFalse(responses.isEmpty());
        assertEquals(1, responses.size());
        verify(customerRepository, times(1)).findAll();
    }

    @Test
    void getCustomerByIdTest() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        CustomerResponse response = customerService.getCustomerById(1L);

        assertNotNull(response);
        assertEquals(response, customerResponse);
        assertEquals(customer.getId(), response.getId());
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void getCustomerById_NotFoundTest() {
        when(customerRepository.findById(anyLong())).thenReturn(Optional.empty());

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            customerService.getCustomerById(1L);
        });

        assertEquals("Customer not found for id: 1", thrown.getMessage());
        verify(customerRepository, times(1)).findById(1L);
    }

    @Test
    void updateCustomerTest() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        CustomerResponse response = customerService.updateCustomer(1L, customerRequest);

        assertNotNull(response);
        assertEquals(customer.getId(), response.getId());
        verify(customerRepository, times(1)).findById(1L);
        verify(customerRepository, times(1)).save(any(Customer.class));
    }

    @Test
    void deleteCustomerTest() {
        when(customerRepository.existsById(1L)).thenReturn(true);
        doNothing().when(customerRepository).deleteById(1L);

        customerService.deleteCustomer(1L);

        verify(customerRepository, times(1)).deleteById(1L);
    }

    @Test
    void deleteCustomer_NotFoundTest() {
        when(customerRepository.existsById(anyLong())).thenReturn(false);

        RuntimeException thrown = assertThrows(RuntimeException.class, () -> {
            customerService.deleteCustomer(1L);
        });

        assertEquals("Customer not found for id: 1", thrown.getMessage());
        verify(customerRepository, never()).deleteById(anyLong());
    }
}

