package com.teste.demo.resources;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.teste.demo.dto.ClientDto;
import com.teste.demo.services.ClientService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clients")
public class ResourceClient {

    @Autowired
    private ClientService service;

    @GetMapping
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok().body(service.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ClientDto>> findById(@PathVariable Long id) {
        if (!service.existById(id)){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(service.findById(id));

    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public ResponseEntity<ClientDto> insert(@Valid @RequestBody ClientDto clientDto) {
        return ResponseEntity.ok().body(service.save(clientDto));

    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientDto> insert(@PathVariable Long id, @Valid @RequestBody ClientDto clientDto) {

        if (!service.existById(id)) {
            return ResponseEntity.notFound().build();
        }

        clientDto.setId(id);
        service.save(clientDto);
        return ResponseEntity.ok().body(clientDto);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {

        if (!service.existById(id)) {
            return ResponseEntity.notFound().build();
        }

        service.delete(id);

        return ResponseEntity.noContent().build();

    }

}
