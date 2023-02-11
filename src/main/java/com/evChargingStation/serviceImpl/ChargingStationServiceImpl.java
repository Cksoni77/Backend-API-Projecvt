package com.evChargingStation.serviceImpl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import com.evChargingStation.entity.ChargingStations;
import com.evChargingStation.exception.ResourceNotFoundException;
import com.evChargingStation.repository.ChargingStationRepo;
import com.evChargingStation.service.ChargingStationService;


@Service
public class ChargingStationServiceImpl implements ChargingStationService{
	
	@Autowired
	private ChargingStationRepo chargingStationRepo;

	@Override
	public List<ChargingStations> getAllStations(Integer limit,String sort,String param) {
		Sort s = (sort.equalsIgnoreCase("asc")?Sort.by(param).ascending():Sort.by(param).descending());
		
		Pageable p = PageRequest.of(0, limit, s);
		Page<ChargingStations> findAlls = this.chargingStationRepo.findAll(p);
		List<ChargingStations> contents = findAlls.getContent();
		return contents;
	}

	@Override
	public ChargingStations addStations(ChargingStations chargingStations) {
		
		
		chargingStations.setImageName("default.png");
		ChargingStations saved = this.chargingStationRepo.save(chargingStations);
		return saved;
	}

	@Override
	public List<ChargingStations> getAllStation() {	
		
		return this.chargingStationRepo.findAll();
	}

	@Override
	public ChargingStations getStationById(Integer stationId) {	
		ChargingStations chargingStations2 = this.chargingStationRepo.findById(stationId).orElseThrow(
				()-> new ResourceNotFoundException("Station","ID",stationId));
		
		
		return chargingStations2;
	}

	@Override
	public ChargingStations updateStation(ChargingStations chargingStations, Integer stationId) {
		ChargingStations chargingStations2 = this.chargingStationRepo.findById(stationId).orElseThrow(
				()-> new ResourceNotFoundException("Station","ID",stationId));
		
		chargingStations2.setImageName(chargingStations.getImageName());
		chargingStations2.setPricing(chargingStations.getPricing());
		chargingStations2.setStationAddress(chargingStations.getStationAddress());
		chargingStations2.setStationName(chargingStations.getStationName());
		ChargingStations saved = this.chargingStationRepo.save(chargingStations2);
		return saved;
	}

	

	@Override
	public void deleteStation(Integer stationId) {
		ChargingStations chargingStations2 = this.chargingStationRepo.findById(stationId).orElseThrow(
				()-> new ResourceNotFoundException("Station","ID",stationId));
		this.chargingStationRepo.delete(chargingStations2);
		
	}

	

}
