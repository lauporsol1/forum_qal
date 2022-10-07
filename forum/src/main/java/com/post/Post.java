package com.post;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.thread.Thread;

@Entity
@Table(name = "posts")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "title", unique=true)
	private String title;

	@Column(name = "category")
	@Enumerated(value = EnumType.STRING)
	private Category category;

	@Column(name = "body")
	private String body;

	@Column(name = "image")
	private String image;

	@Transient
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	private Integer threadFk;
	
	@ManyToOne(fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "thread_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@JsonBackReference
	private Thread thread;

	
	
	public Post(Integer id, String title, Category category, String body, String image, Integer threadFk, Thread thread) {
		super();
		this.id = id;
		this.title = title;
		this.category = category;
		this.body = body;
		this.image = image;
		this.threadFk = threadFk;
		this.thread = thread;
	}

	public Post() {
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Thread getThread() {
		return thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public Integer getThreadFk() {
		return threadFk;
	}

	public void setThreadFk(Integer threadFk) {
		this.threadFk = threadFk;
	}

}
