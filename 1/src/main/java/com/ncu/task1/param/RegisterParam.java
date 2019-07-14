package com.ncu.task1.param;

import lombok.*;

/**
 * @author 周佳玲
 * @date 2019-07-13 12:32
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class RegisterParam {
    private String username;
    private String password;
    private String gender;
    private String telephone;
    private String email;
    private String introduce;
    private String activeCode;

}
