package application;

import java.io.StringReader;

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
	private void handleLogin(ActionEvent event) {
		String username = usernameField.getText();
		String password = passwordField.getText();

		if (username.isEmpty() || password.isEmpty()) {
			System.out.println("Please fill in both fields!");
			return;
		}

		// authenticate() wants a Reader, so wrap the String
		boolean success = backend.authenticate(username, new StringReader(password));

		if (success) {
			System.out.println("Login success: " + username);
			// TODO: load the admin or custodian screen here
		} else {
			System.out.println("Login failed: " + backend.getAuthStatus());
		}

		passwordField.clear();
	}
}