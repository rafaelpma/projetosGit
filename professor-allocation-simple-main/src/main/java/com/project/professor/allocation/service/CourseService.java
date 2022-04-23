package com.project.professor.allocation.service;

import com.project.professor.allocation.entity.Allocation;
import com.project.professor.allocation.entity.Course;
import com.project.professor.allocation.repository.AllocationRepository;
import com.project.professor.allocation.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final AllocationRepository allocationRepository;

    public CourseService(CourseRepository courseRepository, AllocationRepository allocationRepository) {
        super();
        this.courseRepository = courseRepository;
        this.allocationRepository = allocationRepository;
    }

    public List<Course> findAll(String name) {
        if (name == null) {
            return courseRepository.findAll();
        } else {
            return courseRepository.findByNameContainingIgnoreCase(name);
        }
    }

    public Course findById(Long id) {
        return courseRepository.findById(id).orElse(null);
    }

    public Course save(Course course) {
        course.setId(null);
        return saveInternal(course);
    }

    public Course update(Course course) {
        Long id = course.getId();
        if (id != null && courseRepository.existsById(id)) {
            return saveInternal(course);
        } else {
            return null;
        }
    }

    public void deleteById(Long id) {
        if (id != null && courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        }
    }

    public void deleteAll() {
        courseRepository.deleteAllInBatch();
    }

    private Course saveInternal(Course course) {
        course = courseRepository.save(course);

        List<Allocation> allocations = allocationRepository.findByCourseId(course.getId());
        course.setAllocations(allocations);

        return course;
    }
}
