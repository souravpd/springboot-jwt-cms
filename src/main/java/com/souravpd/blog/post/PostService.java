package com.souravpd.blog.post;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.souravpd.blog.topic.Topic;


@Service
public class PostService {
		
	@Autowired
	private PostRepository postRepository;
	
	public List<Post> getAllPostsByTopic(String id){
		List<Post> posts = new ArrayList<Post>();
		postRepository.findByTopicId(id).forEach(posts::add);
		return posts;
	}
	
	public List<Post> getAllPosts(){
		List<Post> posts = new ArrayList<Post>();
		postRepository.findAll().forEach(posts::add);
		return posts;
	}
	public void addPost(Post post) {
		postRepository.save(post);
	}
	
	public Post getPost(String id) {
		return postRepository.findById(id).orElse(null);
	}
	
	public void updatePost(Post post) {
		postRepository.save(post);
	}
	
	public void deletePost(String id) {
		postRepository.deleteById(id);
	}
}
