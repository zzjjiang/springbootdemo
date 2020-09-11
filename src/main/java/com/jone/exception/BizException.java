package com.jone.exception;

/**
 * @author zzj
 * @description
 * @date 2020.09.11
 */
public class BizException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String code = "-1";

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String code ,String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}