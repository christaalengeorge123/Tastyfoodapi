package com.restaurant.api.controller;

import com.restaurant.api.accessingdatamysql.FoodData;
import com.restaurant.api.accessingdatamysql.FoodRepository;
import com.restaurant.api.model.Food;
import com.restaurant.api.model.Order;
import com.restaurant.api.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller

public class OrderController {

    @Autowired
    private FoodRepository foodRepository;


    // http://localhost:8080/OrderFood
//input is foodid and count
        @RequestMapping(value = "OrderFood", method = RequestMethod.POST)
        @ResponseBody
        public Order orderFood(@RequestBody String postPayload) {
            int count=0;
            float totalprice=0.0f;
            JsonParser jsonParser = JsonParserFactory.getJsonParser();
            List<Object>list = jsonParser.parseList(postPayload);
            Order order=null;
            List<Food> foodlist=new ArrayList<Food>();
            Price price=null;
            for (Object ob : list) {
                System.out.println("Obj - " + ob);
                System.out.println("Obj - " + ((Map)ob).get("foodId"));
                int foodid= (int) ((Map)ob).get("foodId");

               float amt = foodRepository.findAmountById(foodid);

                count=(int)((Map)ob).get("count");

                price=new Price(amt);
                totalprice=totalprice+(price.getAmount()*count);
                Food food=new Food(foodid,"ChickenBurger","spicy chicken burger",price);

                 foodlist.add(food);


         }
            Price totprice=new Price(totalprice);
            order=new Order(123,foodlist,totprice);
            return order;


    }
}