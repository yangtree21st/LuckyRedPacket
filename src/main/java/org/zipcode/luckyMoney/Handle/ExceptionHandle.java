package org.zipcode.luckyMoney.Handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zipcode.luckyMoney.Entity.Result;
import org.zipcode.luckyMoney.Exception.LuckyMoneyException;
import org.zipcode.luckyMoney.Utils.ResultUtil;


@ControllerAdvice
public class ExceptionHandle {

    private final static Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {
        if (e instanceof LuckyMoneyException) {
            LuckyMoneyException luckyMoneyException = (LuckyMoneyException) e;
            return ResultUtil.error(luckyMoneyException.getCode(), luckyMoneyException.getMessage());
        } else {
            logger.error("[System error]{}",e);
            return ResultUtil.error(-1, "unknow errors");
        }

    }
}
