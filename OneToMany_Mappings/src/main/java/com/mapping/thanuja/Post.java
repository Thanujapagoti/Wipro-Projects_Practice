package com.mapping.thanuja;

import java.util.Date;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.FetchType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="post_table")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String address;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="user_id")
	private User user;
	
	public Post() {
		super();
	}
	
	
}