package org.tensorflow.lite.examples.classification.models;

public class Place {

    private String name;
    private String description;
    private int thumbnail;
    private int coverPhoto;


    public Place(String name, int thumbnail, int coverPhoto) {
        this.name = name;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public Place(String name, int thumbnail) {
        this.name = name;
        this.thumbnail = thumbnail;
    }


    public Place(String name, String description, int thumbnail, int coverPhoto) {
        this.name = name;
        this.description = description;
        this.thumbnail = thumbnail;
        this.coverPhoto = coverPhoto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(int coverPhoto) {
        this.coverPhoto = coverPhoto;
    }
}
