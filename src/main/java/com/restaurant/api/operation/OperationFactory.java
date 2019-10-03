package com.restaurant.api.operation;

import com.restaurant.api.model.Order;

public class OperationFactory {

    public Operation createOperation(int type) {

        int foodid=1;
        String fid=String.valueOf(foodid);

        switch (type) {
            case 1:
                return new MenuOperation();
            case 2:
                return new SearchOperation(fid);
            case 3:
                return new OrderOperation();
        }
        return null;
    }
}
