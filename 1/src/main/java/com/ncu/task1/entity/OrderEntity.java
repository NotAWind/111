package com.ncu.task1.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author 周佳玲
 * @date 2019-07-14 00:08
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "money")
    private double money;
    @Column(name = "receiverAddress")
    private String receiverAddress;
    @Column(name = "receiverPhone")
    private String receiverPhone;
    @Column(name = "receiverName")
    private String receiverName;
    @Column(name = "paystate")
    private int payState;
    @Column(name = "ordertime")
    private LocalDateTime orderTime;
    @Column(name = "user_id")
    private int userId;


}
