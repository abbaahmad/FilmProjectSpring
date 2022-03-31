package com.flexisaf.fip.filmproject.configurations;

import com.flexisaf.fip.filmproject.models.Role;
import com.flexisaf.fip.filmproject.models.User;
import com.flexisaf.fip.filmproject.repositories.RoleRepository;
import com.flexisaf.fip.filmproject.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserConfig {
    @Bean
    CommandLineRunner UserCommandLineRunner(UserRepository userRepository, RoleRepository roleRepository){
        return args -> {
            User user = new User("hello1","hello1", "hello1");
            User user1 = new User("hello2","hello2", "hello2");
            userRepository.saveAll(List.of(user, user1));
            Role role1 = new Role("Normal");
            Role role2 = new Role("Normal");
            roleRepository.saveAll(List.of(role1, role2));
        };
    }
}
