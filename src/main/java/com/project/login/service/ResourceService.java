package com.project.login.service;

import com.project.login.dto.ResourceDTO;
import com.project.login.model.Resource;
import com.project.login.repository.ResourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    public List<ResourceDTO> getAllResources (){
        List<Resource> resources = resourceRepository.findAll();
        return resources.stream().map(ResourceDTO::new).collect(Collectors.toList());
    }
    public ResourceDTO getResourceById(Long id){
        return new ResourceDTO(resourceRepository.findById(id).get());
    }

    public ResourceDTO createResource(ResourceDTO resourceDTO){
        Resource resource = new Resource(resourceDTO);
        return new ResourceDTO(resourceRepository.save(resource));
    }

    public ResourceDTO put(ResourceDTO resourceDTO){
        Resource resource = new Resource(resourceDTO);
        return new ResourceDTO(resourceRepository.save(resource));
    }

    public void delete(Long id){
        resourceRepository.deleteById(id);
    }
}
