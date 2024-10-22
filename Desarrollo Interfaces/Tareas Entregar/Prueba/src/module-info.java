module Prueba {
	requires javafx.controls;
	requires javafx.fxml;
	
	opens prueba to javafx.graphics, javafx.fxml;
}
