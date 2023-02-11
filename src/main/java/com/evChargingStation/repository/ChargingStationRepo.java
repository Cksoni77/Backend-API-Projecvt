package com.evChargingStation.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.evChargingStation.entity.ChargingStations;

public interface ChargingStationRepo extends JpaRepository<ChargingStations, Integer> {

}
