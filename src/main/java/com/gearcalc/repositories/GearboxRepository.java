package com.gearcalc.repositories;

import com.gearcalc.entities.GearBox;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GearboxRepository extends JpaRepository<GearBox, Integer> {
}
