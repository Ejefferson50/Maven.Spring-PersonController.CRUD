package io.zipcoder.crudapp.Controller;

import io.zipcoder.crudapp.Model.Person;
import io.zipcoder.crudapp.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PersonController  {
    @Autowired
    private PersonRepository personRepository;

    public PersonController(){

    }

    //201 Created
    @PostMapping(path = "/people")
    public ResponseEntity<Person> createPerson(@RequestBody Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.CREATED);}

    //200 Ok
    @GetMapping(path = "/people/{id}")
    public ResponseEntity<Person> getPerson(Long id){
        return new ResponseEntity<>(personRepository.findById(id).get(), HttpStatus.OK);
    }

    //200 OK if found, else 404 Not Found
    @GetMapping(path = "/people")
    public ResponseEntity<List<Person>> getPersonList(){
        return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);
    }

    //200 OK if updated, 201 Created if a new entity was created
    @PutMapping(path = "/people/{id}")
    public ResponseEntity<Person> updatePerson(Long id, Person p){
        return new ResponseEntity<>(personRepository.save(p), HttpStatus.OK);
    }

    //204 No Content
    @DeleteMapping(path = "/people/{id}")
    public ResponseEntity deletePerson(Long id){
        personRepository.deleteById(id);
         return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
/*
public class BakerController {
    @Autowired
    private BakerService service;

    public BakerController(BakerService service) {
        this.service = service;
    }

    public ResponseEntity<Iterable<Baker>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/bakers/{id}")
    public ResponseEntity<Baker> show(@PathVariable Long id) {
        return new ResponseEntity<>(service.show(id), HttpStatus.OK);
    }
    @PostMapping("/bakers")
    public ResponseEntity<Baker> create(@RequestBody Baker baker) {
        return new ResponseEntity<>(service.create(baker), HttpStatus.CREATED);
    }
    @PutMapping("/bakers/{id}")
    public ResponseEntity<Baker> update(@PathVariable Long id, Baker baker) {
        return new ResponseEntity<>(service.update(id, baker), HttpStatus.OK);
    }
    @DeleteMapping("/bakers/{id}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long id) {
        return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
    }
}
 */