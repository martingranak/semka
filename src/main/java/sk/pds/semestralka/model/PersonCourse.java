package sk.pds.semestralka.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

public class PersonCourse {
    private long personCourseId;
    private Person person;
    private Course course;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public PersonCourse() {
    }

    public PersonCourse(long personCourseId, Person person, Course course, LocalDate dateFrom, LocalDate dateTo) {
        this.personCourseId = personCourseId;
        this.person = person;
        this.course = course;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public long getPersonCourseId() {
        return personCourseId;
    }

    public void setPersonCourseId(long personCourseId) {
        this.personCourseId = personCourseId;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonCourse)) return false;
        PersonCourse that = (PersonCourse) o;
        return getPersonCourseId() == that.getPersonCourseId() &&
                getPerson().equals(that.getPerson()) &&
                getCourse().equals(that.getCourse()) &&
                getDateFrom().equals(that.getDateFrom()) &&
                getDateTo().equals(that.getDateTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonCourseId(), getPerson(), getCourse(), getDateFrom(), getDateTo());
    }

    @Override
    public String toString() {
        return "PersonCourse{" +
                "personCourseId=" + personCourseId +
                ", person=" + person +
                ", course=" + course +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
