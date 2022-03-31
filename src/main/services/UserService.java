package com.flexisaf.fip.filmproject.services;

import com.flexisaf.fip.filmproject.models.Role;
import com.flexisaf.fip.filmproject.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    Optional<User> getUser(String username);
    List<User> getUsers();
    void deleteUser(String username);
    void updateUser(String username, String currentPassword, String newPassword);
}
