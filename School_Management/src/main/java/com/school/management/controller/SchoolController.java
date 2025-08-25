package com.school.management.controller;

import com.school.management.entity.School;
import com.school.management.service.SchoolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {

    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    @PostMapping
    public School createSchool(@RequestBody School school) {
        return schoolService.saveSchool(school);
    }

    @GetMapping
    public List<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    @GetMapping("/{id}")
    public School getSchool(@PathVariable Long id) {
        return schoolService.getSchoolById(id);
    }

    @PutMapping("/{id}")
    public School updateSchool(@PathVariable Long id, @RequestBody School school) {
        return schoolService.updateSchool(id, school);
    }

    @PatchMapping("/{id}/name")
    public School updateSchoolName(@PathVariable Long id, @RequestParam String name) {
        return schoolService.updateSchoolName(id, name);
    }

    @DeleteMapping("/{id}")
    public String deleteSchool(@PathVariable Long id) {
        schoolService.deleteSchool(id);
        return "School deleted successfully";
    }

    // Custom endpoints
    @GetMapping("/search")
    public List<School> searchSchools(@RequestParam String name) {
        return schoolService.searchSchoolsByName(name);
    }

    @GetMapping("/count")
    public int getTotalSchools() {
        return schoolService.totalSchoolCount();
    }
}
