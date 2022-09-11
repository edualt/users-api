package com.api.users.controllers;

import com.api.users.controllers.dtos.CreateUserRequest;
import com.api.users.controllers.dtos.CreateUserResponse;
import com.api.users.controllers.dtos.UserResponse;
import com.api.users.entities.User;
import com.api.users.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    IUserService service;

    @GetMapping("/{id}")
    public UserResponse get(@PathVariable Long id){
        return service.get(id);
    }

    @GetMapping
    public List<UserResponse> get(){
        return service.get();
    }

    @PostMapping
    public CreateUserResponse create(@Valid @RequestBody CreateUserRequest request){
        return service.create(request);
    }

    @PutMapping("/{id}")
    public UserResponse update(@Valid @RequestBody CreateUserRequest request, @PathVariable Long id){
        return service.update(request, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }
}
