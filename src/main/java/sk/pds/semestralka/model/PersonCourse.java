package sk.pds.semestralka.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "PERSON_COURSE")
public class PersonCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long driverCourseId;
    private long courseId;
    private String identityNumber;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public PersonCourse() {
    }

    public PersonCourse(long courseId, String identityNumber, LocalDate dateFrom, LocalDate dateTo) {
        this.courseId = courseId;
        this.identityNumber = identityNumber;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public long getId() {
        return driverCourseId;
    }

    public void setId(long driverCourseId) {
        this.driverCourseId = driverCourseId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getDriverId() {
        return identityNumber;
    }

    public void setDriverId(String identityNumber) {
        this.identityNumber = identityNumber;
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
        return getId() == that.getId() &&
                getCourseId() == that.getCourseId() &&
                getDriverId() == that.getDriverId() &&
                getDateFrom().equals(that.getDateFrom()) &&
                getDateTo().equals(that.getDateTo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCourseId(), getDriverId(), getDateFrom(), getDateTo());
    }

    @Override
    public String toString() {
        return "PersonCourse{" +
                "id=" + driverCourseId +
                ", courseId=" + courseId +
                ", driverId=" + identityNumber +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
