package com.wipro.example.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wipro.example.entities.Question;
import com.wipro.example.enums.Category;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    


	@Query(value = "SELECT * FROM question q WHERE q.category = :category AND q.difficulty_level = :difficulty ORDER BY RAND() LIMIT 3", nativeQuery = true)

	List<Question> findRandomQuestionsByCategoryAndLevel(String category, String difficulty);

	List<Question> findByCategory(Category category);

}
