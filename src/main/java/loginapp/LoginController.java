package loginapp;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    private LoginModel model = new LoginModel();

    @FXML
    private Label dbstatus;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private ComboBox<Option> combobox;

    @FXML
    private Button loginButton;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if (model.isDatabaseConnected()) {
            dbstatus.setText("Connected");
        } else {
            dbstatus.setText("Not Connected");
        }

        combobox.setItems(FXCollections.observableArrayList(Option.values()));
    }

    public void login(ActionEvent event) {

    }

    public void studentLogin() {

    }

    public void adminLogin() {

    }
}
