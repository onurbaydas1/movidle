package com.example.movidle;

import com.example.movidle.Movie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

class Procces {
    public static ArrayList<Movie> readMoviesFromCSV(String csv) {
        ArrayList<Movie> movies = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] record = line.split(";");
                int no = Integer.parseInt(record[0]);
                String title = record[1];
                String year = record[2];
                String genre = record[3];
                String origin = record[4];
                String director = record[5];
                String star = record[6];

                Movie movie = new Movie(no, title, year, genre, origin, director, star);
                movies.add(movie);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return movies;
    }
}