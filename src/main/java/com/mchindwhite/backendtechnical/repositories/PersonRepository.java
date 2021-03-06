package com.mchindwhite.backendtechnical.repositories;

import com.mchindwhite.backendtechnical.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT n FROM Person n WHERE n.firstName = ?1 AND n.lastName = ?1")
    Optional<Person> findPersonByName(String firstName, String lastName);

    Person findPersonByFirstName(String firstName);


}
