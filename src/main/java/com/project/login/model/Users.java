package com.project.login.model;

import com.project.login.dto.DtoUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "email", nullable = false, unique = true, length = 255)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "salt", nullable = false)
    private String salt;

    public Users(String email, String password, String salt) {
        this.email = email;
        this.password = password;
        this.salt = salt;
    }

    public Users() {

    }
    public Users(DtoUser dtoUser){
        this.email = dtoUser.email();
        this.password = dtoUser.password();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
