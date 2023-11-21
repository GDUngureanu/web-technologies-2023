package web.technologies.lab07.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import web.technologies.lab07.model.User;
import web.technologies.lab07.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public User register(final User user) {
        return repository.save(user);
    }

}

