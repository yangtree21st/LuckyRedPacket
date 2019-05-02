package org.zipcode.luckyMoney.Utils;

import org.zipcode.luckyMoney.Entity.Result;

import java.security.Provider;

public class ResultUtil {

    public static Result success(Object object){
        Result result = new Result();
        result.setCode(0);
        result.setMessage("Success");
        result.setData(object);
        return result;
    }

    public static Result error(Integer code, String message){
        Result result = new Result();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    public static Result success(){
        return success(null);
    }
}
