package atd_limud.models;

public class User {

    private String userId;
    private String username;
    private String password;
    private String email;
    private String phoneNumber;

    public User(String userId, String username, String password, String email, String phoneNumber) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


}
