package com.thanawis.kbtgclassnet.assignment01.User;

import com.thanawis.kbtgclassnet.assignment01.CustomExceptions.ResourceNotFoundException;
import com.thanawis.kbtgclassnet.assignment01.CustomExceptions.UnAuthorizedException;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByToken(String token) {
        Optional<User> user = userRepository.findByToken(token);
        if(user.isPresent())
            return user.get();
        else
            throw new UnAuthorizedException("User not found");
    }
}
