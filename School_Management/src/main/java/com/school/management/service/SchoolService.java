package com.school.management.service;

import com.school.management.entity.School;

import java.util.List;

public interface SchoolService {
    School saveSchool(School school);
    List<School> getAllSchools();
    School getSchoolById(Long id);
    School updateSchool(Long id, School school);
    School updateSchoolName(Long id, String newName);
    void deleteSchool(Long id);

    List<School> searchSchoolsByName(String name);

    
    int totalSchoolCount();
}
