package de.alice.springboot.webmvc.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    public boolean authenticate(String username, String password) {
        return username.equalsIgnoreCase("alice") && password.equalsIgnoreCase("password");
    }
}
