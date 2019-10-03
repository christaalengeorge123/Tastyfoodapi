package com.restaurant.api.model;

import java.util.List;

public class Order{

    int oderid;
    List<Food>foodlist;

    Price price;

    public List<Food> getFoodlist() {
        return foodlist;
    }

    public void setFoodlist(List<Food> foodlist) {
        this.foodlist = foodlist;
    }

    public Order(int oderid, List<Food> food, Price price){
        this.oderid=oderid;
        this.foodlist=food;

        this.price=price;
    }

    public int getOderid() {
        return oderid;
    }

    public void setOderid(int oderid) {
        this.oderid = oderid;
    }





    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }
}