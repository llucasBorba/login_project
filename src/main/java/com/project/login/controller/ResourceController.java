package com.project.login.controller;

import com.project.login.dto.DtoResource;
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
    public ResponseEntity<List<DtoResource>> getAllResources(){
        return ResponseEntity.ok().body(resourceService.getAllResources());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DtoResource> getResourceById(@PathVariable Long id){
        return ResponseEntity.ok().body(resourceService.getResourceById(id));
    }

    @PostMapping
    public ResponseEntity<DtoResource> postResource(@RequestBody DtoResource dtoResource){
        return ResponseEntity.ok().body(resourceService.post(dtoResource));
    }

    @PutMapping
    public ResponseEntity<DtoResource> putResource(@RequestBody DtoResource dtoResource){
        return ResponseEntity.ok().body(resourceService.put(dtoResource));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        resourceService.delete(id);
        return ResponseEntity.ok(null);
    }
}
