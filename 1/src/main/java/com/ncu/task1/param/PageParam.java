package com.ncu.task1.param;

import lombok.*;

/**
 * @author 周佳玲
 * @date 2019-07-14 08:54
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PageParam {
    //当前页数
    private Integer pageNum;

    //每页的条数
    private Integer pageLimit;
}
