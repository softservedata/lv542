package com.softserve.edu.pageobject.rest.data.econewsdata;

import java.util.List;

public class Page {
    private String creationDate;
    private String imagePath;
    private long id;
    private String title;
    private String text;
    private String source;
    private Author author;
    private List<String> tags;

    public Page(String creationDate, String imagePath, int id, String title, String text, String source
            , Author author, List<String> tags) {
        this.creationDate = creationDate;
        this.imagePath = imagePath;
        this.id = id;
        this.title = title;
        this.text = text;
        this.source = source;
        this.author = author;
        this.tags = tags;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getImagePath() {
        return imagePath;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    public Author getAuthor() {
        return author;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Page{" +
                "creationDate='" + creationDate + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", author=" + author +
                ", tags=" + tags +
                '}';
    }
}
