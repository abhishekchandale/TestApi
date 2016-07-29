package com.example.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BlogPostRequest {
	
	
	@JsonProperty
	private String authorId;
	@JsonProperty
	private String article;
	@JsonProperty
	private String ariclePostDate;
	@JsonProperty
	private String articleCategoty;
	public String getAuthorId() {
		return authorId;
	}
	public void setAuthorId(String authorId) {
		this.authorId = authorId;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getAriclePostDate() {
		return ariclePostDate;
	}
	public void setAriclePostDate(String ariclePostDate) {
		this.ariclePostDate = ariclePostDate;
	}
	public String getArticleCategoty() {
		return articleCategoty;
	}
	public void setArticleCategoty(String articleCategoty) {
		this.articleCategoty = articleCategoty;
	}
	
	

}
