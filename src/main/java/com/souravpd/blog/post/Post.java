package com.souravpd.blog.post;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


import com.souravpd.blog.topic.Topic;

@Entity
public class Post {
	
	@Id
	private String id;
	private String name;
	private String description;
	@Lob
	private String content;
	

	@ManyToOne
	private Topic topic;
	
	public Post() {
		
	}
	
	public Post(String id, String name, String description, String topicId , String content) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.topic = new Topic(topicId , "" , "");
		this.content = content;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public Topic getTopic() {
		return topic;
	}
	
	public void setTopic(Topic topic) {
		this.topic = topic;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
