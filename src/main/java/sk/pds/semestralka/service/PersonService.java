package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.PersonMapper;
import sk.pds.semestralka.model.Course;
import sk.pds.semestralka.model.Person;
import sk.pds.semestralka.model.PersonCourse;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonMapper personMapper;

    public List<Person> findAll() {
        return this.personMapper.findAll();
    }

    public Person findById(long identityNumber) {
        return this.personMapper.findById(identityNumber);
    }

    public List<Person> findByName(String name) {
        return this.personMapper.findByName(name);
    }

    public List<Person> findByFirstName(String firstName) {
        return this.personMapper.findByFirstName(firstName);
    }

    public List<Person> findByLastName(String lastName) {
        return this.personMapper.findByLastName(lastName);
    }

    public List<PersonCourse> findAllDrivers() {
        return this.personMapper.findAllDrivers();
    }

    public List<PersonCourse> findAllDriversPageById(int page, int count) {
        return this.personMapper.findAllDriversPageById(count, (page - 1) * count);
    }

    public List<PersonCourse> findAllDriversPageByName(int page, int count) {
        return this.personMapper.findAllDriversPageByName(count, (page - 1) * count);
    }

    public List<PersonCourse> findAllDriversByBirthdate(int page, int count) {
        return this.personMapper.findAllDriversPageByBirthdate(count, (page - 1) * count);
    }

    @Transactional
    public void addCourseToPerson(Person person, Course course, String dateFrom, String dateTo) {
        LocalDate localDateFrom = LocalDate.parse(dateFrom);
        LocalDate localDateTo = LocalDate.parse(dateTo);
        this.personMapper.insertCourseToPerson(new PersonCourse(person, course, localDateFrom, localDateTo));
    }

    @Transactional
    public Person addPerson(long identityNumber, String firstName,String lastName, String birthday) {
        LocalDate birthdate = LocalDate.parse(birthday);
        Person person = new Person(identityNumber, firstName, lastName, birthdate);
        this.personMapper.insertPerson(person);
        return person;
    }

    @Transactional
    public void updatePerson(Person person) {
        this.personMapper.updatePerson(person);
    }

    @Transactional
    public void removePerson(String identityNumber) {
        this.personMapper.deletePerson(identityNumber);
    }
}
