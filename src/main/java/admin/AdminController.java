package admin;

import dbutil.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AdminController implements Initializable {

    @FXML
    private TextField id;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField email;
    @FXML
    private DatePicker dob;

    @FXML
    private TableView<StudentData> studentTable;
    @FXML
    private TableColumn<StudentData, String> idCol;
    @FXML
    private TableColumn<StudentData, String> firstNameCol;
    @FXML
    private TableColumn<StudentData, String> lastNameCol;
    @FXML
    private TableColumn<StudentData, String> emailCol;
    @FXML
    private TableColumn<StudentData, String> dobCol;


    @FXML
    private Button addEntry;
    @FXML
    private Button clearForm;
    @FXML
    private Button loadData;

    @FXML
    private ObservableList<StudentData> list;
    private DbConnection db;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        db = new DbConnection();
    }

    @FXML
    private void loadStudentData(ActionEvent event) {
        try {
            Connection connection = DbConnection.getConnection();
            list = FXCollections.observableArrayList();

            String query = "select * from students";
            ResultSet rs = connection.createStatement().executeQuery(query);

            while (rs.next()) {
                list.add(new StudentData(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (SQLException e) {
            System.err.println("Eror " + e);
        }

        idCol.setCellValueFactory(new PropertyValueFactory<StudentData, String>("id"));
        firstNameCol.setCellValueFactory(new PropertyValueFactory<StudentData, String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<StudentData, String>("lastName"));
        emailCol.setCellValueFactory(new PropertyValueFactory<StudentData, String>("email"));
        dobCol.setCellValueFactory(new PropertyValueFactory<StudentData, String>("dob"));

        studentTable.setItems(null);
        studentTable.setItems(list);
    }

    @FXML
    private void addEntry(ActionEvent event) {
        String query = "INSERT INTO students (id, fname, lname, email, dob) VALUES (?, ?, ?, ?, ?)";

        try {
            Connection connection = DbConnection.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, id.getText());
            ps.setString(2, firstName.getText());
            ps.setString(3, lastName.getText());
            ps.setString(4, email.getText());
            ps.setString(5, dob.getEditor().getText());

            ps.execute();
            ps.close();
            connection.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clearForm() {
        id.setText("");
        firstName.setText("");
        lastName.setText("");
        email.setText("");
        dob.setValue(null);
    }
}
