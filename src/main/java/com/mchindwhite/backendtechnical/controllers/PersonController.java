package com.mchindwhite.backendtechnical.controllers;

import com.mchindwhite.backendtechnical.models.Person;
import com.mchindwhite.backendtechnical.repositories.PersonRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
public class PersonController {
    //dependency injection
    private final PersonRepository personDao;

    public PersonController(PersonRepository personDao) {
        this.personDao = personDao;
    }


    //show all people
    @GetMapping
    public List<Person> getPersons(){
        return personDao.findAll();
    }

    //add a new person
    @PostMapping
    public Person registerNewPerson(@RequestBody Person newPerson){
        Optional<Person> personOptional = personDao.findPersonByName(newPerson.getFirstName(), newPerson.getLastName());
        if(personOptional.isPresent()){
            throw new IllegalStateException("name already exists");
        }
        System.out.println("Hello" + newPerson);
        return personDao.save(newPerson);
    }

    //delete a person
    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable("personId") Long id) {
        boolean exists = personDao.existsById(id);
        if (!exists) {
            throw new IllegalStateException("person with id " + id + " does not exist");
        }
        personDao.deleteById(id);
    }

    //edit a person
    @PutMapping(path = "{personId}")
    public void updatePerson(@PathVariable("personId") Long id, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        Person person = personDao.findById(id).orElseThrow(() -> new IllegalStateException("person with id " + id + " doesn't exist"));
        System.out.println("line 54 " + firstName + " " + lastName);
        if (firstName != null && firstName.length() > 0 && !Objects.equals(person.getFirstName(), firstName)) {
            person.setFirstName(firstName);
            person.setDateUpdated(LocalDate.now());
        }
        if (lastName != null && lastName.length() > 0 && !Objects.equals(person.getLastName(), lastName)) {
            person.setLastName(lastName);
            person.setDateUpdated(LocalDate.now());
        }
        personDao.save(person);
    }

}


