package web.technologies.lab07.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import web.technologies.lab07.model.Customer;
import web.technologies.lab07.model.Distributor;
import web.technologies.lab07.model.User;
import web.technologies.lab07.request.LoginRequest;
import web.technologies.lab07.service.UserService;
import web.technologies.lab07.service.UserValidationService;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;
    
    private final UserValidationService validationService;

    @PostMapping("customers/register")
    public ResponseEntity<User> registerCustomer(@RequestBody final Customer customerDetails) {
        validationService.validateCustomerRegistry(customerDetails);
        
        final var registeredUser = service.registerCustomer(customerDetails);
        
        return ResponseEntity.status(CREATED).body(registeredUser);
    }

    @PostMapping("distributors/register")
    public ResponseEntity<User> registerDistributor(@RequestBody final Distributor distributorDetails) {
        final var registeredUser = service.registerDistributor(distributorDetails);
        return ResponseEntity.status(CREATED).body(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody final LoginRequest request) {
        final var loggedInUser = service.login(request);
        return ResponseEntity.status(OK).body(loggedInUser);
    }

}
