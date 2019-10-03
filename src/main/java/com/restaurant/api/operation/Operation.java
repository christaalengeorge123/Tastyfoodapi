package com.restaurant.api.operation;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface Operation {

    String execute(String input) throws JsonProcessingException;
}
