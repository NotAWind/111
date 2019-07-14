package com.ncu.task1.entity;

import lombok.*;

import javax.persistence.*;

/**
 * @author 周佳玲
 * @date 2019-07-14 00:09
 */
@Entity
@Table(name = "orderitem")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@IdClass(OrderItemMultiKeys.class)
public class OrderItemEntity {

    @Id
    @Column(name = "order_id")
    private int orderId;
    @Id
    @Column(name = "product_id")
    private int productId;
    @Column(name = "buy_num")
    private int buyNum;
}
