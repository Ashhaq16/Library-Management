
package library_management_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class User_LoginController implements Initializable {

    @FXML
    private TextField userid;
    @FXML
    private TextField passid;
    @FXML
    private Label alertlabel;
    @FXML
    private Button btn1;
    @FXML
    private Hyperlink link;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void submit(ActionEvent event) {
        // Fetch user inputs
        String userIdInput = userid.getText();
        String passIdInput = passid.getText();
        if (userIdInput.isEmpty() || passIdInput.isEmpty()) {
            alertlabel.setText("User ID and Password cannot be empty.");
            return;
        }
    
        if (isValidUserId(userIdInput) && isValidPassword(passIdInput)) {
            alertlabel.setText("Login successful!");
            userid.clear();
            passid.clear();
        } else {
            alertlabel.setText("Invalid User ID or Password.");
        }
    }

    private boolean isValidUserId(String userId) {
        return userId.matches("[a-zA-Z0-9]{5,}");
    }

  
    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9]).{6,}$");
    }

    @FXML
    private void link1(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Admin Login.fxml"));
            Stage stage = (Stage) ((Hyperlink) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Admin Login Form");
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading AdminLogin.fxml: " + e.getMessage());
        }
    }
}
