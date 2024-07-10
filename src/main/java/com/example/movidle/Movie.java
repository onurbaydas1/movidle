package com.example.movidle;

public class Movie {
    private int no;
    private String title, year, genre, origin, director, star;

    public Movie(int no, String title, String year, String genre, String origin, String director, String star) {
        this.no = no;
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.origin = origin;
        this.director = director;
        this.star = star;
    }

    public int getNo() {
        return no;
    }

    public String getTitle() {
        return title;
    }

    public String getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDirector() {
        return director;
    }

    public String getStar() {
        return star;
    }
}