package com.SpringSecure.SpringSecurity.Repo;

import com.SpringSecure.SpringSecurity.DataModel.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

    Users findByusername(String username);
}
