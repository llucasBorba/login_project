package com.project.login.model;

import com.project.login.dto.DtoUser;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "USERS")
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column( updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column( nullable = false)
    private String password;

    public Users(DtoUser dtoUser) {
        this.email = dtoUser.email();
        this.password = dtoUser.password();
    }
    public Users() {
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
