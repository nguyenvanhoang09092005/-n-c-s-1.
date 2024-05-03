package com.example.doancoso1.Giaodien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Thongtin {
	
	@FXML
	private ImageView avatar;
	
	
	@FXML
	private Text hienthibietdanh;
	
	@FXML
	private Text hienthidiachi;
	
	@FXML
	private Text hienthiemail;
	
	@FXML
	private Text hienthiho;
	
	@FXML
	private Text hienthiid;
	
	@FXML
	private Text hienthingaysinh;
	
	@FXML
	private Text hienthisdt;
	
	@FXML
	private Text hienthisochudao;
	
	@FXML
	private Text hienthisolandangnhap;
	
	@FXML
	private Text hienthiten1;
	
	
	@FXML
	private Button thaydoi5;
	
	
	
	@FXML
	void DISC(ActionEvent event) {
	
	}
	
	@FXML
	void bietdanh5(MouseEvent event) {
	
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
	void capnhat5a(ActionEvent event) {
	
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
	void diachi5(MouseEvent event) {
	
	}
	
	@FXML
	void dkdn(ActionEvent event) {
	
	}
	
	@FXML
	void email5(MouseEvent event) {
	
	}
	
	@FXML
	void gioithieu(ActionEvent event) {
	
	}
	
	@FXML
	void ho5(MouseEvent event) {
	
	}
	
	@FXML
	void home(ActionEvent event) {
	
	}
	
	
	@FXML
	void id(MouseEvent event) {
	
	}
	
	@FXML
	void khaisinh(ActionEvent event) {
	
	}
	
	@FXML
	void landangnhap(MouseEvent event) {
	
	}
	
	@FXML
	void lienhe(ActionEvent event) {
	
	}
	
	@FXML
	void login5(ActionEvent event) {
	
	}
	
	@FXML
	void ngaysinh(ActionEvent event) {
	
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
	
	}
	
	@FXML
	void sdt5(MouseEvent event) {
	
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
	void sochudao(MouseEvent event) {
	
	}
	
	
    
	@FXML
	void ten5(MouseEvent event) {
	
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
	void thaydoi5a(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/doancoso1/Giaodien/thongtin1.fxml"));
			Parent root = loader.load();
			
			// Tạo một Popup
			Popup popup = new Popup();
			popup.getContent().add(root);
			popup.setAutoHide(true); // Tự động ẩn Popup khi click ra ngoài
			popup.show(((Node) event.getSource()).getScene().getWindow());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@FXML
	void thongtin(ActionEvent event) {
	
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
