package com.bootrest.spring.serviceregisteries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bootrest.spring.jpa.service.AddDeviceMatserService;

@Component
public class ServiceRegisteries {

	@Autowired
	private AddDeviceMatserService addDeviceMatserService;

	public AddDeviceMatserService getAddDeviceMatserService() {
		return addDeviceMatserService;
	}

}
