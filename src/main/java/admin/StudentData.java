package admin;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StudentData {

        private final StringProperty id;
        private final StringProperty firstName;
        private final StringProperty lastName;
        private final StringProperty email;
        private final StringProperty dob;

        public StudentData(String id, String firstName, String lastName, String email, String dob) {
            this.id = new SimpleStringProperty(id);
            this.firstName = new SimpleStringProperty(firstName);
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

        public String getFirstName() {
            return firstName.get();
        }

        public StringProperty firstNameProperty() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName.set(firstName);
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
