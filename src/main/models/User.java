package com.flexisaf.fip.filmproject.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "users")
public class User implements Serializable {
    @Id
    @SequenceGenerator(
            name="user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    private Long id;
    private String name;
    private String username;
    private String password;
    
    @ManyToMany(fetch=FetchType.EAGER)
    @JoinColumn(name="roles_id")
    private List<Role> roles;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public User(){}
    public User(Long id, String name, String username, String password, List<Role> roles){
        this.id = id;
        this.name = name;
        this.username = username;
        this.password=password;
        this.roles = roles;
    }
    public User(String name, String username, String password){
        this.name = name;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + "[password]" + '\'' +
                '}';
    }
}
