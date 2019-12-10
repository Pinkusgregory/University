package lab4java;

import java.util.Scanner;

public class Book {

	String author;
	int yearOfPublishing;
	int amountOfPages;
	String publishingHouse;

	public Book(String author, int yearOfPublishing, int amountOfPages, String publishingHouse) {
		this.author = author;
		this.yearOfPublishing = yearOfPublishing;
		this.amountOfPages = amountOfPages;
		this.publishingHouse = publishingHouse;
	}

	public int getAmountOfPages() {
		return amountOfPages;
	}

	public String getAuthor() {
		return author;
	}

	public String getPublishingHouse() {
		return publishingHouse;
	}

	public int getYearOfPublishing() {
		return yearOfPublishing;
	}

	public void setAmountOfPages(int amountOfPages) {
		this.amountOfPages = amountOfPages;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublishingHouse(String publishingHouse) {
		this.publishingHouse = publishingHouse;
	}

	public void setYearOfPublishing(int yearOfPublishing) {
		this.yearOfPublishing = yearOfPublishing;
	}
	
	public static Book read(Scanner scn) {
		return new Book(scn.next(),scn.nextInt(),scn.nextInt(),scn.next());
	}

}
