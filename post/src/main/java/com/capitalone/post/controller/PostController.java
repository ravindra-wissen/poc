package com.capitalone.post.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.capitalone.post.model.Post;
import com.capitalone.post.service.PostService;

@RestController
public class PostController {

	@Autowired
	private PostService userService;

	@GetMapping("/posts/users/{userId}/posts")
	public ResponseEntity<List<Post>> getPostByUsers(@PathVariable Integer userId) {

		List<Post> posts = userService.getPostByUsers(userId);
		return new ResponseEntity<>(posts, HttpStatus.OK);
	}
}
