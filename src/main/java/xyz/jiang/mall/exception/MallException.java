package xyz.jiang.mall.exception;

/**
 * @Program: mall
 * @Classname MallException
 * @Description:
 * @Author: JiangKan
 * @Create: 2020-10-05
 **/
public class MallException extends RuntimeException{
    private final Integer code;
    private final String msg;

    public MallException(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public MallException(MallExceptionEnum exceptionEnum) {
        this(exceptionEnum.getCode(), exceptionEnum.getMsg());
    }
}
