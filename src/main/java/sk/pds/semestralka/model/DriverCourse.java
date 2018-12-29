package sk.pds.semestralka.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "DRIVER_COURSE")
public class DriverCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long courseId;
    private long driverId;
    private LocalDate dateFrom;
    private LocalDate dateTo;

    public DriverCourse() {
    }

    public DriverCourse(long courseId, long driverId, LocalDate dateFrom, LocalDate dateTo) {
        this.courseId = courseId;
        this.driverId = driverId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public long getDriverId() {
        return driverId;
    }

    public void setDriverId(long driverId) {
        this.driverId = driverId;
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
        if (!(o instanceof DriverCourse)) return false;
        DriverCourse that = (DriverCourse) o;
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
        return "DriverCourse{" +
                "id=" + id +
                ", courseId=" + courseId +
                ", driverId=" + driverId +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                '}';
    }
}
