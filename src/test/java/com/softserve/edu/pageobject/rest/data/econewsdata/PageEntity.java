package com.softserve.edu.pageobject.rest.data.econewsdata;

import java.util.List;

public class PageEntity {
    private String creationDate;
    private String imagePath;
    private long id;
    private String title;
    private String text;
    private String source;
    private AuthorEntity authorEntity;
    private List<String> tags;

    public PageEntity(String creationDate, String imagePath, int id, String title, String text, String source
            , AuthorEntity authorEntity, List<String> tags) {
        this.creationDate = creationDate;
        this.imagePath = imagePath;
        this.id = id;
        this.title = title;
        this.text = text;
        this.source = source;
        this.authorEntity = authorEntity;
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

    public AuthorEntity getAuthor() {
        return authorEntity;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "PageEntity{" +
                "creationDate='" + creationDate + '\'' +
                ", imagePath='" + imagePath + '\'' +
                ", id=" + id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", source='" + source + '\'' +
                ", authorEntity=" + authorEntity +
                ", tags=" + tags +
                '}';
    }
}
