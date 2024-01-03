package view;

import java.util.List;
import java.util.Scanner;
import controller.PostController;
import model.Post;

public class PostView {
	
	private static final PostController postController = new PostController();
	
	public void create(Scanner userInput) {
		userInput.nextLine();
		System.out.println("Enter your Title");
		String title= userInput.nextLine();
		System.out.println("Enter your Image");
		String image = userInput.nextLine();
		System.out.println("Enter your Description");
		String description = userInput.nextLine();
		
		
		 if(postController.create(title, image, description)) {
			 System.out.println("Successfully Created Post");
		 }else {
			 System.out.println("Fail to Created Post");
		 }
	}
	
	public void showAll() {
		
		List<Post> allPost=postController.showAllPost();
		checkEmpty(allPost);
		
	}
	
	public void delete(Scanner userInput) {
		System.out.println("Enter The Id Of the Post You wanted to delete : ");
		Long id = userInput.nextLong();
		
		if(postController.delete(id)) {
			System.out.println("Post Number " + id + " is deleted");
		}
		else {
			System.out.println("Post deletion fail");
		}
	}
	
	public void searchPostByTitle(Scanner userInput) {
			
			System.out.println("Enter the title you want to search : ");
			String title = userInput.nextLine();
			List<Post> allPost=postController.searchPostByTitle(title);
			checkEmpty(allPost);
		
	}
	
	public void update(Scanner userInput) {
		System.out.println("Enter the movie Id you want to update : ");
		Long id = userInput.nextLong();
		Post post = postController.searchPostById(id);
		
		if(post.getId() == null) {
			System.out.println("There is no such post");
			return;
		}
		showPost(post);
		
		while(true) {
			System.out.println("1.Title 2.Image 3.Description");
			Integer operation = userInput.nextInt();
			switch (operation) {
			case 1 ->{
				System.out.println("Updating Title");
				String title = userInput.next();
				post.setTitle(title);
			}
			case 2->{
				System.out.println("Updating Image");
				String image = userInput.next();
				post.setImage(image);
			}
			
			case 3->{
				System.out.println("Updating Description");
				userInput.nextLine();
				String description = userInput.nextLine();
				post.setDescription(description);
			}
			
			default ->
			throw new IllegalArgumentException("Unexpected value: " + operation);
			}
			
			
			System.out.println("Do you want to keep Updating ? yes/y no/n ");
			Character decision = userInput.nextLine().charAt(0);
			if(decision == 'y') {
				break;
			}
		}
		if(postController.update(post)) {
			System.out.println("Post successfully updated");
		}else {
			System.out.println("Post fail to update");
		}
		
	
	}
	
	
	
	
	//utility methods
	
	private void showPost(Post post) {
		System.out.println("Post id : "+post.getId());
		System.out.println("Post Title : "+post.getTitle());
		System.out.println("Post Image : "+post.getImage());
		System.out.println("Post Description : "+post.getDescription());
		System.out.println("Post Creation Date : "+post.getDate());
	}
	
	private void checkEmpty(List<Post> posts) {
		
		if(!posts.isEmpty()) {
			posts.forEach((p)->{
				showPost(p);
			});
		}
		else {
			System.out.println("There is no posts");
		}
	}
	
	
}
