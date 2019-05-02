package org.zipcode.luckyMoney.Entity;

public class Result<T> {
    //error code
    private Integer code;

    // error message
    private String messg;

    // content
    private T data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return messg;
    }

    public void setMessage(String message) {
        this.messg = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
