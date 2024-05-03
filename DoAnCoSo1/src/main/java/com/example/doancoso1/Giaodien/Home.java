package com.example.doancoso1.Giaodien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class Home {
	
	@FXML
	private Label hienthiten;
	
	@FXML
	void DISC(ActionEvent event) {
	
	}
	
	@FXML
	void boidgtinhduyen(ActionEvent event) {
	
	}
	
	@FXML
	void boity1(ActionEvent event) {
	
	}
	
	@FXML
	void boity2(ActionEvent event) {
	
	}
	
	@FXML
	void boity3(ActionEvent event) {
	
	}
	
	@FXML
	void boity4(ActionEvent event) {
	
	}
	
	@FXML
	void boitybangten(ActionEvent event) {
	
	}
	
	@FXML
	void cacchiso(ActionEvent event) {
	
	}
	
	@FXML
	void cunghoangdao(ActionEvent event) {
	
	}
	
	@FXML
	void danhxung(ActionEvent event) {
	
	}
	
	@FXML
	void dattencongai(ActionEvent event) {
	
	}
	
	@FXML
	void dattencontrai(ActionEvent event) {
	
	}
	
	@FXML
	void dkdn(ActionEvent event) {
	
	}
	
	@FXML
	void gioithieu(ActionEvent event) {
	
	}
	
	@FXML
	void home(ActionEvent event) {
	
	}
	
	@FXML
	void khaisinh(ActionEvent event) {
	
	}
	
	@FXML
	void lienhe(ActionEvent event) {
	
	}
	
	@FXML
	void login5(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Login.fxml"));
			Parent root = loader.load();
			
			Stage stage = new Stage();
			stage.setTitle("Đăng nhập");
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
			stage.show();
			
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	@FXML
	void nhomC(ActionEvent event) {
	
	}
	
	@FXML
	void nhomD(ActionEvent event) {
	
	}
	
	@FXML
	void nhomI(ActionEvent event) {
	
	}
	
	@FXML
	void nhomS(ActionEvent event) {
	
	}
	
	@FXML
	void register5(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/Register.fxml"));
			Parent root = loader.load();
			
			Stage stage = new Stage();
			stage.setTitle("Đăng ký");
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
			stage.show();
			
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void so1(ActionEvent event) {
	
	}
	
	@FXML
	void so10(ActionEvent event) {
	
	}
	
	@FXML
	void so11(ActionEvent event) {
	
	}
	
	@FXML
	void so2(ActionEvent event) {
	
	}
	
	@FXML
	void so22(ActionEvent event) {
	
	}
	
	@FXML
	void so3(ActionEvent event) {
	
	}
	
	@FXML
	void so4(ActionEvent event) {
	
	}
	
	@FXML
	void so5(ActionEvent event) {
	
	}
	
	@FXML
	void so6(ActionEvent event) {
	
	}
	
	@FXML
	void so7(ActionEvent event) {
	
	}
	
	@FXML
	void so8(ActionEvent event) {
	
	}
	
	@FXML
	void so9(ActionEvent event) {
	
	}
	
	@FXML
	void tencongai(ActionEvent event) {
	
	}
	
	@FXML
	void tencontrai(ActionEvent event) {
	
	}
	
	@FXML
	void tenngdung(ActionEvent event) {
	
	}
	
	@FXML
	void tennguoisd(ActionEvent event) {
	
	}
	
	@FXML
	void thongtin(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Giaodien/Thongtin.fxml"));
			Parent root = loader.load();
			
			Stage stage = new Stage();
			stage.setTitle("Thông tin cá nhân");
			
			Scene scene = new Scene(root);
			stage.setScene(scene);
			
			stage.show();
			
			Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			currentStage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	void thongtincanhan(ActionEvent event) {
	
	}
	
	@FXML
	void tracuu1(ActionEvent event) {
	
	}
	
	@FXML
	void tracuu2(ActionEvent event) {
	
	}
	
	@FXML
	void tracuu3(ActionEvent event) {
	
	}
	
	@FXML
	void tracuu4(ActionEvent event) {
	
	}
	
	@FXML
	void tracuuDISc(ActionEvent event) {
	
	}
	
	@FXML
	void tracuuMBTI(ActionEvent event) {
	
	}
	
	@FXML
	void ynghiaten(ActionEvent event) {
	
	}
	
}
