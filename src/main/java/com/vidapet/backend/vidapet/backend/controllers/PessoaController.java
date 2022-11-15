package com.vidapet.backend.vidapet.backend.controllers;

import com.vidapet.backend.vidapet.backend.models.PessoaModel;
import com.vidapet.backend.vidapet.backend.models.UserModel;
import com.vidapet.backend.vidapet.backend.services.PessoaService;
import com.vidapet.backend.vidapet.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<PessoaModel>> findAll() {
        List<PessoaModel> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PessoaModel> findById(@PathVariable Long id) {
        PessoaModel obj  = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> insert(@RequestBody PessoaModel obj) {
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
    public ResponseEntity<PessoaModel> update(@PathVariable Long id, @RequestBody PessoaModel obj) {
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }
}
