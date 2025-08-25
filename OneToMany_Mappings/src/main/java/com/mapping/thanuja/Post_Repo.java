package com.mapping.thanuja;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface Post_Repo extends JpaRepository<Post, Long>{

}