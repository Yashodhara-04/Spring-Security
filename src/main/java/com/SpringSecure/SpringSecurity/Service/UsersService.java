package com.SpringSecure.SpringSecurity.Service;

import com.SpringSecure.SpringSecurity.DataModel.Users;
import com.SpringSecure.SpringSecurity.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public Users saveUsers(Users users)
    {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepo.save(users);
        return users;
    }
}
