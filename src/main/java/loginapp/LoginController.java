package loginapp;

import admin.AdminController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import students.StudentsController;

import java.io.IOException;
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

    @FXML
    private Label loginStatus;

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
        if (combobox.getValue() == null) {
            loginStatus.setText("Wrong Credential");
            return;
        }
        try {
            String un = username.getText(), ps = password.getText(), cb = combobox.getValue().toString();

            if (model.isLogin(un, ps, cb)) {
                Stage stage = (Stage) loginButton.getScene().getWindow();
                stage.close();

                switch (((Option) combobox.getValue()).toString()) {
                    case "Admin":
                        adminLogin();
                        break;
                    case "Student":
                        studentLogin();
                        break;
                }
            } else {
                loginStatus.setText("Wrong Credential");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void studentLogin() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            Pane root = (Pane)loader.load(getClass().getResource("/fxml/student.fxml").openStream());

            StudentsController studentsController = (StudentsController) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Student Dashboard");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void adminLogin() {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader();
            AnchorPane root = loader.load(getClass().getResource("/fxml/admin.fxml").openStream());

//            AdminController adminController = (AdminController) loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Admin Dashboard");
            stage.setResizable(false);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
