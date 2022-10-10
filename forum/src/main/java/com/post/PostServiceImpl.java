package com.post;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

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
	
	public String image(Integer id) {
		Post post = postRepository.findById(id).orElseThrow();
		String url = "src/main/resources/loudspeaker-forum.png";
		if (post.getCategory() == Category.question) {
			url = "src/main/resources/qm-forum.png";
		} else if (post.getCategory() == Category.clarification) {
			url = "src/main/resources/pencil-forum.png";
		}
		return url;
	}

	public List<Post> getPostbyThreads(Integer id) {
		return threadRepository.getPostsByThread(id);
	}

}
