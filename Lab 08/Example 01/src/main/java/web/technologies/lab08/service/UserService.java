package web.technologies.lab08.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.technologies.lab08.entity.UserEntity;
import web.technologies.lab08.model.User;
import web.technologies.lab08.repository.UserRepository;
import web.technologies.lab08.request.UserUpdateRequest;

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

    public void update(UUID id, UserUpdateRequest newUserDetails) {
        final var entity = repository.findById(id).get();

        mapNewUserDetails(newUserDetails, entity);

        repository.save(entity);
    }

    private void mapNewUserDetails(UserUpdateRequest newUserDetails, UserEntity entity) {
        entity.setName(newUserDetails.getName());
        entity.setDeliveryAddress(newUserDetails.getDeliveryAddress());
        entity.setCompany(newUserDetails.getCompany());
        entity.setAddress(newUserDetails.getAddress());
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

    public List<User> findByName(String name) {
        final List<UserEntity> users = repository.findAllByUserName(name);
        return  users.stream().map(this::mapEntity).toList();
    }
}

