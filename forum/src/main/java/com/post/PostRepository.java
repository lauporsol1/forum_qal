package com.post;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer>{

	List<Post> findByThreadId(Integer threadId);
	
	@Transactional
	void deleteByThreadId(Integer threadId);
	
}
