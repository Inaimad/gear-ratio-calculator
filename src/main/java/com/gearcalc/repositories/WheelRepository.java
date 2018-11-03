package com.gearcalc.repositories;

import com.gearcalc.entities.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Integer> {
}
