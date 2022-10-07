package com.post;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thread.Thread;
import com.thread.ThreadRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ThreadRepository threadRepository;

	public List<Post> getPost() {
		return (List<Post>) postRepository.findAll();
	}

	public Post savePost(Post post) {
		Thread thread = threadRepository.findById(post.getThreadFk()).orElse(null);
		post.setThread(thread);
		return postRepository.save(post);
	}

	public List<Post> getPostbyThreads(Integer id) {
		return threadRepository.getPostsByThread(id);
	}

}
