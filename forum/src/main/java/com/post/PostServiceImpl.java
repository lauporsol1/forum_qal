package com.post;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import com.banned.BannedWord;
import com.banned.BannedWordRepository;
import com.thread.Thread;
import com.thread.ThreadRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ThreadRepository threadRepository;

	@Autowired
	private BannedWordRepository bwRepository;

	public List<Post> getPost() {
		return (List<Post>) postRepository.findAll();
	}

	public Post savePost(Post post) throws Exception {
		final List<BannedWord> bwList = (List<BannedWord>) bwRepository.findBannedWord();

		Thread thread = threadRepository.findById(post.getThreadFk()).orElse(null);
		post.setThread(thread);

		for (BannedWord bw : bwList) {

			if (post.getTitle().contains(bw.getWord())) {

				throw new Exception("Title contains a banned word");

			}

		}

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
