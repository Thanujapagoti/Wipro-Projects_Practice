package com.school.management.service.impl;

import com.school.management.entity.School;
import com.school.management.repository.SchoolRepository;
import com.school.management.service.SchoolService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository schoolRepository;

    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    @Override
    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    @Override
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    @Override
    public School getSchoolById(Long id) {
        return schoolRepository.findById(id).orElseThrow(() -> new RuntimeException("School not found"));
    }

    @Override
    public School updateSchool(Long id, School updated) {
        School school = getSchoolById(id);
        school.setSchoolName(updated.getSchoolName());
        school.setSchoolAddress(updated.getSchoolAddress());
        school.setTeacher(updated.getTeacher());
        return schoolRepository.save(school);
    }

    @Override
    public School updateSchoolName(Long id, String newName) {
        School school = getSchoolById(id);
        school.setSchoolName(newName);
        return schoolRepository.save(school);
    }

    @Override
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public List<School> searchSchoolsByName(String name) {
        return schoolRepository.findSchoolsByName(name);
    }


    @Override
    public int totalSchoolCount() {
        return schoolRepository.countTotalSchools();
    }
}
