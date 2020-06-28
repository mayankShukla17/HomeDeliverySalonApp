package com.example.mayank.rock_paper_scissor;


public class Pardeep {
    private String name;
    private int numOfSongs;
    private int thumbnail;

    public Pardeep() {
    }

    public Pardeep(String name,  int thumbnail) {
        this.name = name;

        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}
