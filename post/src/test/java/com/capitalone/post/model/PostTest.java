package com.capitalone.post.model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;

public class PostTest {

	@InjectMocks
	private Post post;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void getTitleTest() {
		post.setTitle("title");
		String result = post.getTitle();
		assertEquals(result, "title");

	}

	@Test
	public void getUserIdTest() {
		post.setUserId(1l);
		Long result = post.getUserId();
		assertEquals(result, Long.valueOf(1l));

	}

	@Test
	public void getPostIdTest() {
		post.setPostId(1l);
		Long result = post.getPostId();
		assertEquals(result, Long.valueOf(1l));

	}

	@Test
	public void getDescriptionTest() {
		post.setDescription("Description");
		String result = post.getDescription();
		assertEquals(result, "Description");

	}
}
