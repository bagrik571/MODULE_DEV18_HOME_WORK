package com.example.module_dev18_home_work.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userId;

    @Column(name = "username")
    @NotNull
    @Size(min = 2, max = 50)
    private String username;

    @Column(name = "password")
    @NotNull
    @Size(min = 10, max = 150)
    private String pass;

    @Column(name = "email")
    @NotNull
    @Size(min = 10)
    private String userEmail;

    @Column(name = "created date")
    private LocalDate createdDate;

    @Column(name = "last updated date")
    private LocalDate updatedDate;

    @Column(name = "role")
    private String role;

    @Column(name = "enabled")
    @NotNull
    private boolean enabled;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Note> notes = new ArrayList<>();


    public User(Long userId) {
        this.userId = userId;
    }


}
// user vitalii571, pass=vitalii
// admin vitaliiAdmin, pass=admin