package com.xmlparser.model;

import java.time.LocalDate;
import java.util.Date;

public class Book {

    private String id;
    private String author;
    private String title;
    private String genre;
    private double price;
    private LocalDate publishDate;
    private String description;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "\n id='" + id + '\'' +
                "\n author='" + author + '\'' +
                "\n title='" + title + '\'' +
                "\n genre='" + genre + '\'' +
                "\n price=" + price +
                "\n publishDate=" + publishDate +
                "\n description='" + description + '\'' +
                '}';
    }
}
