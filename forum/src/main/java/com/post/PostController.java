package com.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

	@Autowired
	private PostServiceImpl postService;

	@GetMapping("/posts")
	public String getPosts(Model model) {
		List<Post> listPosts = postService.getPost();
		model.addAttribute("listPosts", listPosts);
		return "posts";
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
