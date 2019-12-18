package lab5java;

import javafx.beans.property.SimpleStringProperty;

public class Book {

	protected final SimpleStringProperty author;
	protected final SimpleStringProperty yearOfPublishing;
	protected final SimpleStringProperty amountOfPages;
	protected final SimpleStringProperty publishingHouse;

	Book(String authorF, String yearOfPublishingF, String amountOfPagesF, String publishingHouseF) {
		this.author = new SimpleStringProperty(authorF);
		this.yearOfPublishing = new SimpleStringProperty(yearOfPublishingF);
		this.amountOfPages = new SimpleStringProperty(amountOfPagesF);
		this.publishingHouse = new SimpleStringProperty(publishingHouseF);
	}

	public String getAuthor() {
		return author.get();
	}

	public String getYearOfPublishing() {
		return yearOfPublishing.get();
	}

	public String getAmountOfPages() {
		return amountOfPages.get();
	}

	public String getPublishingHouse() {
		return publishingHouse.get();
	}

	public void setAuthor(String authorF) {
		author.set(authorF);
	}

	public void setYearOfPublishing(String yearOfPublishingF) {
		yearOfPublishing.set(yearOfPublishingF);
	}

	public void setAmountOfPages(String amountOfPagesF) {
		amountOfPages.set(amountOfPagesF);
	}

	public void setPublishingHouse(String publishingHouseF) {
		publishingHouse.set(publishingHouseF);
	}

}
