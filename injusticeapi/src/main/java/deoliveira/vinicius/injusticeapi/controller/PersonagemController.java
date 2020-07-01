package deoliveira.vinicius.injusticeapi.controller;

import deoliveira.vinicius.injusticeapi.model.PersonagemEntity;
import deoliveira.vinicius.injusticeapi.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author Vinícius de Oliveira
 * @Version 1.0
 */

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemRepository personagemRepository;

    @GetMapping
    public ResponseEntity<List<PersonagemEntity>> findAll() {
        return new ResponseEntity<List<PersonagemEntity>>(
                (List<PersonagemEntity>) this.personagemRepository.findAll(),
                new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
     public ResponseEntity<PersonagemEntity> findById(@PathVariable("id") long id) {
        if(this.personagemRepository.findById(id).isPresent()) {
            return new ResponseEntity<PersonagemEntity>(
                    this.personagemRepository.findById(id).get(),
                    new HttpHeaders(),
                    HttpStatus.OK);
        }
        return new ResponseEntity<PersonagemEntity>(HttpStatus.NOT_FOUND);
     }

    @PostMapping
    public ResponseEntity<PersonagemEntity> save(@Valid @RequestBody PersonagemEntity personagemEntity) {

        return new ResponseEntity<PersonagemEntity>(
                this.personagemRepository.save(personagemEntity),
                new HttpHeaders(), HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PersonagemEntity> update(@PathVariable("id") long id,
                                               @Valid @RequestBody PersonagemEntity personagemEntity) throws Exception {

        if (id == 0 || !this.personagemRepository.existsById(id)) {
            throw new Exception("Código não encontrado.");
        }

        return new ResponseEntity<PersonagemEntity>(
                this.personagemRepository.save(personagemEntity),
                new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<PersonagemEntity> delete(@Valid @PathVariable("id") long id) {

        this.personagemRepository.deleteById(id);
        return new ResponseEntity<PersonagemEntity>(new HttpHeaders(), HttpStatus.OK);
    }

}
