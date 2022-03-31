package com.flexisaf.fip.filmproject.services;

import com.flexisaf.fip.filmproject.models.Role;
import com.flexisaf.fip.filmproject.models.User;
import com.flexisaf.fip.filmproject.repositories.RoleRepository;
import com.flexisaf.fip.filmproject.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
 public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository){
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    public List<User> getUsers(){
        return userRepository.findAll();
    }
    @Override
    public Optional<User> getUser(String username){ return userRepository.findByUsername(username);}

    @Override
    public Role saveRole(Role role){
        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String name, String roleName){
        Optional<User> user = userRepository.findByUsername(name);
        Optional<Role> role = roleRepository.findByName(roleName);
        if(user.isPresent() && role.isPresent()){
            user.get().getRoles().add(role.get());
            userRepository.save(user.get());
        }
    }

    @Override
    public User addUser(User user) {
        Optional<User> username = userRepository.findByUsername(user.getUsername());
        if (username.isPresent()) {
            throw new IllegalStateException("User already exists");
        }
        return userRepository.save(user);
    }

    public void deleteUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()) throw new IllegalStateException("No such user: "+username);
        userRepository.delete(user.get());
    }

    //@Transactional
    public void updateUser(String username, String currentPassword, String newPassword) {
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isEmpty()){
            throw new IllegalStateException("No such user: "+username);
        }

        if (Objects.equals(user.get().getPassword(), currentPassword) && !Objects.equals(currentPassword, newPassword)) {
            user.get().setPassword(newPassword);
        }
        userRepository.save(user.get());
    }
}
