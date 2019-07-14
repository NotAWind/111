package com.ncu.task1.exception;

/**
 * @author 周佳玲
 * @date 2019-07-13 23:32
 */
public class UnauthorizedException extends RuntimeException {
    public UnauthorizedException(){
        super();
    }
    public UnauthorizedException(String msg){
        super(msg);
    }
}
