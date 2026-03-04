package com.deploy.praktikum1.service.Impl;

import com.deploy.praktikum1.mapper.UserMapper;
import com.deploy.praktikum1.model.dto.UserAddRequest;
import com.deploy.praktikum1.model.dto.UserDto;
import com.deploy.praktikum1.model.entity.User;
import com.deploy.praktikum1.repository.UserRepository;
import com.deploy.praktikum1.service.UserService;
import com.deploy.praktikum1.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ValidationUtil validationUtil;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, ValidationUtil validationUtil) {
        this.userRepository = userRepository;
        this.validationUtil = validationUtil;
    }

    @Override
    public UserDto AddUser(UserAddRequest request) {
        validationUtil.validate(request);

        User user = User.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName())
                .age(request.getAge())
                .build();

        userRepository.save(user);
        return UserMapper.MAPPER.toUserDtoData(user);
    }

    @Override
    public List<UserDto> getAllUser() {
        return userRepository.findAll().stream()
                .map(UserMapper.MAPPER::toUserDtoData)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto getUserById(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        return UserMapper.MAPPER.toUserDtoData(user);
    }

    @Override
    public UserDto UpdateUser(String id, UserAddRequest request) {
        validationUtil.validate(request);

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));

        user.setName(request.getName());
        user.setAge(request.getAge());

        userRepository.save(user);
        return UserMapper.MAPPER.toUserDtoData(user);
    }

    @Override
    public void DeleteUser(String id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not found"));
        userRepository.delete(user);
    }
}
