package com.SpringSecure.SpringSecurity.Service;

import com.SpringSecure.SpringSecurity.DataModel.Users;
import com.SpringSecure.SpringSecurity.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsersService {

    @Autowired
    private UsersRepo usersRepo;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JWTService jwtService;

    public Users saveUsers(Users users)
    {
        users.setPassword(bCryptPasswordEncoder.encode(users.getPassword()));
        usersRepo.save(users);
        return users;
    }

    public String verify(Users users) {
        Authentication authentication = authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(
                users.getUsername(), users.getPassword()
        ));
        if(authentication.isAuthenticated())
        {
            return jwtService.generateToken(users.getUsername());
        }
        return "Fail";
    }
}
