package controller;

import java.util.List;

import model.Post;
import model.PostModel;

public class PostController {
	
	private static final PostModel postModel = new PostModel();
	
	public Boolean create(String title,String image,String description) {
		
		Post post = new Post(title,image,description);
		return postModel.createPost(post);
		
	}
	
	public List<Post> showAllPost(){
		
		return postModel.showAllPost();
	}
	
	public Boolean delete(Long id) {
		
		return postModel.delete(id);
	}
	
	public List<Post> searchPostByTitle(String cSeq){
		
		return  postModel.showAllPost().stream()
				.filter(p -> p.getTitle().toLowerCase().contains(cSeq)).toList();
	}
}
