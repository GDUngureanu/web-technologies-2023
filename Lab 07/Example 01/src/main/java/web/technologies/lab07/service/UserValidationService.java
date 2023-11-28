package web.technologies.lab07.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.technologies.lab07.exception.CustomerValidationException;
import web.technologies.lab07.model.Customer;

@Service
@RequiredArgsConstructor
public class UserValidationService {
    
    public void validateCustomerRegistry(final Customer customer) {
        if (customer.getEmail() == null) {
           throw new CustomerValidationException("Customer does not have a valid email"); 
        }

        if (customer.getPassword() == null) {
            throw new CustomerValidationException("Customer does not have a valid password");
        }
    }
    
}
