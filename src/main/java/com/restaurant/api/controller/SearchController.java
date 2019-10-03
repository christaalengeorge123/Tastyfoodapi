package com.restaurant.api.controller;

import com.restaurant.api.accessingdatamysql.FoodData;
import com.restaurant.api.accessingdatamysql.FoodRepository;
import com.restaurant.api.model.Food;
import com.restaurant.api.model.Price;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SearchController{
    // http://localhost:8080/searchFood?restaurantId=34&foodId=1

    @Autowired
    private FoodRepository foodRepository;

    @RequestMapping(value="searchFood", method= RequestMethod.GET)
    @ResponseBody
    public FoodData searchFood(@RequestParam("restaurantId") String restaurantId,
                                 @RequestParam("foodId") String foodId) {


        FoodData f = foodRepository.findByFid(Integer.parseInt(foodId));

        return f;
    }

    // http://localhost:8080/showMenu?restaurantId=34
    @RequestMapping(value="showMenu", method= RequestMethod.GET)
    @ResponseBody
    public Iterable<FoodData> showMenu(@RequestParam("restaurantId") String restaurantId) {
        System.out.println(restaurantId);
        return foodRepository.findAll();
    }
}

