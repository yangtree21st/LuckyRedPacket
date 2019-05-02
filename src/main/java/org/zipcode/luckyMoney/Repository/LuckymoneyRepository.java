package org.zipcode.luckyMoney.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zipcode.luckyMoney.Entity.Luckymoney;

import java.util.List;

public interface LuckymoneyRepository extends JpaRepository<Luckymoney,Integer> {



    public List<Luckymoney> findByMoney(double d);
}
