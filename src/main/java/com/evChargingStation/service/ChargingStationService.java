package com.evChargingStation.service;

import java.util.List;


import com.evChargingStation.entity.ChargingStations;

public interface ChargingStationService {
	
	//method to get list of all stations
	List<ChargingStations> getAllStation();
	//method to get list of station by giving limit, sort , and by parameter
	List<ChargingStations> getAllStations(Integer limit,String sort,String param);
	// get single station details
	ChargingStations getStationById(Integer stationId);
	//add station
	ChargingStations addStations(ChargingStations chargingStations);
	//edit stations
	ChargingStations updateStation(ChargingStations chargingStations,Integer stationId);
	//delete station
	void deleteStation(Integer stationId);
	

}
