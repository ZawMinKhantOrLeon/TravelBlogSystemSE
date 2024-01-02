package view;

import java.util.Scanner;
import controller.PostController;

public class PostView {
	
	
	public void create(Scanner userInput) {
		userInput.nextLine();
		System.out.println("Enter your Title");
		String title= userInput.nextLine();
		System.out.println("Enter your Image");
		String image = userInput.nextLine();
		System.out.println("Enter your Description");
		String description = userInput.nextLine();
		
		PostController  postController = new PostController();
		
		 if(postController.create(title, image, description)) {
			 System.out.println("Successfully Created Post");
		 }else {
			 System.out.println("Fail to Created Post");
		 }
	}
}
