package com.evChargingStation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evChargingStation.entity.ApiResponse;
import com.evChargingStation.entity.ChargingStations;
import com.evChargingStation.service.ChargingStationService;

@RestController
public class ChargingStationController {
	
	@Autowired
	private ChargingStationService chargingStationService;
	
	//Get list of all stations
	@GetMapping("/stations")
	public ResponseEntity<List<ChargingStations>> getAllStation(){
		List<ChargingStations> allStation = this.chargingStationService.getAllStation();
		return ResponseEntity.ok(allStation);
	}
	
	
	//get station details by giving station Id
	@GetMapping("/show/{stationId}")
	public ResponseEntity<ChargingStations> getStById(@PathVariable Integer stationId){
		ChargingStations stById = this.chargingStationService.getStationById(stationId);
		return ResponseEntity.ok(stById);
	}
	
	//get stations according to limit , sort by, and by parameters 
	@GetMapping("/")
	public ResponseEntity<List<ChargingStations>> getAll(
			@RequestParam(value="limit",defaultValue = "10",required = false) Integer limit,
			@RequestParam(value = "sort",defaultValue = "asc",required = false) String sort,
			@RequestParam(value = "param",defaultValue = "pricing",required = false) String param){
				
		List<ChargingStations> allStations = this.chargingStationService.getAllStations(limit, sort, param);
		
		return ResponseEntity.ok(allStations);
	}
	
	
	//add stations details
	@PostMapping("/")
	public ResponseEntity<ChargingStations> createStation(@RequestBody ChargingStations chargingStations) {
		ChargingStations addStations = this.chargingStationService.addStations(chargingStations);
		return ResponseEntity.ok(addStations);
	}
	
	//to edit station by giving station Id
	@PutMapping("/{stationId}/edit")
	public ResponseEntity<ChargingStations> updateSt(@RequestBody ChargingStations chargingStations,@PathVariable Integer stationId){
		ChargingStations updatedStation = this.chargingStationService.updateStation(chargingStations, stationId);
	return ResponseEntity.ok(updatedStation);
	}
	
	//delete station by giving statiojn Id
	@DeleteMapping("/delete/{stationId}")
	public ResponseEntity<ApiResponse> deletedStation(@PathVariable Integer stationId){
		
		this.chargingStationService.deleteStation(stationId);
		return new ResponseEntity(new ApiResponse("Stataion deleted sucessfully",true),HttpStatus.OK);
	}
	
	
	

}
