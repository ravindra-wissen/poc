package com.capitalone.post.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

import com.capitalone.post.model.Post;

public class PostServiceTest {

	@InjectMocks
	private PostService postService;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getPostByUsersTest() {
		List<Post> result = postService.getPostByUsers(1);
		Assert.assertEquals(result.get(0).getUserId(), Long.valueOf(1));
		
		result = postService.getPostByUsers(2);
		Assert.assertEquals(result.get(0).getUserId(), Long.valueOf(2));
		
		result = postService.getPostByUsers(3);
		Assert.assertEquals(result.get(0).getUserId(), Long.valueOf(3));
		
	}
}
