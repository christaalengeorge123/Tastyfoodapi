package com.restaurant.api.operation;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restaurant.api.accessingdatamysql.FoodData;
import com.restaurant.api.accessingdatamysql.FoodRepository;
import com.restaurant.api.model.Food;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class MenuOperation implements Operation {

    @Autowired
    private FoodRepository foodRepository;

    @Override
    public String execute(String input) throws JsonProcessingException {
        FoodData fooddataobj=new FoodData();

        WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
        foodRepository = (FoodRepository)context.getBean("foodRepository");
        Iterable<FoodData> f =  foodRepository.findAll();

        // Convert f to json string
        List<FoodData> foodlist=new ArrayList<FoodData>();

       /* for(FoodData : (FoodData)f){
            foodlist.add((FoodData) f);
            // System.out.println(s);
        }*/

        ObjectMapper Obj = new ObjectMapper();
        String jsonStr=null;

        try {

            // get Oraganisation object as a json string
             jsonStr = Obj.writeValueAsString(f);

            // Displaying JSON String
            System.out.println(jsonStr);
        } catch (Exception ex) {
            System.out.println(ex);
        }

        finally {
            
        }


        return jsonStr;
    }
}
