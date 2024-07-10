package com.example.movidle;

import com.example.movidle.Movie;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class App extends Application {

    private ArrayList<Movie> movies;
    private int currentMovieIndex;
    private TextField guessTextField;

    @Override
    public void start(Stage stage) {
        String csv = "imdb_top_250.csv";
        movies = Procces.readMoviesFromCSV(csv);
        currentMovieIndex = getRandomMovieIndex();

        Pane root = new Pane();
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(200, 20, 20, 50));
        vBox.setSpacing(10);
        root.getChildren().add(vBox);

        Text text = new Text(430, 50, "Movidle");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        root.getChildren().add(text);

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(100, 10, 10, 410));
        hBox.setAlignment(Pos.CENTER);
        hBox.setSpacing(10);

        guessTextField = new TextField();
        Button guessBtn = new Button("Guess");
        guessBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String guess = guessTextField.getText();
                Movie currentMovie = movies.get(currentMovieIndex);
                boolean isWin = isWin(guess, currentMovie);
                showMovieDetails(currentMovieIndex, isWin);
                if (isWin) {
                    showWinAlert();
                    currentMovieIndex = getRandomMovieIndex();
                }
            }
        });

        hBox.getChildren().addAll(guessTextField, guessBtn);
        root.getChildren().addAll(hBox);

        Scene scene = new Scene(root, 1050, 900);
        stage.setScene(scene);
        stage.show();
    }

    private int getRandomMovieIndex() {
        return new Random().nextInt(movies.size());
    }

    private void showMovieDetails(int index, boolean isWin) {
        Movie movie = movies.get(index);

        Rectangle titleBox = new Rectangle(150, 150, isWin ? Color.GREEN : Color.WHITE);
        Text title = new Text(movie.getTitle());
        StackPane stackt = new StackPane();
        stackt.getChildren().addAll(titleBox, title);

        Rectangle yearBox = new Rectangle(150, 150, isWin ? Color.GREEN : Color.WHITE);
        Text year = new Text(movie.getYear());
        StackPane stacky = new StackPane();
        stacky.getChildren().addAll(yearBox, year);

        Rectangle genreBox = new Rectangle(150, 150, isWin ? Color.GREEN : Color.WHITE);
        Text genre = new Text(movie.getGenre());
        StackPane stackg = new StackPane();
        stackg.getChildren().addAll(genreBox, genre);

        Rectangle originBox = new Rectangle(150, 150, isWin ? Color.GREEN : Color.WHITE);
        Text origin = new Text(movie.getOrigin());
        StackPane stacko = new StackPane();
        stacko.getChildren().addAll(originBox, origin);

        Rectangle directorBox = new Rectangle(150, 150, isWin ? Color.GREEN : Color.WHITE);
        Text director = new Text(movie.getDirector());
        StackPane stackd = new StackPane();
        stackd.getChildren().addAll(directorBox, director);

        Rectangle starBox = new Rectangle(150, 150, isWin ? Color.GREEN : Color.WHITE);
        Text star = new Text(movie.getStar());
        StackPane stacks = new StackPane();
        stacks.getChildren().addAll(starBox, star);

        VBox movieDetails = new VBox(stackt, stacky, stackg, stacko, stackd, stacks);
        movieDetails.setSpacing(10);

        VBox vBox = (VBox) guessTextField.getParent().getParent();
        vBox.getChildren().add(movieDetails);
    }

    private void showWinAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Win");
        alert.setContentText("True");
        alert.showAndWait();
    }

    private boolean isWin(String guess, Movie movie) {
        return guess.equals(movie.getTitle());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
