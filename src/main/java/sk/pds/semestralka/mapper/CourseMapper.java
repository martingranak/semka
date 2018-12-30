package sk.pds.semestralka.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sk.pds.semestralka.model.Course;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<Course> findAll();
    Course findById(@Param("courseId") long courseId);
    List<Course> findByName(@Param("courseName") String courseName);
    void insertCourse(@Param("course") Course course);
    void updateCourse(@Param("course") Course course);
    void deleteCourse(@Param("courseId") long courseId);
}
