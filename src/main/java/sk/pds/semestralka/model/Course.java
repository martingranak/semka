package sk.pds.semestralka.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COURSE")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int courseId;
    private String courseName;
    private String courseType;

    public Course() {
    }

    public Course(String courseName, String courseType) {
        this.courseName = courseName;
        this.courseType = courseType;
    }

    public int getId() {
        return courseId;
    }

    public void setId(int courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return courseName;
    }

    public void setName(String courseName) {
        this.courseName = courseName;
    }

    public String getType() {
        return courseType;
    }

    public void setType(String courseType) {
        this.courseType = courseType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getId() == course.getId() &&
                getName().equals(course.getName()) &&
                getType().equals(course.getType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getType());
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                '}';
    }
}
