package atd_limud.utils;

public class InputValidator {
    public static boolean isValidUsername(String username) {
        return username != null && username.length() <= 20 && !username.trim().isEmpty();
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.length() <= 30 && !password.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        if (email == null || email.length() > 30) return false;
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }

    public static boolean isValidPhoneNumber(String phone) {
        if (phone == null || phone.isEmpty()) return true; // רשות
        return phone.matches("\\d{10,11}");
    }
}
