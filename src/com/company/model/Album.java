package com.company.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Album {
    private String title;
    private Date releaseAt;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseAt() {
        return releaseAt;
    }

    public void setReleaseAt(Date releaseAt) {
        this.releaseAt = releaseAt;
    }

    public void setReleaseAt(String releaseAt) {
        DateFormat dateFormat = new SimpleDateFormat("MM/DD/YYYY");
        try {
            this.releaseAt = dateFormat.parse(releaseAt);
        } catch (ParseException e) {
            this.releaseAt = null;
            e.printStackTrace();
        }
    }

    public void setReleaseAt(long releaseAt) {
        this.releaseAt = new Date(releaseAt);
    }

    public void setReleaseAt(int year, int month, int day) {
        this.releaseAt = new Date(year, month, day);
    }

    public String toString() {
        return "Album: " + title + ", " + releaseAt;
    }
}