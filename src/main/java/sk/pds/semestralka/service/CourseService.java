package sk.pds.semestralka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.pds.semestralka.mapper.CourseMapper;
import sk.pds.semestralka.model.Course;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseMapper courseMapper;

    public List<Course> findAll() {
        return this.courseMapper.findAll();
    }

    public Course findById(long courseId) {
        return this.courseMapper.findById(courseId);
    }

    public List<Course> findByName(String corseName) {
        return this.courseMapper.findByName(corseName);
    }

    @Transactional
    public Course addCourse(String courseName, String courseType) {
        Course course = new Course(courseName, courseType);
        this.courseMapper.insertCourse(course);
        return course;
    }

    @Transactional
    public void updateCourse(Course course) {
        this.courseMapper.updateCourse(course);
    }

    @Transactional
    public void removeCoordinates(long courseId) {
        this.courseMapper.deleteCourse(courseId);
    }
}
