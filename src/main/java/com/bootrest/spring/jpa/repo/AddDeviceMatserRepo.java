package com.bootrest.spring.jpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootrest.spring.entities.AddDeviceTableData;

@Repository
public interface AddDeviceMatserRepo extends JpaRepository<AddDeviceTableData, Long> {

	public AddDeviceTableData findByvehno(String vehno);

}