package org.zipcode.luckyMoney.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zipcode.luckyMoney.Entity.Luckymoney;
import org.zipcode.luckyMoney.Repository.LuckymoneyRepository;

import java.math.BigDecimal;

@Service
public class LuckymoneyService {

    @Autowired
    private LuckymoneyRepository repository;



    //
    @Transactional
    public void creatTwo(){
        Luckymoney luckymoneyTest = new Luckymoney();
        luckymoneyTest.setProducer("Yang Shu");
        luckymoneyTest.setMoney(new BigDecimal("520"));
        repository.save(luckymoneyTest);


        Luckymoney luckymoneyTest2 = new Luckymoney();
        luckymoneyTest2.setProducer("Yang Shu");
        luckymoneyTest2.setMoney(new BigDecimal("1314"));
        repository.save(luckymoneyTest2);
    }
}
