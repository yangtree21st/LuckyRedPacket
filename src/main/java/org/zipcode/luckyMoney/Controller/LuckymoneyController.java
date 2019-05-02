package org.zipcode.luckyMoney.Controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.zipcode.luckyMoney.Aspect.HttpAspect;
import org.zipcode.luckyMoney.Entity.Luckymoney;
import org.zipcode.luckyMoney.Entity.Result;
import org.zipcode.luckyMoney.Repository.LuckymoneyRepository;
import org.zipcode.luckyMoney.Service.LuckymoneyService;
import org.zipcode.luckyMoney.Utils.ResultUtil;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    /* the list of red pocket(Luckyjmoney) */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> luckymoneyList() {
        logger.info("luckymoneyList");
        return repository.findAll();
    }

    @PostMapping("/luckymoneys")
    public Result<Luckymoney> create(@Valid Luckymoney luckymoney, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){

            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        luckymoney.setProducer(luckymoney.getProducer());
        luckymoney.setMoney(luckymoney.getMoney());

//        Result result =new Result();
//        result.setCode(0);
//        result.setData(repository.save(luckymoney));

        return ResultUtil.success(repository.save(luckymoney));
    }

    // find the redpocket by id
    @GetMapping("/luckymoneys/{id}")
    public Luckymoney findById(@PathVariable("id") Integer id) {
        return repository.findById(id).orElse(null);
    }

    // receive the red pocket
    @PutMapping("/luckymoneys/{id}")
    public Luckymoney update(@PathVariable("id") Integer id,
                             @RequestParam("recipient") String recipient) {
        Optional<Luckymoney> optional = repository.findById(id);

        if (optional.isPresent()) {
            Luckymoney luckymoney = optional.get();

            luckymoney.setRecipient(recipient);
            return repository.save(luckymoney);
        }

        return null;
    }


    @PostMapping("/luckymoneys/two")
    public void createTwo(){
          service.creatTwo();
    }

    @GetMapping(value = "/luckymoneys/getAmountOne/{id}")
    public void getAmountOne(@PathVariable("id") Integer id) throws Exception{
             service.getAmountOne(id);
    }

}









