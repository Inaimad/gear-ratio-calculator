package com.gearcalc.repositories;

import com.gearcalc.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findAllByPlatform(String platform);

    @Query("SELECT DISTINCT c.platform FROM Car c")
    List<String> findAllPlatforms();

    @Query("SELECT DISTINCT c.carType FROM Car c")
    List<String> findAllCarTypes();

}
