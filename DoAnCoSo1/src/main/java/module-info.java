module com.example.doancoso1 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.media;
	requires java.sql;
	requires java.sql.rowset;
	requires mysql.connector.java;

	
	opens com.example.doancoso1 to javafx.fxml;
	exports com.example.doancoso1;
	exports com.example.doancoso1.RL;
	opens com.example.doancoso1.RL to javafx.fxml;
	exports com.example.doancoso1.Giaodien;
	opens com.example.doancoso1.Giaodien to javafx.fxml;
}
