package org.zipcode.luckyMoney;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.zipcode.luckyMoney.Entity.Luckymoney;
import org.zipcode.luckyMoney.Service.LuckymoneyService;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 *Created by Yang Shu
 * 2019- 05 - 06
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckymoneyServiceTest {

    @Autowired
    private LuckymoneyService luckymoneyService;

    @Test
    public void findOneTest(){
        Luckymoney luckymoney = luckymoneyService.findOne(11);
        Double result = 5.00;
        DecimalFormat expertF = new DecimalFormat("0.00");
        String expert = expertF.format(result);
        String Actual = luckymoney.getMoney().toString();

        Assert.assertEquals(expert,Actual);
    }

}
