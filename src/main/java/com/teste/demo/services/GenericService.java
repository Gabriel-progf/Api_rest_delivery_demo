package com.teste.demo.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.teste.demo.services.exceptions.DataBaseException;
import com.teste.demo.services.exceptions.ResourceNotFoundException;
import com.teste.demo.util.Convertible;

import jakarta.transaction.Transactional;

@Service
public abstract class GenericService<T extends Convertible<DTO>, DTO extends Convertible<T>, ID> {

    @Autowired
    private JpaRepository<T, ID> repo;

    public List<DTO> findAll() {
        List<T> list = repo.findAll();
        return list.stream().map(c -> c.convert()).toList();
    }

    public Optional<DTO> findById(ID id) {
        Optional<T> obj = repo.findById(id);
        return Optional.of(obj.get().convert());

    }

    @Transactional
    public void delete(ID id) {
        try {
            repo.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new ResourceNotFoundException("Id not found");
        } catch (IllegalArgumentException e) {
            throw new DataBaseException(id);
        }
    }

    public boolean existById(ID id) {
        return repo.existsById(id);
    }

}
