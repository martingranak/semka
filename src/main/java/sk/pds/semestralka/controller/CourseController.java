package sk.pds.semestralka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sk.pds.semestralka.model.Course;
import sk.pds.semestralka.service.CourseService;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Course> findAll() {
        return this.courseService.findAll();
    }

    @RequestMapping(value = "/one", method = RequestMethod.POST)
    public Course findById(@RequestParam("courseId") long courseId) {
        return this.courseService.findById(courseId);
    }

    @RequestMapping(value = "/name/{courseName}", method = RequestMethod.GET)
    public List<Course> findByName(@PathVariable("corseName") String corseName) {
        return this.courseService.findByName(corseName);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Course addCourse(@RequestParam("courseName") String courseName, @RequestParam("courseType") String courseType) {
        return this.courseService.addCourse(courseName, courseType);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public void updateCourse(@RequestBody Course course) {
        this.courseService.updateCourse(course);
    }

    @RequestMapping(value = "/remove", method = RequestMethod.DELETE)
    public void removeCoordinates(@RequestParam("courseId") long courseId) {
        this.courseService.removeCoordinates(courseId);
    }
}
