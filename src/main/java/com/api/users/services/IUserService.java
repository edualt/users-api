package com.api.users.services;

import com.api.users.controllers.dtos.CreateUserRequest;
import com.api.users.controllers.dtos.CreateUserResponse;
import com.api.users.controllers.dtos.UserResponse;
import com.api.users.entities.User;

import java.util.List;

public interface IUserService {

    List<UserResponse> get();

    UserResponse get(Long id);
    CreateUserResponse create(CreateUserRequest request);

    UserResponse update(CreateUserRequest request, Long id);
    void delete(Long id);
}
