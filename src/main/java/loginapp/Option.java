package loginapp;

public enum  Option {
    Admin, Student;

    private Option() {}

    public String value() {
        return name();
    }

    public static Option fromValue(String v) {
        return valueOf(v);
    }
}
