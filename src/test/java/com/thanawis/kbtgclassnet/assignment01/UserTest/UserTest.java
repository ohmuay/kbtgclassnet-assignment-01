package com.thanawis.kbtgclassnet.assignment01.UserTest;


import com.thanawis.kbtgclassnet.assignment01.User.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class UserTest {

    @Test
    public void should_be_able_to_create_user_with_name(){
        User user = new User("firstName","lastName");
        assertEquals("firstName",user.getFirstName());
        assertEquals("lastName",user.getLastName());
    }

}
