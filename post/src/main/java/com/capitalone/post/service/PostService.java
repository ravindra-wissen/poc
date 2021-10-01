package com.capitalone.post.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.capitalone.post.model.Post;

@Service
public class PostService {

	public List<Post> getPostByUsers(int userId) {
		List<Post> posts = new ArrayList<>();
		Post post1 = new Post(1l, "Ravi1-title-11", "Ravi-description-1", 1l);
		Post post2 = new Post(1l, "Ravi1-title-1", "Ravi-description-1", 2l);

		Post post3 = new Post(2l, "Raj-title-1", "Raj-description-1", 3l);
		Post post4 = new Post(2l, "Raj-title-1", "Raj-description-1", 4l);

		Post post5 = new Post(3l, "Pooja-title-1", "Pooja-description-1", 5l);
		Post post6 = new Post(3l, "Pooja-title-1", "Pooja-description-1", 6l);

		switch (userId) {
		case 1:
			posts.add(post1);
			posts.add(post2);
			break;

		case 2:
			posts.add(post3);
			posts.add(post4);
			break;

		case 3:
			posts.add(post5);
			posts.add(post6);
			break;

		default:
			break;
		}
		return posts;
	}

}
