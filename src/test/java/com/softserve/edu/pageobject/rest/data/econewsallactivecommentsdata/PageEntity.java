package com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata;

public class PageEntity {
    private long id;
    private String modifiedDate;
    private AuthorEntity author;
    private String text;
    private long replies;
    private long likes;
    private boolean currentUserLiked;
    private String status;

    public PageEntity(long id, String modifiedDate, AuthorEntity author, String text, int replies, int likes
            , boolean currentUserLiked, String status) {
        this.id = id;
        this.modifiedDate = modifiedDate;
        this.author = author;
        this.text = text;
        this.replies = replies;
        this.likes = likes;
        this.currentUserLiked = currentUserLiked;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public AuthorEntity getAuthors() {
        return author;
    }

    public String getText() {
        return text;
    }

    public long getReplies() {
        return replies;
    }

    public long getLikes() {
        return likes;
    }

    public boolean isCurrentUserLiked() {
        return currentUserLiked;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Pages{" +
                "id=" + id + "\n" +
                ", modifiedDate='" + modifiedDate + '\'' + "\n" +
                ", authors=" + author + "\n" +
                ", text='" + text + '\'' + "\n" +
                ", replies=" + replies + "\n" +
                ", likes=" + likes + "\n" +
                ", currentUserLiked=" + currentUserLiked + "\n" +
                ", status='" + status + '\'' + "\n" +
                '}';
    }
}
