package com.gruppo1.progetto.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
public class Authority {
    @Id
    private String username;
    private String authority;

    @OneToMany(mappedBy = "authority")
    private List<User> userList;
}
