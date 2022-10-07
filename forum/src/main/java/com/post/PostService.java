package com.post;

import java.util.List;

public interface PostService {

	public List<Post> getPost();
	public Post savePost(Post p);
	
}
