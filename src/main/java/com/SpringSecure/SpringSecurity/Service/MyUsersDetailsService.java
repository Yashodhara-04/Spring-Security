package com.SpringSecure.SpringSecurity.Service;


import com.SpringSecure.SpringSecurity.DataModel.UserPrincipal;
import com.SpringSecure.SpringSecurity.DataModel.Users;
import com.SpringSecure.SpringSecurity.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUsersDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepo usersRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = usersRepo.findByusername(username);
        if(users == null)
        {
            System.out.println("UserName not found");
            throw new UsernameNotFoundException("User Not Found!!");
        }
        return new UserPrincipal(users);
    }
}
