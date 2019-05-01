package org.zipcode.luckyMoney.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zipcode.luckyMoney.Entity.Luckymoney;
import org.zipcode.luckyMoney.Repository.LuckymoneyRepository;
import org.zipcode.luckyMoney.Service.LuckymoneyService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RestController
public class LuckymoneyController {

    @Autowired
    private LuckymoneyRepository repository;

    @Autowired
    private LuckymoneyService service;

    /* the list of red pocket(Luckyjmoney) */
    @GetMapping("/luckymoneys")
    public List<Luckymoney> luckymoneyList() {
        return repository.findAll();
    }

    @PostMapping("/luckymoneys")
    public Luckymoney create(@RequestParam("producer") String producer,
                             @RequestParam("money") BigDecimal money) {
        Luckymoney luckymoney = new Luckymoney();
        luckymoney.setProducer(producer);
        luckymoney.setMoney(money);

        return repository.save(luckymoney);
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
}









