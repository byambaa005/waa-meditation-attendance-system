package edu.mum.waa.backend.meditation.ws.controller.crud;


import edu.mum.waa.backend.meditation.ws.entity.audit.IdDateAudit;
import edu.mum.waa.backend.meditation.ws.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

public abstract class RestCrudController< T extends IdDateAudit> {
    private static final Logger logger = LoggerFactory.getLogger(RestCrudController.class);

    @Autowired
    protected JpaRepository<T,Long> repository;

    /**
     *
     * @return
     */
    @GetMapping
    public Page<T> retrieveAll(@RequestParam(defaultValue = "0" , required = false) int page,
                               @RequestParam(defaultValue = "20" , required = false) int size) {
        System.out.println("test");

        return repository.findAll(PageRequest.of(page,size));
    }

    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public T retrieve(@PathVariable Long id) {
        Optional<T> optional = repository.findById(id);

        if (!optional.isPresent())
            throw new ResourceNotFoundException("" ,"id",id);

        return optional.get();
    }

    /**
     *
     * @param id
     */
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    /**
     *
     * @param entity
     * @return
     */
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody T entity) {
        T savedStudent = repository.save(entity);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedStudent.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    /**
     *
     * @param entity
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@RequestBody T entity, @PathVariable Long id) {

        Optional<T> optional = repository.findById(id);

        if (!optional.isPresent())
            return ResponseEntity.notFound().build();

        entity.setId(id);

        repository.save(entity);

        return ResponseEntity.noContent().build();
    }
}
