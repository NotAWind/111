package com.ncu.task1.exception;

/**
 * @author 周佳玲
 * @date 2019-07-13 13:41
 */
public class ExistException extends RuntimeException {
    public ExistException(){
        super();
    }
    public ExistException(String message){
        super(message);
    }
}
