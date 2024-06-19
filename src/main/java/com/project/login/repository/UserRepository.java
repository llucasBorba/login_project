package com.project.login.repository;

import com.project.login.Model.Users;
import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface UserRepository extends CrudRepository<Users,UUID> {

    Users findByEmail (String email);
}
