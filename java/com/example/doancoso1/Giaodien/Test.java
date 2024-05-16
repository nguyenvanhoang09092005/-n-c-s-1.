package com.example.doancoso1.Giaodien;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Date;

public class Test {

    @FXML
    private TextArea comment;

    @FXML
    private Text name;

    @FXML
    private Text time;

    @FXML
    private AnchorPane panel_comment;

    @FXML
    private TextArea textarea_comment;

    @FXML
    private VBox vbox_comment;

    @FXML
    private AnchorPane vbox_panel;

    private Socket socket;
    private DataOutputStream outputStream;

    // Khởi tạo kết nối tới server khi khởi động
    @FXML
    public void initialize() {
        try {
            socket = new Socket("localhost", 25689); // Kết nối tới server, cổng 25689
            outputStream = new DataOutputStream(socket.getOutputStream());
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
                    // Gửi comment và thời gian tới server
                    outputStream.writeUTF(commentText);
                    outputStream.writeUTF(new Date().toString()); // Gửi thời gian hiện tại
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            sendCommentThread.start();

            // Tạo VBox mới và các yếu tố bên trong
            Platform.runLater(() -> {
                Text nameText = new Text("Your Name"); // Thay "Your Name" bằng tên thực của người bình luận
                Text timeText = new Text(new Date().toString()); // Thời gian hiện tại
                TextArea newCommentArea = new TextArea(commentText);
                newCommentArea.setEditable(false); // Không cho phép chỉnh sửa comment
                newCommentArea.setWrapText(true); // Cho phép tự động xuống dòng khi đến cuối ô

                // Tạo nút xóa và xử lý sự kiện xóa
                Button deleteButton = new Button("Xóa");
                deleteButton.setOnAction(e -> {
                    // Xác định VBox cha của nút xóa
                    Node parentVBox = deleteButton.getParent();
                    if (parentVBox instanceof VBox) {
                        // Xóa VBox chứa comment
                        vbox_comment.getChildren().remove(parentVBox);
                    }
                });

                // Thêm các yếu tố vào VBox mới
                VBox newVBox = new VBox(nameText, timeText, newCommentArea, deleteButton);
                newVBox.setSpacing(5); // Đặt khoảng cách giữa các phần tử trong VBox
                vbox_comment.getChildren().add(newVBox); // Thêm VBox mới vào VBox chứa các comment
            });

            // Xóa nội dung của TextArea sau khi gửi
            comment.clear();
        }
    }

    @FXML
    void xoa(ActionEvent event) {
        // Xác định comment cần xóa và thực hiện xóa nó từ cơ sở dữ liệu

        // Sau khi xóa thành công, cập nhật giao diện
        vbox_comment.getChildren().clear(); // Xóa tất cả các comment trong VBox
    }

    private void displayComment(String commentText, String userName, String commentTime) {
        Platform.runLater(() -> {
            Text nameText = new Text(userName);
            Text timeText = new Text(commentTime);
            TextArea commentArea = new TextArea(commentText);
            VBox newVBox = new VBox(nameText, timeText, commentArea);
            newVBox.setSpacing(5); // Đặt khoảng cách giữa các phần tử trong VBox
            vbox_comment.getChildren().add(newVBox); // Thêm VBox mới vào VBox chứa các comment
        });
    }

}
