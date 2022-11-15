package com.vidapet.backend.vidapet.backend.controllers;

import com.vidapet.backend.vidapet.backend.models.EspecieModel;
import com.vidapet.backend.vidapet.backend.services.EspecieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/especies")
public class EspecieController {

    @Autowired
    private EspecieService service;

    @GetMapping
    public ResponseEntity<List<EspecieModel>> findAll() {
        List<EspecieModel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EspecieModel> findById(@PathVariable Long id) {
        EspecieModel obj  = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<EspecieModel> insert(@RequestBody EspecieModel obj) {
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EspecieModel> update(@PathVariable Long id, @RequestBody EspecieModel obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
