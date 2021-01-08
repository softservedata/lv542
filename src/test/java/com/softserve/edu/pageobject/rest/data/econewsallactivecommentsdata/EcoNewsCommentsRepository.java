package com.softserve.edu.pageobject.rest.data.econewsallactivecommentsdata;

public class EcoNewsCommentsRepository {
    private String comment;
    private long ecoNewsPageId;

    public EcoNewsCommentsRepository(String comment, long ecoNewsPageId) {
        this.comment = comment;
        this.ecoNewsPageId = ecoNewsPageId;
    }

    public String getComment() {
        return comment;
    }

    public long getEcoNewsPageId() {
        return ecoNewsPageId;
    }
}
