import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class UserServiceTest {
    private UserService userService;

    @BeforeEach
    public void setUp() {
        userService = new UserService();
    }
    @Test
    public void testCreateUser() {
        User user = userService.createUser("Alice", "alice@example.com");
        assertNotNull(user);
        assertEquals("Alice", user.getName());
        assertEquals("alice@example.com", user.getEmail());
        assertNotNull(user.getId());
    }
    @Test
    public void testGetUserById() {
        User user = userService.createUser("Bob", "bob@example.com");
        User found = userService.getUserById(user.getId());
        assertNotNull(found);
        assertEquals("Bob", found.getName());
    }
    @Test
    public void testGetAllUsers() {
        userService.createUser("Carol", "carol@example.com");
        userService.createUser("Dave", "dave@example.com");
        List<User> users = userService.getAllUsers();
        assertEquals(2, users.size());
    }
    @Test
    public void testUpdateUser() {
        User user = userService.createUser("Eve", "eve@example.com");
        boolean updated = userService.updateUser(user.getId(), "Eve Updated", "eve.updated@example.com");
        assertTrue(updated);
        User updatedUser = userService.getUserById(user.getId());
        assertEquals("Eve Updated", updatedUser.getName());
        assertEquals("eve.updated@example.com", updatedUser.getEmail());
    }
    @Test
    public void testDeleteUser() {
        User user = userService.createUser("Frank", "frank@example.com");
        boolean deleted = userService.deleteUser(user.getId());
        assertTrue(deleted);
        assertNull(userService.getUserById(user.getId()));
    }
}