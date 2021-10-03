package com.capitalone.post.controller;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.capitalone.post.model.Post;
import com.capitalone.post.service.PostService;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTests {

	@Mock
	private PostService postService;

	@InjectMocks
	private PostController postController;

	private List<Post> posts;
	private Post post;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		posts = new ArrayList<>();
		post = new Post(1l, "title", "desc", 1l);
		posts.add(post);
	}

	@Test
	public void getPostByUsersTest() {
		when(postService.getPostByUsers(1)).thenReturn(posts);
		ResponseEntity<List<Post>> result = postController.getPostByUsers(1);
		Assert.assertNotNull(result);
	}
}
