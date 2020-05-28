package com.souravpd.blog.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.souravpd.blog.topic.Topic;
import com.souravpd.blog.topic.TopicService;

@RestController
public class PostController {
	
	@Autowired
	private PostService postService;
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics/{id}/posts")
	public List<Post> getAllposts(@PathVariable("id") String id) {
		return postService.getAllPostsByTopic(id);
	}	
	
	@RequestMapping("/posts")
	public List<Post> getAllTopics() {
		return postService.getAllPosts();
	}	
	
	@RequestMapping("/topics/{topicId}/posts/{id}")
	public Post getPost(@PathVariable("id") String id) {
		return postService.getPost(id);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/admin/topics/{topicId}/posts")
	public void addPost(@RequestBody Post post , @PathVariable("topicId") String topicId){
		
		Topic parentTopic = topicService.getTopic(topicId);
		post.setTopic(parentTopic);
		postService.addPost(post);
	}
	
	@RequestMapping(method=RequestMethod.PUT , value="/admin/topics/{topicId}/posts/{id}")
	public void updatePost(@RequestBody Post post , @PathVariable String id , @PathVariable String topicId){
		Topic parentTopic = topicService.getTopic(topicId);
		post.setTopic(parentTopic);
		postService.updatePost(post);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/admin/topics/{topicId}/posts/{id}")
	public void deletePost(@PathVariable("id") String id) {
		postService.deletePost(id);
	}
	
}
