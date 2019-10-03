package com.restaurant.api.operation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.restaurant.api.accessingdatamysql.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class SearchOperation implements Operation {

    @Autowired
    private FoodRepository foodRepository;

    public SearchOperation(String fid) {

        return;
    }

    @Override
    public String execute(String input) throws JsonProcessingException {
        return null;
    }
}
