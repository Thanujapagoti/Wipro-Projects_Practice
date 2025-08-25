package com.mapping.thanuja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_Repo extends JpaRepository<Student, Long>{

}