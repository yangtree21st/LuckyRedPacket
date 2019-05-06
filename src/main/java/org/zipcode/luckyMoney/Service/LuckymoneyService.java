package org.zipcode.luckyMoney.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zipcode.luckyMoney.Entity.Luckymoney;
import org.zipcode.luckyMoney.Exception.LuckyMoneyException;
import org.zipcode.luckyMoney.Repository.LuckymoneyRepository;
import org.zipcode.luckyMoney.enums.ResultEnum;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.Optional;

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

    public void getAmountOne(Integer id) throws Exception{
        Luckymoney luckymoney = repository.findById(id).get();
        BigDecimal money = luckymoney.getMoney();
        BigDecimal few = BigDecimal.valueOf(5);

        if(money.compareTo(few) < 0){
            // return "You give too few")
            throw new LuckyMoneyException(ResultEnum.FEW_MONEY);

        }else if ( money.compareTo(BigDecimal.valueOf(600)) > 0 ){
            // return "You give too much"
             throw new LuckyMoneyException(ResultEnum.MUCH_MONEY);
        }



    }
    /* find a luckymoney information by its id,
    * @param id
    * @return
     */
    public  Luckymoney findOne(Integer id){
        return repository.findById(id).get();
    }
}
