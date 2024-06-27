package com.project.login.dto;

import com.project.login.model.Resource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DtoResource {

    Long id;
    String name;
    String chave;

    public DtoResource(Resource resource){
        BeanUtils.copyProperties(resource,this);
    }
}
