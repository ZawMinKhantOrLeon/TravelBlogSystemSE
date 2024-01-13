package view;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import controller.PostController;
import model.Post;

public class PostView {
	
	private static final PostController postController = new PostController();
	
	public void create(Scanner userInput) {
		userInput.nextLine();
		System.out.println("\033[0;33m Enter your Title \u001B[0m");
		String title= userInput.nextLine();
		System.out.println("\033[0;33m Enter your Image \u001B[0m");
		String image = userInput.nextLine();
		System.out.println("\033[0;33m Enter your Description \u001B[0m");
		String description = userInput.nextLine();
		
		
		 if(postController.create(title, image, description)) {
			 System.out.println("\033[1;32m Successfully Created Post \u001B[0m");
		 }else {
			 System.out.println("\033[0;33m Fail to Created Post \u001B[0m");
		 }
	}
	
	public void showAll() {
		
		List<Post> allPost=postController.showAllPost();
		Optional<Post> optionalPost = Optional.empty();
		
		if(!allPost.isEmpty()) {
			for(final Post p:allPost) {
				optionalPost = Optional.of(p);
				if(optionalPost.isPresent()) {
						Post post = optionalPost.get();
						printPost(post);
				}
			}
		}
		
	}
	
	public void delete(Scanner userInput) {
		System.out.println("\033[0;33m Enter The Id Of the Post You wanted to delete : \u001B[0m");
		Long id = userInput.nextLong();
		
		if(postController.delete(id)) {
			System.out.println("\033[1;32m Post Number " + id + " is deleted \u001B[0m");
		}
		else {
			System.out.println("\033[0;33m Post deletion fail \u001B[0m");
		}
	}
	
	public void searchPostByTitle(Scanner userInput) {
			
			userInput.nextLine();
			System.out.println("\033[0;33m Enter the title you want to search :  \u001B[0m");
			String title = userInput.nextLine();
			List<Post> allPost=postController.searchPostByTitle(title);
			Optional<Post> optionalPost = Optional.empty();
			
			if(!allPost.isEmpty()) {
				for(final Post p:allPost) {
					optionalPost = Optional.of(p);
					if(optionalPost.isPresent()) {
							Post post = optionalPost.get();
							printPost(post);
					}
				}
			}
			else {
				System.out.println("\033[0;33m There is no such post \u001B[0m");
			}
		
	}
	
	public void update(Scanner userInput) {
		userInput.nextLine();
		System.out.println("\033[0;33m Enter the movie Id you want to update : \u001B[0m ");
		Long id = userInput.nextLong();
		Optional<Post> optionalPost = postController.searchPostById(id);
		
		if(!optionalPost.isPresent()) {
			System.out.println("\033[0;33m There is no such post \u001B[0m");
			return;
		}
		Post post = optionalPost.get();
		printPost(post);
		
		while(true) {
			System.out.println("\033[0;33m Update Operations 1.Title 2.Image 3.Description \u001B[0m");
			Integer operation = userInput.nextInt();
			switch (operation) {
			case 1 ->{
				System.out.println("\033[0;33m Updating Title \u001B[0m");
				String title = userInput.next();
				post.setTitle(title);
			}
			case 2->{
				System.out.println("\033[0;33m Updating Image \u001B[0m");
				String image = userInput.next();
				post.setImage(image);
			}
			
			case 3->{
				System.out.println("\033[0;33m Updating Description \u001B[0m");
				userInput.nextLine();
				String description = userInput.next();
				post.setDescription(description);
			}
			
			default ->
			{
				 System.out.println("\033[0;33m Existing from operations \u001B[0m");
				 break;
			}
			}
			
			userInput.nextLine();
			System.out.println("\033[0;33m Do you want to stop Updating ? yes/y no/n \u001B[0m");
			Character decision = userInput.nextLine().charAt(0);
			if(decision == 'y') {
				break;
			}
		}
		if(postController.update(post)) {
			System.out.println("\033[1;32m Post successfully updated \u001B[0m");
		}else {
			System.out.println("\033[0;33m Post fail to update \u001B[0m");
		}
		
	
	}
	
	
	
	
	//utility methods
	
	private void printPost(Post post) {
		
			System.out.println("\033[1;36m Post id : "+post.getId() + "\u001B[0m");
			System.out.println("\033[1;36m Post author : "+post.getAuthor() + "\u001B[0m");
			System.out.println("\033[1;36m Post Title : "+post.getTitle() + "\u001B[0m");
			System.out.println("\033[1;36m Post Image : "+post.getImage() + "\u001B[0m");
			System.out.println("\033[1;36m Post Description : "+post.getDescription() + "\u001B[0m");
			System.out.println("\033[1;36m Post Creation Date : "+post.getDate() + "\u001B[0m");
			System.out.println();
		
	}

	
	
}
