package com.example.doancoso1.Giaodien;

import com.example.doancoso1.JDBC.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

public class Home {

	@FXML
	private CheckBox checkbox1;

	@FXML
	private CheckBox checkbox2;

	@FXML
	private TextArea comment;

	@FXML
	private DatePicker data;

	@FXML
	private DatePicker date1;

	@FXML
	private TextField firstName;

	@FXML
	private TextField firstName1;

	@FXML
	private ComboBox<?> gioiTinh;

	@FXML
	private TextField lastName;

	@FXML
	private Text luotDangKy;

	@FXML
	private Text luotTraCuu;

	@FXML
	private AnchorPane panel_comment;

	@FXML
	private TextField sodienthoai;

	@FXML
	private Hyperlink thongtin1;

	@FXML
	private Button tra;

	@FXML
	private VBox vbox1;

	@FXML
	private VBox vbox2;

	@FXML
	void DISC(ActionEvent event) {

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
	void cacchiso(ActionEvent event) {

	}

	@FXML
	void cunghoangdao(ActionEvent event) {

	}

	@FXML
	public void initialize() {
		displayDataOnLuotTraCuu();
		displayDataOnLuotDangKy();
	}

	NumberFormat formatter = new DecimalFormat("#,###");
	private void displayDataOnLuotTraCuu() {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT solantracuu FROM tracuu";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			int totalSolanTraCuu = 0;
			while (resultSet.next()) {
				int solantracuu = resultSet.getInt("solantracuu");
				totalSolanTraCuu += solantracuu;
			}

			// Định dạng số và gán vào text luotTraCuu
			luotTraCuu.setText(formatter.format(totalSolanTraCuu));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void displayDataOnLuotDangKy() {
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT COUNT(*) AS rowCount FROM user";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int rowCount = resultSet.getInt("rowCount");
				luotDangKy.setText("" + rowCount);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@FXML
	void dangxuat(ActionEvent event) {
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
	void danhxung(ActionEvent event) {

	}

	@FXML
	void dattencongai(ActionEvent event) {

	}

	@FXML
	void dattencontrai(ActionEvent event) {

	}

	@FXML
	void gioithieu(ActionEvent event) {
		try {
			MenuItem menuItem = (MenuItem) event.getSource();
			ContextMenu contextMenu = menuItem.getParentPopup();
			Node node = contextMenu.getOwnerNode();
			Scene scene = node.getScene();
			Stage stage = (Stage) scene.getWindow();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Giaodien/Gioithieu.fxml"));
			Parent root = loader.load();

			Stage gioiThieuStage = new Stage();
			gioiThieuStage.setTitle("Giới thiệu");

			Scene gioiThieuScene = new Scene(root);
			gioiThieuStage.setScene(gioiThieuScene);

			gioiThieuStage.show();

			stage.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void gui(ActionEvent event) {
		String commentText = comment.getText();
		if (!commentText.isEmpty()) {
			// Tạo một luồng mới để gửi comment
			Thread sendCommentThread = new Thread(() -> {
				try {
					// Lấy thông tin người dùng từ cơ sở dữ liệu
					String userId = getUserIdFromDatabase(); // Thay thế bằng phương thức lấy id từ cơ sở dữ liệu
					String hoTen = getHoTenFromDatabase(userId); // Lấy Họ và Tên từ cơ sở dữ liệu

					// Kết nối tới server
					Socket socket = new Socket(InetAddress.getByName("localhost"), 25689);

					// Tạo đối tượng để gửi dữ liệu tới server
					DataOutputStream outputStream = new DataOutputStream(socket.getOutputStream());

					// Gửi userId, commentText và thời gian hiện tại tới server
					outputStream.writeBytes(userId + "\n");
					outputStream.writeBytes(commentText + "\n");
					outputStream.writeBytes(new Date().toString() + "\n");

					// Đóng kết nối
					socket.close();

					// Hiển thị thông báo gửi thành công
					Platform.runLater(() -> {
						// Thêm mã hiển thị thông báo gửi thành công tại đây (nếu cần)
					});
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
			sendCommentThread.start();
		}
	}

	private String getUserIdFromDatabase() {
	return null;
	}

	private String getHoTenFromDatabase(String userId) {
		String hoTen = "";
		try (Connection connection = DatabaseConnection.getConnection()) {
			String query = "SELECT ho, ten FROM user WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, userId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next()) {
				String ho = resultSet.getString("ho");
				String ten = resultSet.getString("ten");
				hoTen = ho + " " + ten;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return hoTen;
	}



	@FXML
	void home(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Giaodien/Home.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Trang Chủ");

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
	void khaisinh(ActionEvent event) {

	}

	@FXML
	void lienhe(ActionEvent event) {
		try {
			MenuItem menuItem1 = (MenuItem) event.getSource();
			ContextMenu contextMenu1 = menuItem1.getParentPopup();
			Node node1 = contextMenu1.getOwnerNode();
			Scene scene1 = node1.getScene();
			Stage stage1 = (Stage) scene1.getWindow();

			FXMLLoader loader1 = new FXMLLoader(getClass().getResource("/Giaodien/Lienhe.fxml"));
			Parent root1 = loader1.load();

			Stage lienHeStage = new Stage();
			lienHeStage.setTitle("Liên Hệ");

			Scene lienHeScene = new Scene(root1);
			lienHeStage.setScene(lienHeScene);

			lienHeStage.show();

			stage1.close();
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
	void search(ActionEvent event) {

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
	void thongtin(ActionEvent event) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Giaodien/Thongtin.fxml"));
			Parent root = loader.load();

			Stage stage = new Stage();
			stage.setTitle("Thông Tin");

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
