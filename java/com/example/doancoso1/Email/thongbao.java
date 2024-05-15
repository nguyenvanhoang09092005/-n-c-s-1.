package com.example.doancoso1.Email;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class thongbao {

    @FXML
    private TextField so1;

    @FXML
    private TextField so2;

    @FXML
    private TextField so3;

    @FXML
    private TextField so4;

    @FXML
    private TextField so5;

    @FXML
    private TextField so6;

    @FXML
    void initialize() {
        setupTextField(so1, so2);
        setupTextField(so2, so3);
        setupTextField(so3, so4);
        setupTextField(so4, so5);
        setupTextField(so5, so6);
        setupTextField(so6, null);
    }

    private void setupTextField(TextField currentField, TextField nextField) {
        currentField.addEventFilter(KeyEvent.KEY_TYPED, event -> {
            String character = event.getCharacter();
            if (!character.matches("\\d") || currentField.getText().length() == 1) {
                event.consume(); // Chỉ cho phép nhập số và không thêm nếu đã có số trong ô
            } else {
                currentField.setText(character);
                event.consume(); // Tiêu thụ sự kiện để tránh nhập lặp lại
                if (nextField != null) {
                    nextField.requestFocus(); // Chuyển focus đến trường văn bản tiếp theo
                }
            }
        });

        currentField.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case BACK_SPACE:
                    if (currentField.getText().isEmpty() && nextField != null) {
                        nextField.requestFocus();
                    }
                    break;
                default:
                    break;
            }
        });
    }



    @FXML
    void quaylai(ActionEvent event) {
        // Mã xử lý cho hành động quay lại
    }

    @FXML
    void xacnhan(ActionEvent event) {
        // Mã xử lý cho hành động xác nhận
    }
}
