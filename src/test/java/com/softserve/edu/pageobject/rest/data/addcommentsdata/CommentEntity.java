package com.softserve.edu.pageobject.rest.data.addcommentsdata;

public class CommentEntity {
    private long id;
    private AuthorEntity author;
    private String text;
    private String modifiedDate;

    public CommentEntity(long id, AuthorEntity authorEntity, String text, String modifiedDate) {
        this.id = id;
        this.author = authorEntity;
        this.text = text;
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public AuthorEntity getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "id=" + id +
                ", authorEntity=" + author +
                ", text='" + text + '\'' +
                ", modifiedDate='" + modifiedDate + '\'' +
                '}';
    }
}
