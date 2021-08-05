package com.Entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "kisiler")
@Getter
@Setter
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    private String name;

    private String surname;

    private String email;

    private Date create_date = new Date();

    @Column(nullable = true)
    private String regKey;

    private String pass;

    @Transient  // don't create database as column
    private String pass2;

    private boolean isActive = false;

}
