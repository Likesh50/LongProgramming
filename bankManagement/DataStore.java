package bankManagement;

import java.util.*;

public class DataStore {
    private Map<String, User> users = new HashMap<>();
    private Map<String, List<Transaction>> transactionMap = new HashMap<>();

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // user already exists
        }
        User user = new User(username, password);
        users.put(username, user);
        transactionMap.put(username, new ArrayList<>());
        return true;
    }

    public User loginUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        return null;
    }

    public void recordTransaction(String username, Transaction transaction) {
        transactionMap.get(username).add(transaction);
    }

    public List<Transaction> getTransactions(String username) {
        return transactionMap.getOrDefault(username, new ArrayList<>());
    }
}
