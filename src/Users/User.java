package Users;

public class User {
    private final String email;
    private final String password;
    private final int phoneNumber;

    public boolean checkPassword(String pass){
        return pass.equals(this.password);
    }

    public User(String email, String pass, int phoneNumber){
        this.email = email;
        this.password = pass;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
