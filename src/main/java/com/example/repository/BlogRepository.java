package com.example.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.dao.BlogDao;



public interface BlogRepository extends JpaRepository<BlogDao, Long>{
	
	//public BlogDao save(BlogPostRequest blogDao);
	public List<BlogDao> findAll();
  //   public BlogDao save(BlogPostRequest request);
		
}
