package web.technologies.lab07.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.technologies.lab07.entity.UserEntity;
import web.technologies.lab07.exception.AccessForbiddenException;
import web.technologies.lab07.exception.WrongPasswordException;
import web.technologies.lab07.exception.UserDoesNotExistException;
import web.technologies.lab07.model.Customer;
import web.technologies.lab07.model.Distributor;
import web.technologies.lab07.model.User;
import web.technologies.lab07.model.UserRole;
import web.technologies.lab07.repository.UserRepository;
import web.technologies.lab07.request.LoginRequest;

import java.util.Optional;
import java.util.UUID;

import static web.technologies.lab07.model.UserRole.DISTRIBUTOR;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User register(final User user) {
        final var entity = mapModel(user);
        return mapEntity(repository.save(entity));
    }

    public User registerCustomer(Customer customer) {
        final var entity = mapModel(customer);
        return mapEntity(repository.save(entity));
    }

    public User registerDistributor(final Distributor distributor) {
        final var entity = mapModel(distributor);
        return mapEntity(repository.save(entity));
    }

    private UserEntity mapModel(final Customer customer) {
        return UserEntity.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .password(customer.getPassword())
                .deliveryAddress(customer.getDeliveryAddress())
                .role(UserRole.CUSTOMER)
                .build();
    }

    private UserEntity mapModel(final Distributor distributor) {
        return UserEntity.builder()
                .name(distributor.getName())
                .email(distributor.getEmail())
                .password(distributor.getPassword())
                .company(distributor.getCompany())
                .address(distributor.getAddress())
                .role(DISTRIBUTOR)
                .build();
    }

    private UserEntity mapModel(final User user) {
        return UserEntity.builder()
                .name(user.getName())
                .role(user.getRole())
                .build();
    }
    private User mapEntity(final UserEntity entity) {
        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .deliveryAddress(entity.getDeliveryAddress())
                .company(entity.getCompany())
                .address(entity.getAddress())
                .role(entity.getRole())
                .build();
    }

    public Optional<User> findUserByEmail(final String email) {
        return repository.findUserEntityByEmailIgnoreCase(email).map(this::mapEntity);
    }

    public User login(LoginRequest request) {
        final var optionalUser = repository.findUserEntityByEmailIgnoreCase(request.email());
        
        if (optionalUser.isEmpty()) {
            throw  new UserDoesNotExistException("User does not exist!");
        }
        
        final var user = optionalUser.get();
        
        if (!user.getPassword().equals(request.password())) {
            throw new WrongPasswordException("Wrong password!");
        }
        
        return mapEntity(user);
    }

    public void isDistributor(UUID userId) {
        final var optionalUser =repository.findById(userId);
        if (optionalUser.isEmpty()) {
            throw  new UserDoesNotExistException("User does not exist!");
        }
        
        if (!DISTRIBUTOR.equals(optionalUser.get().getRole())) {
            throw  new AccessForbiddenException("User does not have access to do this action!");
        }
    }

    //        if (service.findUserByEmail(customer.getEmail()).isPresent()) {
    //            throw new CustomerValidationException("Email has already been registered");
    //        }
}

