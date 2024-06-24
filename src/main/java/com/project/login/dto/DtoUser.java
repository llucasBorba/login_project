package com.project.login.dto;

import com.project.login.model.Users;

public record DtoUser(String email, String password) {

    public DtoUser(Users user) {
        this(user.getEmail(), user.getPassword());
    }

}
