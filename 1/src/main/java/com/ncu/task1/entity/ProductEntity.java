package com.ncu.task1.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author 周佳玲
 * @date 2019-07-14 00:22
 */
@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "category")
    private String category;
    @Column(name = "price")
    private double price;
    @Column(name = "description")
    private String description;
    @Column(name = "pnum")
    private int pnum;
    @Column(name = "imgurl")
    private String imgurl;
}
