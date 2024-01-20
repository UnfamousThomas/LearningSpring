package com.unfamousthomas.learning.person;

import com.unfamousthomas.learning.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/person")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPerson() {
        return personService.getPersons();
    }

    @PostMapping
    public void registerNewPerson(@RequestBody Person person) {
        personService.addNewPerson(person);
    }

    @DeleteMapping(path = "{personId}")
    public void deletePerson(@PathVariable Long personId) {
        personService.deletePerson(personId);
    }

    @PutMapping(path = "{personId}")
    public void updatePerson(
            @PathVariable("personId") Long personId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String job) {
        personService.updatePerson(personId, name, job);
    }
}
