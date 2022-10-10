package com.post;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	private PostServiceImpl postService;

	@RequestMapping(value = "/posts/threads/{thread_id}/posts/{post_id}", method = RequestMethod.GET, produces = MediaType.IMAGE_PNG_VALUE)
	public void getImages(@PathVariable("thread_id") Integer threadId, @PathVariable("post_id") Integer postId,
			HttpServletResponse response) throws IOException {
		String image = postService.image(postId);
		ClassPathResource imageFile = new ClassPathResource(image);
		StreamUtils.copy(imageFile.getInputStream(), response.getOutputStream());
	}

	@GetMapping("/threads/{thread_id}/posts")
	public String getPosts(Model model, @PathVariable(value = "thread_id") Integer id) {
		List<Post> listPosts = postService.getPostbyThreads(id);
		model.addAttribute("listPosts", listPosts);
		model.addAttribute("thread_id", id);
		return "posts";
	}

	@GetMapping("/threads/{thread_id}/posts/create")
	public String createPosts(Model model, @PathVariable(value = "thread_id") Integer id) {
		Post p = new Post();
		p.setThreadFk(id);
		model.addAttribute("post", p);
		return "create_post";
	}

	@PostMapping("/process_create")
	public String createPostsProcess(Post post) {
		postService.savePost(post);
		return "redirect:/threads";
	}

}
