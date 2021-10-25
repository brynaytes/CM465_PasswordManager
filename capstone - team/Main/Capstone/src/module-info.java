module Capstone {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires javafx.base;
	requires mysql.connector.java;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml, javafx.base;
}
