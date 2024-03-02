package com.pawnprudence.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(unique = true)
    private String email;
    private String password;
    private Date dateCreated;
    private Date lastLogin;

    public User(String email, String password, Date dateCreated, Date lastLogin) {
        this.email = email;
        this.password = password;
        this.dateCreated = dateCreated;
        this.lastLogin = lastLogin;
    }

    public User() {

    }

}
