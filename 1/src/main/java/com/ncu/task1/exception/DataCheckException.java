package com.ncu.task1.exception;

/**
 * @author 周佳玲
 * @date 2019-07-14 15:30
 */
public class DataCheckException extends RuntimeException {
    public DataCheckException(){
        super();
    }
    public DataCheckException(String msg){
        super(msg);
    }
}
