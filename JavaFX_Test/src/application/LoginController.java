package application;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import spearsystem.DatabaseHandler;

public class LoginController {

	@FXML
	private TextField usernameField;

	@FXML
	private PasswordField passwordField;

	@FXML 
	private Button loginButton;

	// PAZ BACKEND
	private final DatabaseHandler backend = new DatabaseHandler();

	@FXML
	private void handleLogin(ActionEvent event) throws IOException {
		String username = usernameField.getText();
		String password = passwordField.getText();

		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("Please fill in both fields!");
			return;
		}

		if (username.equals("admin") && password.equals("admin")) {
			System.out.println("Login success: " + username);
		
		} else {
			System.out.println("Login failed: " + backend.getAuthStatus());
		}

		passwordField.clear();
	}
}