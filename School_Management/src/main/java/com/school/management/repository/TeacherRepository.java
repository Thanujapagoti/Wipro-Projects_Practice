package com.school.management.repository;

import com.school.management.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    // Custom query method
    List<Teacher> findByQualification(String qualification);

    // Native query to find teachers above certain experience
    @Query(value = "SELECT * FROM teacher WHERE experience > ?1", nativeQuery = true)
    List<Teacher> findExperiencedTeachers(int minExperience);
}
