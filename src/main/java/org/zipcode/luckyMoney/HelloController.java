package org.zipcode.luckyMoney;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/*Controller + responsebody = @RestController*/


@RestController
@RequestMapping("/hello")
public class HelloController {

    @Autowired
    private LimitConfig limitConfig;

    @PostMapping("/say")
    public String say( @RequestParam (value = "id", required = false, defaultValue = "0") Integer id ){
     //  return "description: " + limitConfig.getDescription() ;
        return "id: " + id ;
    }
}
