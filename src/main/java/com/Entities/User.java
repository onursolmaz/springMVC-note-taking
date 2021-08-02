package com.Entities;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "kisiler")
@Getter
@Setter
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

    private String key;

    private String pass;

    private boolean isActive=false;

}
