package com.example.doancoso1.Giaodien;

import com.example.doancoso1.JDBC.DatabaseConnection;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Thongtin1 {
	
	@FXML
	private Label hieuung;
	
	private String sodienthoai;
	
	// Phương thức để thiết lập số điện thoại
	public void setSodienthoai(String sodienthoai) {
		this.sodienthoai = sodienthoai;
	}
	
	public void initialize() {
		// Tạo TranslateTransition để thực hiện hiệu ứng chuyển động
		TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(10), hieuung);
		
		// Thiết lập giá trị thay đổi vị trí
		translateTransition.setFromX(-200); // Vị trí bắt đầu trái ra
		translateTransition.setToX(200);    // Vị trí kết thúc phải vào
		
		// Lặp lại vô hạn
		translateTransition.setCycleCount(TranslateTransition.INDEFINITE);
		// Xác định chiều di chuyển
		translateTransition.setAutoReverse(true);
		
		// Bắt đầu hiệu ứng
		translateTransition.play();
		
		comboBoxStatus();
	}
	
	@FXML
	private Button Luu;
	
	@FXML
	private Button avatars1;
	
	@FXML
	private TextField bietdanh;
	
	@FXML
	private ChoiceBox<String> chon;
	private String[] statusList = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "22"};
	
	
	
	public void comboBoxStatus() {
		List<String> listS = new ArrayList<>();
		for (String data : statusList) {
			listS.add(data);
		}
		ObservableList<String> listStatus = FXCollections.observableArrayList(listS);
		chon.setItems(listStatus);
	}
	
	@FXML
	private DatePicker data1;
	
	@FXML
	private TextField diachi;
	
	@FXML
	private Button huy1;
	
	@FXML
	private ImageView img;
	
	@FXML
	private Button sua1;
	
	@FXML
	private Button xoa1;
	
	@FXML
	void Luu1(ActionEvent event) {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String soValue = chon.getValue();
			String bietdanhValue = bietdanh.getText();
			String ngaysinhValue = data1.getValue().toString();
			String diachiValue = diachi.getText();
			String imagePath = getImagePathFromImageView();
			
			String insertQuery = "INSERT INTO user (sodienthoai, ngaysinh, bietdanh, diachi, img) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, sodienthoai);
			preparedStatement.setString(2, ngaysinhValue);
			preparedStatement.setString(3, bietdanhValue);
			preparedStatement.setString(4, diachiValue);
			preparedStatement.setString(5, imagePath);
			
			int rowsInserted = preparedStatement.executeUpdate();
			if (rowsInserted > 0) {
				showAlert("Thông báo", "Lưu thông tin tài khoản thành công");
				bietdanh.clear();
				diachi.clear();
				img.setImage(null);
			} else {
				showAlert("Lỗi", "Không thể lưu thông tin tài khoản!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			showAlert("Lỗi", "Đã xảy ra lỗi khi lưu thông tin vào cơ sở dữ liệu!");
		}
	}
	
	
	private void showAlert(String title, String message) {
		// Implement alert dialog here
	}
	
	private String getImagePathFromImageView() {
		Image image = img.getImage();
		
		if (image == null || image.getUrl() == null) {
			return null;
		}
		
		String imagePath = image.getUrl();
		
		if (imagePath.startsWith("file:")) {
			imagePath = imagePath.substring(5);
		}
		
		return imagePath;
	}
	
	
	@FXML
	void avatars(ActionEvent event) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Chọn ảnh");
		
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Hình ảnh (*.jpg, *.png, *.gif)", "*.jpg", "*.png", "*.gif");
		fileChooser.getExtensionFilters().add(extFilter);
		
		Stage stage = (Stage) avatars1.getScene().getWindow();
		File file = fileChooser.showOpenDialog(stage);
		
		if (file != null) {
			try {
				Image image = new Image(file.toURI().toString());
				img.setImage(image);
			} catch (Exception e) {
				e.printStackTrace();
				showErrorAlert("Đã xảy ra lỗi khi tải ảnh!");
			}
		}
		
	}
	
	private void showErrorAlert(String message) {
		// Implement error alert dialog here
	}
	
	@FXML
	void back(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Giaodien/Thongtin.fxml"));
			Parent root = loader.load();
			Scene newScene = new Scene(root);
			Stage currentStage = (Stage)((Node) event.getSource()).getScene().getWindow();
			currentStage.setScene(newScene);
			currentStage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void data(ActionEvent event) {
		// Do something with date action event
	}
	
	@FXML
	void huy(ActionEvent event) {
		// Do something with cancel action event
	}
	
	@FXML
	void sua(ActionEvent event) {
		// Do something with edit action event
	}
	
	@FXML
	void xoa(ActionEvent event) {
		// Do something with delete action event
	}
	
}
