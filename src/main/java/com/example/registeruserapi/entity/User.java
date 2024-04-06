package com.example.registeruserapi.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Data
public class User {

    @Column(name = "is_active")
    boolean isActive;
    @Id
    @Column(name = "user_id")
    private String id;
    private String name;
    private String email;
    private String password;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Phones> phones;
    private LocalDateTime created;
    private LocalDateTime modified;
    @Column(name = "last_login")
    private LocalDateTime lastLogin;
    private String token;


}
