package com.thanawis.kbtgclassnet.assignment01.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public User getUser(@RequestHeader("Authorization") String token){
        return userService.findByToken(token);
    }

}
