package web.technologies.lab08.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab08.entity.UserEntity;
import web.technologies.lab08.model.User;
import web.technologies.lab08.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User create(final User user) {
        final var entity = mapModel(user);
        return mapEntity(repository.save(entity));
    }

    public User get(final UUID id) {
        return mapEntity(repository.findById(id).get());
    }

    private UserEntity mapModel(final User user) {
        final var entity = new UserEntity();

        entity.setName(user.getName());
        entity.setPassword(user.getPassword());
        entity.setEmail(user.getEmail());
        entity.setDeliveryAddress(user.getDeliveryAddress());
        entity.setCompany(user.getCompany());
        entity.setAddress(user.getAddress());
        entity.setRole(user.getRole());

        return entity;
    }

    private User mapEntity(final UserEntity entity) {
        final var user = new User();

        user.setId(entity.getId());
        user.setName(entity.getName());
        user.setEmail(entity.getEmail());
        user.setDeliveryAddress(entity.getDeliveryAddress());
        user.setCompany(entity.getCompany());
        user.setAddress(entity.getAddress());
        user.setRole(entity.getRole());

        return user;
    }
}

