package com.example.dao;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.response.SuperResponse;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Entity
@Table(name="blog_post")
@JsonRootName("blog")
public class BlogDao extends SuperResponse{
	
	
	public BlogDao(){
		//
	}
	
 
	public BlogDao(Long id, String title, String article, String author_id,
			String title_clean, String blog_user_id) {
		super();
		this.id = id;
		this.title = title;
		this.article = article;
		this.author_id = author_id;
		this.title_clean = title_clean;
		this.blog_user_id = blog_user_id;
	}


	@Override
	public String toString() {
		return "BlogDao [id=" + id + ", title=" + title + ", article="
				+ article + ", author_id=" + author_id + ", title_clean="
				+ title_clean + ", blog_user_id=" + blog_user_id + "]";
	}


	@Id
	@GeneratedValue
	@JsonProperty
	@Column(name="id")
	private Long id;
	@JsonProperty
	@Column(name="title")
	private String title;
	@JsonProperty
	@Column(name="article")
	private String article;
	@JsonProperty
	@Column(name="author_id")
	private String author_id;
	@JsonProperty
	@Column(name="title_clean")
	private String title_clean;
	@JsonProperty
	@Column(name="blog_user_id")
	private String blog_user_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArticle() {
		return article;
	}
	public void setArticle(String article) {
		this.article = article;
	}
	public String getAuthor_id() {
		return author_id;
	}
	public void setAuthor_id(String author_id) {
		this.author_id = author_id;
	}
	public String getTitle_clean() {
		return title_clean;
	}
	public void setTitle_clean(String title_clean) {
		this.title_clean = title_clean;
	}
	public String getBlog_user_id() {
		return blog_user_id;
	}
	public void setBlog_user_id(String blog_user_id) {
		this.blog_user_id = blog_user_id;
	}
	
	
	
	
}
