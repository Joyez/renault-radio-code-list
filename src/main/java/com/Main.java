package com;

import com.utilies.Paths;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(Paths.PATH_MAIN_WINDOW));
            primaryStage.setScene(new Scene(root));
            primaryStage.setResizable(false);
            primaryStage.setTitle("Radio code generator");
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
