package com.example.doancoso1.Giaodien;

import com.example.doancoso1.JDBC.DatabaseConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Random;

public class Thongtin1 {
	
	@FXML
	private Button Luu;
	
	@FXML
	private Button avatars1;
	
	@FXML
	private TextField bietdanh;
	
	@FXML
	private ChoiceBox<?> chon;
	
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
//		try (Connection connection = DatabaseConnection.getConnection()) {
//			String bietdanhValue = bietdanh.getText();
//			String ngaysinhValue = data1.getDate();
//			String diachiValue = diachi.getText();
//			String soValue = chon.getText();
//			String imagePath = getImagePathFromImageView();
//
//			String insertQuery = "INSERT INTO banking (ngaysinh, bietdanh, sochudao, diachi, img) VALUES (?, ?, ?, ?, ?)";
//			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
//			preparedStatement.setString(1, ngaysinhValue);
//			preparedStatement.setString(2, bietdanhValue);
//			preparedStatement.setString(3, soValue);
//			preparedStatement.setString(4, diachiValue);
//			preparedStatement.setString(5, imagePath);
//
//			int rowsInserted = preparedStatement.executeUpdate();
//			if (rowsInserted > 0) {
//				showAlert("Thông báo", "Tạo tài khoản thành công! Số thẻ của bạn là: " + soThe);
//				ho1.clear();
//				ten1.clear();
//				sodienthoai1.clear();
//				img1.setImage(null);
//			} else {
//				showAlert("Lỗi", "Không thể tạo tài khoản!");
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//			showAlert("Lỗi", "Đã xảy ra lỗi khi tạo tài khoản. Vui lòng thử lại sau!");
//		}
//	}
//
//	private void showAlert(String lỗi, String s) {
//	}
//
//	private String getImagePathFromImageView() {
//		Image image = img.getImage();
//
//		if (image == null || image.getUrl() == null) {
//			return null;
//		}
//
//		String imagePath = image.getUrl();
//		
//		if (imagePath.startsWith("file:")) {
//			imagePath = imagePath.substring(5);
//		}
//
//		return imagePath;
//	}
	
	
//	private String generateRandomCardNumber() {
//		Random random = new Random();
//		StringBuilder cardNumber = new StringBuilder();
//		for (int i = 0; i < 12; i++) {
//			int digit = random.nextInt(10);
//			cardNumber.append(digit);
//		}
//		return cardNumber.toString();
//	}
//
	
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
	
	private void showErrorAlert(String s) {
	}
	
	@FXML
	void data(ActionEvent event) {
	
	}
	
	@FXML
	void huy(ActionEvent event) {
	
	}
	
	@FXML
	void sua(ActionEvent event) {
	
	}
	
	@FXML
	void xoa(ActionEvent event) {
	
	}
	
}
