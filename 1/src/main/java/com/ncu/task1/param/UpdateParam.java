package com.ncu.task1.param;

import lombok.*;

/**
 * @author 周佳玲
 * @date 2019-07-14 15:13
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UpdateParam {
    private String username;
    private String oldPassword;
    private String newPassword;
    private String gender;
    private String telephone;
}
