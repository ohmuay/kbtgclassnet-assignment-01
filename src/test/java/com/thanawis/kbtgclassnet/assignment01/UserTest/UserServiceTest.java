package com.thanawis.kbtgclassnet.assignment01.UserTest;

import com.thanawis.kbtgclassnet.assignment01.CustomExceptions.UnAuthorizedException;
import com.thanawis.kbtgclassnet.assignment01.User.User;
import com.thanawis.kbtgclassnet.assignment01.User.UserRepository;
import com.thanawis.kbtgclassnet.assignment01.User.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;



@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void should_found_user_by_token(){

            // Mock
            String token = "TOKEN";
            when(userRepository.findByToken(token)).thenReturn(
                    Optional.of(new User("testName", "lastname"))
            );

            // Action
            User user = userService.findByToken(token);

            // Assert
            assertInstanceOf(User.class, user);
            assertEquals("testName",user.getFirstName());
    }

    @Test
    public void should_not_found_user(){

            // Action
            Throwable exception = assertThrows(UnAuthorizedException.class,() ->
            userService.findByToken("NOT_FOUND_TOKEN")
            );

             // Assert
            assertEquals("User not found",exception.getMessage());

    }
}
