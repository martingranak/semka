package sk.pds.semestralka.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PERSON")
public class Person {
    @Id
    private String identityNumber;
    private String firstName;
    private String lastName;
    private Date birthday;

    public Person() {
    }

    public Person(String identityNumber, String firstName, String lastName, Date birthday) {
        this.identityNumber = identityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getIdentityNumber().equals(person.getIdentityNumber()) &&
                getFirstName().equals(person.getFirstName()) &&
                getLastName().equals(person.getLastName()) &&
                getBirthday().equals(person.getBirthday());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdentityNumber(), getFirstName(), getLastName(), getBirthday());
    }

    @Override
    public String toString() {
        return "Person={identityNumber=" + identityNumber + ", firstName=" + firstName + ", lastName=" + lastName + ", birthday=" + birthday.toString() + "}";
    }
}