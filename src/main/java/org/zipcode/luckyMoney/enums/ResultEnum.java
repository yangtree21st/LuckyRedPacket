package org.zipcode.luckyMoney.enums;

public enum ResultEnum {


    UNKNOWN_ERROR(-1, "Unknow errors"),
    SUCCESS(0,"Success"),
    FEW_MONEY(100,"The money is too few"),
    MUCH_MONEY(101,"The money is too high");

    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
