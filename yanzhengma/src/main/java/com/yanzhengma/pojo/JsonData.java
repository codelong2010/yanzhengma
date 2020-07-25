package com.yanzhengma.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author xiaolong
 * @create 2020-07-24 23:38
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonData {
    private int code;

    private String msg;

    private Object data;

    public static JsonData success(int code, String msg, Object data){
        return new JsonData(code, msg, data);
    }
}
