package com.example.data.Reps;

import com.example.data.Entity.SingleTable.Car2;
import com.example.data.Entity.Status;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface Car2Rep extends CrudRepository<Car2, Integer>, JpaSpecificationExecutor<Car2> {
    List<Car2> findByStatus1(Status status1);
    @Procedure(name = "addcar2") // Имя процедуры в базе данных
    void addCar(int id, String name, int speed);
    @Query(value = "CALL addcar2(:id, :name, :speed)", nativeQuery = true)
    void addCar1(@Param("id") int id, @Param("name") String name, @Param("speed") int speed);
    @Query(value = "SELECT GetCarNames()", nativeQuery = true)
   List <String> getCarNames();
//    @Procedure(name = "COUNTCARS")
//    Integer getCarsCount();
    @Procedure(name = "CalculateValues")
    void calculateValues(
            @Param("inputValue") Integer inputValue,
            @Param("doubledValue") Integer doubledValue,
            @Param("tripledValue") Integer tripledValue
    );
}
