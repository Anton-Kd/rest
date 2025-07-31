package ru.netology.rest.service;


import org.springframework.stereotype.Service;
import ru.netology.rest.Exceptions.InvalidCredentials;
import ru.netology.rest.Exceptions.UnauthorizedUser;
import ru.netology.rest.authorities.Authorities;
import ru.netology.rest.repository.UserRepository;
import ru.netology.rest.user.UserInput;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<Authorities> getAuthorities(UserInput user) {
        String userName = user.getUser();
        String userPassword = user.getPassword();
        if (isEmpty(userName) || isEmpty(userPassword)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(userName, userPassword);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
