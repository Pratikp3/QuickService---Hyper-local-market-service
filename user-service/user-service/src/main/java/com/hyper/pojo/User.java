package com.hyper.pojo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
public class User extends BaseEntity {

    @Column(length = 70, unique = true, nullable = false)
    private String username;

    @Column(length = 70, unique = true, nullable = false)
    @Email(regexp = "^[A-Za-z0-9+_,-]+@(.+)$")
    private String email;

    @Column(length = 70, unique = true, nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(length = 70, nullable = false)
    private Role role;

    @Column(length = 255, nullable = false)
    private String address;

    @Column(length = 50, nullable = false)
    private String contact;


}
