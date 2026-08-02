package com.ecommerce.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

//@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String passwordHash;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    private String phone;
    //status

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    /*
    public User(Long id, String email, String password,
                String firstName, String lastName, String phone,
                LocalDateTime createdAt,LocalDateTime updatedAt){
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public User(){};
     */
    /**
     * 问题：
     * 1. 假设以后你执行
     * userRepository.save(user);
     * 请你按自己的理解说一下：
     * 从执行这一行代码开始，一直到 PostgreSQL 最终插入一条数据，中间发生了什么？
     *
     * 2.什么时候会真正调用
     * @AllArgsConstructor
     * Spring 会调用吗？
     * 还是你自己调用？
     *
     * 3. 为什么 JPA 一定需要
     * @NoArgsConstructor
     */
}
