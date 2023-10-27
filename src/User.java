import java.util.HashMap;

public class User implements UserLogin {

    protected final HashMap<String, String> loginDetails = new HashMap<>();
    protected HashMap<String, String> register = new HashMap<>();

    public User() {
        setLoginDetails();
    }

    private void setLoginDetails() {
        loginDetails.put("Admin", "123");
    }

    public boolean login(String username, String password) {
        if(loginDetails.containsKey(username) && loginDetails.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean register(String username, String password) {
        if (register.containsKey(username) && register.get(username).equals(password)) {
            return true;
        }
        return false;
    }

    public void setRegister(String username, String password) {
        register.put(username, password);
        System.out.println("Account registered successfully...");
    }
}

