package com.ncu.task1.dto;

import lombok.*;

import java.util.List;

/**
 * @author 周佳玲
 * @date 2019-07-14 00:31
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserListDto {
    private List<UserSimDto> list;
}
