package com.wipro.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wipro.example.entities.Question;
import com.wipro.example.enums.Category;
import com.wipro.example.repos.QuestionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionService {
	
	private final QuestionRepository questionRepository;

	public List<Question> getQuestionsByCategory(Category category) {
		
           return questionRepository.findByCategory(category);

    }

    public Question addQuestion(Question question) {
        
        return questionRepository.save(question);
    }

	public List<Question> getAllQuestions() {
		// TODO Auto-generated method stub
		return null;
	}
}
