package org.zipcode.luckyMoney.Exception;

import org.zipcode.luckyMoney.enums.ResultEnum;

public class LuckyMoneyException extends RuntimeException {

    private Integer code;

    public LuckyMoneyException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
