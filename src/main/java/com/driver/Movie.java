package com.driver;
public class Movie {
    private String name;
    private int durationInMinutes;
    private double imbRating;
    public Movie(){

    }
    public Movie(String name, int durationInMinutes, double imbRating) {
        this.name = name;
        this.durationInMinutes = durationInMinutes;
        this.imbRating = imbRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public double getImbRating() {
        return imbRating;
    }

    public void setImbRating(double imbRating) {
        this.imbRating = imbRating;
    }
}
