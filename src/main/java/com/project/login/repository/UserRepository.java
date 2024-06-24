package com.project.login.repository;

import com.project.login.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface UserRepository extends JpaRepository<Users,UUID> {

    Users findByEmail (String email);
}
