package com.deploy.praktikum1.controller;

import com.deploy.praktikum1.model.dto.UserAddRequest;
import com.deploy.praktikum1.model.dto.UserDto;
import com.deploy.praktikum1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> AddUser(@RequestBody UserAddRequest request) {
        UserDto result = userService.AddUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of(
                "status", "success",
                "data", result));
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllUser() {
        List<UserDto> result = userService.getAllUser();
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getUserById(@PathVariable String id) {
        UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> UpdateUser(@PathVariable String id,
            @RequestBody UserAddRequest request) {
        UserDto result = userService.UpdateUser(id, request);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> DeleteUser(@PathVariable String id) {
        userService.DeleteUser(id);
        return ResponseEntity.ok(Map.of(
                "status", "success",
                "data", "success delete user with id " + id));
    }
}
