package com.ncu.task1.entity;

import lombok.*;

import javax.persistence.*;

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
@Table(name = "notice")
public class NoticeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "details")
    private String details;
    @Column(name = "n_time")
    private String n_time;
}
