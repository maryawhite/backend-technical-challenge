package com.mchindwhite.backendtechnical.controllers;

import com.mchindwhite.backendtechnical.models.Person;
import com.mchindwhite.backendtechnical.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
        Optional<Person> personOptional = personDao.findPersonByName(newPerson.getName());
        if(personOptional.isPresent()){
            throw new IllegalStateException("name already exists");
        }
        System.out.println("Hello" + newPerson);
        return personDao.save(newPerson);
    }

}
