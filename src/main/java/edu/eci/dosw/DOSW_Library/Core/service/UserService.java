package edu.eci.dosw.DOSW_Library.Core.service;

import edu.eci.dosw.DOSW_Library.Core.model.User;
import edu.eci.dosw.DOSW_Library.Core.exception.UserNotFoundException;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private Map<String, User> users = new HashMap<>();

    public User createUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public User getUser(String id) {
        User user = users.get(id);
        if (user == null) {
            throw new UserNotFoundException("Usuario no encontrado");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User updateUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    public void deleteUser(String id) {
        users.remove(id);
    }
}
