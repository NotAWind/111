package com.ncu.task1.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 周佳玲
 * @date 2019-07-13 21:56
 */
@Getter
@Setter
public class JsonData<T> {
    private boolean ret;
    private String msg;
    private T data;

    public JsonData(boolean ret){
        this.ret = ret;
    }

    public static <T> JsonData<T> success(String msg,Object data){
        JsonData jsonData = new JsonData(true);
        jsonData.msg = msg;
        jsonData.data = data;
        return jsonData;
    }

    public static <T> JsonData<T> success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    public static <T> JsonData<T> success(){
        JsonData jsonData = new JsonData(true);
        return jsonData;
    }

    public static <T> JsonData<T> fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    public static <T> JsonData<T> fail(String msg,Object object){
        JsonData jsonData = new JsonData(false);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }

    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }

}
