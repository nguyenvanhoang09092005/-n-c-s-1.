package com.example.doancoso1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/Email/thongbao.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.centerOnScreen();
//        stage.getIcons().add(new Image());
        stage.setResizable(false);
        stage.setTitle("Đăng Ký");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}