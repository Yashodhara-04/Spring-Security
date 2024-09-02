package com.SpringSecure.SpringSecurity.controller;

import com.SpringSecure.SpringSecurity.DataModel.Users;
import com.SpringSecure.SpringSecurity.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {

    @Autowired
    private UsersService usersService;

    @PostMapping("/Users")
    public Users addUserData(@RequestBody Users users)
    {
        return usersService.saveUsers(users);
    }

    @PostMapping("/login")
    public String addLogin(@RequestBody Users users)
    {
        System.out.println(users);
        //return usersService.verify(users);
        return "Success";
    }
}
