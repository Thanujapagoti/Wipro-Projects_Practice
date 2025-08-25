package com.mapping.thanuja;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Post_Repo extends JpaRepository<Post, Long>{

}