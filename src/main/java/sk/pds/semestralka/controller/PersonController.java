package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Person;
import sk.pds.semestralka.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> findAll() {
        return this.personService.findAll();
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public Person findById(@RequestParam("identityNumber") String identityNumber) {
        return this.personService.findById(identityNumber);
    }

    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public List<Person> findByName(@PathVariable("name") String name) {
        return this.personService.findByName(name);
    }

    @RequestMapping(value = "/firstname/{firstName}", method = RequestMethod.GET)
    public List<Person> findByFirstName(@PathVariable("firstName") String firstName) {
        return this.personService.findByFirstName(firstName);
    }

    @RequestMapping(value = "/lastname/{lastName}", method = RequestMethod.GET)
    public List<Person> findByLastName(@PathVariable("lastName") String lastName) {
        return this.personService.findByLastName(lastName);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Person addPerson(@RequestParam("identityNumber") String identityNumber, @RequestParam("firstName") String firstName,
                            @RequestParam("lastName") String lastName, @RequestParam("birthday") String birthday) {
        return this.personService.addPerson(identityNumber, firstName, lastName, birthday);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updatePerson(@RequestBody Person person) {
        this.personService.updatePerson(person);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void removePerson(@RequestParam("identityNumber") String identityNumber) {
        this.personService.removePerson(identityNumber);
    }
}
