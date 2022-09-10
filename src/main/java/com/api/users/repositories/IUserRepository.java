package com.api.users.repositories;

import com.api.users.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
