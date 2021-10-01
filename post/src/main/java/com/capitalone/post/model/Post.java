package com.capitalone.post.model;

public class Post {

	private Long userId;
	private Long postId;
	private String title;
	private String description;

	public Post(Long userId, String title, String description, Long postId) {
		super();
		this.userId = userId;
		this.title = title;
		this.description = description;
		this.postId = postId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getPostId() {
		return postId;
	}

	public void setPostId(Long postId) {
		this.postId = postId;
	}

}
