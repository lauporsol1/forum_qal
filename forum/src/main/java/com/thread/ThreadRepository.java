package com.thread;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.post.Post;

@Repository
public interface ThreadRepository extends CrudRepository<Thread, Integer> {

	@Transactional
	@Modifying
	@Query("select t.posts from Thread t where t.id in ?1")
	List<Post> getPostsByThread(Integer id);

}
