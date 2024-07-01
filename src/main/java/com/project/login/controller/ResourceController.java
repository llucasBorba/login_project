package com.project.login.controller;

import com.project.login.dto.ResourceDTO;
import com.project.login.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Resource")
@CrossOrigin
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    @GetMapping
    public ResponseEntity<List<ResourceDTO>> getAllResources(){
        return ResponseEntity.ok().body(resourceService.getAllResources());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResourceDTO> getResourceById(@PathVariable Long id){
        return ResponseEntity.ok().body(resourceService.getResourceById(id));
    }

    @PostMapping
    public ResponseEntity<ResourceDTO> postResource(@RequestBody ResourceDTO resourceDTO){
        return ResponseEntity.ok().body(resourceService.createResource(resourceDTO));
    }

    @PutMapping
    public ResponseEntity<ResourceDTO> putResource(@RequestBody ResourceDTO resourceDTO){
        return ResponseEntity.ok().body(resourceService.put(resourceDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        resourceService.delete(id);
        return ResponseEntity.ok(null);
    }
}
