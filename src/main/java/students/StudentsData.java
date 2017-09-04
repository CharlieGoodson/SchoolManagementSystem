package students;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentsData {

    private final StringProperty id;
    private final StringProperty firstMame;
    private final StringProperty lastName;
    private final StringProperty email;
    private final StringProperty dob;

    public StudentsData(String id, String firstMame, String lastName, String email, String dob) {
        this.id = new SimpleStringProperty(id);
        this.firstMame = new SimpleStringProperty(firstMame);
        this.lastName = new SimpleStringProperty(lastName);
        this.email = new SimpleStringProperty(email);
        this.dob = new SimpleStringProperty(dob);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getFirstMame() {
        return firstMame.get();
    }

    public StringProperty firstMameProperty() {
        return firstMame;
    }

    public void setFirstMame(String firstMame) {
        this.firstMame.set(firstMame);
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getDob() {
        return dob.get();
    }

    public StringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }
}
