package com.mapping.thanuja;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="subject_table")
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String subjectName;
	
	@ManyToMany(	mappedBy="subjects",
				cascade = CascadeType.ALL,
				fetch = FetchType.EAGER)
	private List<Student> students;

	

	public Subject() {
		super();
	}



	public String getSubjectName() {
		return subjectName;
	}



	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	

}
