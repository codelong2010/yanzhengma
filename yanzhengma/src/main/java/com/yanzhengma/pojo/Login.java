package com.yanzhengma.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaolong
 * @create 2020-07-24 22:42
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Login {

    private String username;

    private String password;

    private String captcha;

}
