package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Person;

import java.util.List;

@Mapper
public interface PersonMapper {
    List<Person> findAll();
    Person findById(@Param("identityNumber") String identityNumber);
    List<Person> findByName(@Param("name") String name);
    List<Person> findByFirstName(@Param("firstName") String firstName);
    List<Person> findByLastName(@Param("lastName") String lastName);
    void insertPerson(@Param("person") Person person);
    void updatePerson(@Param("person") Person person);
    void deletePerson(@Param("identityNumber") String identityNumber);
}
