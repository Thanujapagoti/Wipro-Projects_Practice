package com.school.management.repository;

import com.school.management.entity.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface SchoolRepository extends JpaRepository<School, Long> {
//
    
	

	@Query("SELECT s FROM School s WHERE s.schoolName LIKE %:name%")
	List<School> findSchoolsByName(@Param("name") String name);
	    
    
//    @Query("SELECT s FROM School s WHERE s.schoolName LIKE %:name%")
//    List<School> findSchoolsByName(String name);


    @Query(value = "SELECT COUNT(*) FROM school", nativeQuery = true)
    int countTotalSchools();
}
