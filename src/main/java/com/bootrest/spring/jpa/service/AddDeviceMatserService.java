package com.bootrest.spring.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootrest.spring.entities.AddDeviceTableData;
import com.bootrest.spring.jpa.repo.AddDeviceMatserRepo;

@Service
public class AddDeviceMatserService {

	@Autowired
	private AddDeviceMatserRepo addDeviceMatserRepo;

	public List<AddDeviceTableData> findAll() {
		return this.addDeviceMatserRepo.findAll();
	}
	
	public AddDeviceTableData findByvehno(String vehicleNo) {
		return this.addDeviceMatserRepo.findByvehno(vehicleNo);
	}

	public void save(AddDeviceTableData data) {
		this.addDeviceMatserRepo.save(data);
	}

}
