package edu.eci.dosw.DOSW_Library.controller;

import edu.eci.dosw.DOSW_Library.Core.model.User;
import edu.eci.dosw.DOSW_Library.Core.service.UserService;
import edu.eci.dosw.DOSW_Library.controller.dto.UserDTO;
import edu.eci.dosw.DOSW_Library.controller.mapper.UserMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserDTO create(@RequestBody UserDTO dto) {
        User user = UserMapper.toModel(dto);
        return UserMapper.toDTO(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public UserDTO get(@PathVariable String id) {
        User user = userService.getUser(id);
        return UserMapper.toDTO(user);
    }

    @GetMapping
    public List<UserDTO> getAll() {
        return userService.getAllUsers().stream()
                .map(UserMapper::toDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public UserDTO update(@PathVariable String id, @RequestBody UserDTO dto) {
        User user = UserMapper.toModel(dto);
        user.setId(id);
        return UserMapper.toDTO(userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteUser(id);
    }
}
