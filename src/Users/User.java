package Users;

public class User {
    private String email;
    private String password;
    private int phoneNumber;

    public boolean checkPassword(String pass){
        return pass.equals(this.password);
    }

    public void register(String email, String pass, int phoneNumber){
        this.email = email;
        this.password = pass;
        this.phoneNumber = phoneNumber;
    }

}
