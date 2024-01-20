package com.unfamousthomas.learning.person;

import com.unfamousthomas.learning.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService (PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> getPersons() {
        return personRepository.findAll();
    }


    public void addNewPerson(Person person) {
        Optional<Person> optionalPerson = personRepository.findByName(person.getName());
        if (optionalPerson.isPresent()) {
            throw new IllegalStateException("Name exists");
        }
        personRepository.save(person);
    }

    public void deletePerson(Long personId) {
        Optional<Person> personOptional = personRepository.findById(personId);
        personOptional.ifPresent(personRepository::delete);
    }


    public void updatePerson(Long personId, String name, String job) {
        Optional<Person>personOptional = personRepository.findById(personId);
        if (personOptional.isEmpty()) throw new IllegalStateException("Person not found");
        Person person = personOptional.get();
        if (name != null) person.setName(name);
        if (job != null) person.setJob(job);
        personRepository.save(person);
    }
}
