package com.ncu.task1.entity;

import lombok.*;
import sun.util.resources.LocaleData;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author 周佳玲
 * @date 2019-07-13 12:14
 */
@Entity
@Table(name = "user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email")
    private String email;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "introduce")
    private String introduce;
    @Column(name = "activeCode")
    private String activeCode;
    @Column(name = "state")
    private int state;
    @Column(name = "role")
    private String role;
    @Column(name = "registTime")
    private LocalDateTime registTime;
}
