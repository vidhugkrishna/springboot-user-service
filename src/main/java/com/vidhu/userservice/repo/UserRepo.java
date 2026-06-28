package com.vidhu.userservice.repo;

import com.vidhu.userservice.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users,Integer> {

    public Users findByEmail(String email);
}
