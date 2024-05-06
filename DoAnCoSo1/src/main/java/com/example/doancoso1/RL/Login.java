package com.example.doancoso1.RL;

import com.example.doancoso1.Giaodien.Thongtin1;
import com.example.doancoso1.JDBC.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;


public class Login {
    
    private String sodienthoai;
    
    public void setSodienthoai(String sodienthoai) {
        this.sodienthoai = sodienthoai;
    }
    
    @FXML
    private CheckBox Check;
    
    @FXML
    private TextField sodienthoai1;
    
    @FXML
    private TextField email1;
    
    @FXML
    private PasswordField matkhau1;
    
    
    @FXML
    private MediaView media3;
    
    public void initialize() {
        String videoFile = "E:\\anhdownload\\vutru.mp4";
        Media media = new Media(new File(videoFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        media3.setMediaPlayer(mediaPlayer);
        media3.getMediaPlayer().setAutoPlay(true);
        
        // Bắt sự kiện kết thúc của video
        mediaPlayer.setOnEndOfMedia(() -> {
            // Đặt thời gian của video về 0 để bắt đầu lại
            mediaPlayer.seek(Duration.ZERO);
        });
    }
    
    
    @FXML
    void Login1(ActionEvent event) throws IOException {
        String sodienthoai = sodienthoai1.getText();
        String email = email1.getText();
        String matkhau = matkhau1.getText();
        
        if (sodienthoai.isEmpty() || email.isEmpty() || matkhau.isEmpty()) {
            showAlert("Lỗi", "Vui lòng điền đầy đủ thông tin!");
            return;
        }
        
        if (DatabaseConnection.checkLogin(sodienthoai, email, matkhau)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Giaodien/Home.fxml"));
                Parent root = loader.load();
                
                Stage stage = new Stage();
                stage.setTitle("THẦN SỐ HỌC");
                
                Scene scene = new Scene(root);
                stage.setScene(scene);
                
                stage.show();
                
                Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                currentStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Lỗi");
            alert.setHeaderText(null);
            alert.setContentText("Số điện thoại, Email hoặc Mật khẩu không đúng. Vui lòng thử lại!");
            alert.showAndWait();
        }
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Giaodien/Thongtin1.fxml"));
        Parent root = loader.load();
        Thongtin1 controller = loader.getController();
        controller.setSodienthoai(sodienthoai);
    }
    
    
    @FXML
    void Register1(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Register.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Đăng Ký");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            stage.show();
            
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @FXML
    void quen(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Quenmk.fxml"));
            Parent root = loader.load();
            
            Stage stage = new Stage();
            stage.setTitle("Quên Mật Khẩu?");
            
            Scene scene = new Scene(root);
            stage.setScene(scene);
            
            stage.show();
            
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            currentStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
