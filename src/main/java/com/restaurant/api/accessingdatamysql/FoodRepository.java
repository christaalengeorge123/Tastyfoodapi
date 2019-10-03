package com.restaurant.api.accessingdatamysql;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called foodRepository
// CRUD refers Create, Read, Update, Delete

public interface FoodRepository extends CrudRepository<FoodData, Integer> {


    List<FoodData> findByFoodname(String foodname);


    FoodData findByFid(int id);

    @Query("SELECT a.amount FROM FoodData a where a.id = ?1")
    Float findAmountById(int id);

}