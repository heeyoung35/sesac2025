package com.ohgiraffers.section02;

public class OnLineCourse {

    private String title;
    private String category;
    private int duration;
    private boolean isFree;

    public OnLineCourse(String title, String category, int duration, boolean isFree) {
        this.title = title;
        this.category = category;
        this.duration = duration;
        this.isFree = isFree;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getDuration() {
        return duration;
    }

    public boolean isFree() {
        return isFree;
    }

    @Override
    public String toString() {
        return "OnLineCourse{" +
                "title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", duration=" + duration +
                ", isFree=" + isFree +
                '}';
    }
}
