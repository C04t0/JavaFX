package jfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Home extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

    System.out.println(getClass().getResource("/ui.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ui.fxml"));
        GridPane gridPane= loader.load();

        Scene scene = new Scene(gridPane);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        Application.launch();
    }

}

