package com.project.login.service;

import com.project.login.dto.DtoResource;
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

    public List<DtoResource> getAllResources (){
        List<Resource> resources = resourceRepository.findAll();
        return resources.stream().map(DtoResource::new).collect(Collectors.toList());
    }
    public DtoResource getResourceById(Long id){
        return new DtoResource(resourceRepository.findById(id).get());
    }

    public DtoResource post(DtoResource dtoResource){
        Resource resource = new Resource(dtoResource);
        return new DtoResource(resource);
    }

    public DtoResource put(DtoResource dtoResource){
        Resource resource = new Resource(dtoResource);
        return new DtoResource(resourceRepository.save(resource));
    }

    public void delete(Long id){
        resourceRepository.deleteById(id);
    }
}
