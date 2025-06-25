import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users = new ArrayList<>();
    private Long nextId = 1L;
    // Create
    public User createUser(String name, String email) {
        User user = new User(nextId++, name, email);
        users.add(user);
        return user;
    }
    // Read (by ID)
    public User getUserById(Long id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
    // Read (all)
    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }
    // Update
    public boolean updateUser(Long id, String name, String email) {
        User user = getUserById(id);
        if (user != null) {
            user.setName(name);
            user.setEmail(email);
            return true;
        }
        return false;
    }
    // Delete
    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}