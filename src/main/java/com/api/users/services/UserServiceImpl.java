package com.api.users.services;

import com.api.users.controllers.dtos.CreateUserRequest;
import com.api.users.controllers.dtos.CreateUserResponse;
import com.api.users.controllers.dtos.UserResponse;
import com.api.users.entities.User;
import com.api.users.exception.UserNotFoundException;
import com.api.users.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    IUserRepository repository;

    @Override
    public UserResponse get(Long id){
        User user = findAndEnsureExist(id);
        return toGetUserResponse(user);
    }

    @Override
    public List<UserResponse> get(){
        List<User> users = repository.findAll();
        return users.stream().map(this::toGetUserResponse).collect(Collectors.toList());
    }

    @Override
    public CreateUserResponse create(CreateUserRequest request) {
        User user = repository.save(from(request));
        return toCreateUserResponse(user);
    }

    @Override
    public UserResponse update(CreateUserRequest request, Long id) {
        User user = findAndEnsureExist(id);
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        repository.save(user);
        return toGetUserResponse(user);
    }

    @Override
    public void delete(Long id){
        get(id);
        repository.deleteById(id);
    }

    private User from(CreateUserRequest request){
        User user = new User();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        return user;
    }

    private CreateUserResponse toCreateUserResponse(User user){
        CreateUserResponse response = new CreateUserResponse();
        response.setEmail(user.getEmail());
        response.setUsername(user.getUsername());
        return response;
    }

    private UserResponse toGetUserResponse(User user){
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        return response;
    }

    private User findAndEnsureExist(Long id){
        return repository.findById(id).orElseThrow(() -> new UserNotFoundException("no"));
    }
}
