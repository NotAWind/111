package com.ncu.task1.entity;

import lombok.*;

import java.io.Serializable;

/**
 * @author 周佳玲
 * @date 2019-07-14 09:38
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class OrderItemMultiKeys implements Serializable {
    private int orderId;
    private int productId;
}
