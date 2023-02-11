package com.evChargingStation.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="station")
@Getter
@Setter
@NoArgsConstructor
public class ChargingStations  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int stationId;
	
	private String stationName;
	private String stationAddress;
	private String ImageName;
	private long pricing;
	
	
}


