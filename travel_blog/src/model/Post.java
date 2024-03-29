package model;

import java.time.LocalDate;

public class Post {
	
	private Long id;
	private Long user_id;
	private String title;
	private String image;
	private String description;
	private LocalDate date;
	private String author;
	
	public Post() {
		
	}
	
	

	public Post(String title, String image, String description) {
		super();
		this.title = title;
		this.image = image;
		this.description = description;
	}

	public Post(String title, String image, String description,LocalDate date) {
		super();
		this.title = title;
		this.image = image;
		this.description = description;
		this.date=date;
	}

	public Post(Long user_id, String title, String image, String description) {
		super();
		this.user_id = user_id;
		this.title = title;
		this.image = image;
		this.description = description;
	}
	
	
	
	public Post(Long id, Long user_id,String author, String title, String image, String description, LocalDate date) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.author=author;
		this.title = title;
		this.image = image;
		this.description = description;
		this.date = date;
	}



	public Post(Long id,String author, String title, String image, String description,LocalDate date) {
		super();
		this.id = id;
		this.title = title;
		this.image = image;
		this.description = description;
		this.date=date;
		this.author=author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	

	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public LocalDate getDate() {
		return date;
	}



	@Override
	public String toString() {
		return "Post [id=" + id + ", user_id=" + user_id + ", title=" + title + ", image=" + image + ", description="
				+ description + "]";
	}
	
	
}
