package com.project.login.model;

import com.project.login.dto.ResourceDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name ="RESOURCE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Resource {

    @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    String chave;

    public Resource(ResourceDTO resourceDTO){
        BeanUtils.copyProperties(resourceDTO,this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Resource resource = (Resource) o;
        return Objects.equals(id, resource.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
