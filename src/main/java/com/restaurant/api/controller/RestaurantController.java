package com.restaurant.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.restaurant.api.model.Order;
import com.restaurant.api.operation.Operation;
import com.restaurant.api.operation.OperationFactory;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.prefs.AbstractPreferences;

@Controller
public class RestaurantController<JSONObject> {


    OperationFactory operationFactory = new OperationFactory();

    // http://localhost:8080/execute
    // { operationType = 1,
    //   operationPayload = {}
    // }
    @RequestMapping(value = "execute", method = RequestMethod.POST)
    @ResponseBody
    public String orderFood(@RequestBody String postPayload) throws JsonProcessingException {

        int operationType = 1;
        String operationPayload = null;
        System.out.println("Payload " + postPayload);
        JsonParser jsonParser = JsonParserFactory.getJsonParser();
        Map<String,Object> map = jsonParser.parseMap(postPayload);


       // Object ob=null;
        System.out.println("Obj - " + ( map).get("operationType"));
        operationType = (int) ( map).get("operationType");

        Operation operation = operationFactory.createOperation(operationType);

        String result = operation.execute(operationPayload);

        return result;
    }
}
