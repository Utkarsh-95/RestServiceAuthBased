package com.bootrest.spring.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bootrest.exception.ResourceNotFoundException;
import com.bootrest.spring.entities.AddDeviceTableData;
import com.bootrest.spring.model.ResponseWrapper;
import com.bootrest.spring.model.Vehicledetails;
import com.bootrest.spring.serviceregisteries.ServiceRegisteries;

@RestController
@CrossOrigin()
@RequestMapping("/api/v1/")
public class Controller {

	// https://www.devglan.com/spring-security/exception-handling-in-spring-security

	@PersistenceContext
	private EntityManager em;

	@Autowired
	private org.springframework.jdbc.core.JdbcTemplate JdbcTemplate;

	@Autowired
	private ServiceRegisteries services;

	@GetMapping("healthCheck/{test}")
	public String healthCheck(@PathVariable("test") String test) {
		return test;
	}

	@PostMapping("addNewDeviceData")
	public ResponseEntity<ResponseWrapper> addNewDeviceData(@RequestBody AddDeviceTableData requestData) {

		this.services.getAddDeviceMatserService().save(requestData);

		return new ResponseEntity<ResponseWrapper>(
				new ResponseWrapper(new Date().toString(), HttpStatus.OK, "Record Inserted", null), HttpStatus.OK);

	}

	public static void imageconverter(String image, String uniqueImageName) {

		try {

			byte[] scanBytes = Base64.getDecoder().decode(image);
			File outputfile = new File("E:\\" + uniqueImageName + ".png");
			BufferedOutputStream scanStream = new BufferedOutputStream(new FileOutputStream(outputfile));
			scanStream.write(scanBytes);
			scanStream.close();

		} catch (Exception e) {
			System.out.println("com.rosmerta.service.Service.imageconverter()" + e);
		}

	}

	@GetMapping("findByVehicleNo/{vehicleNo}")
	public ResponseEntity<ResponseWrapper> findByVehicleNo(@PathVariable("vehicleNo") String vehicleNo) {

		List<AddDeviceTableData> data = Arrays.asList(services.getAddDeviceMatserService().findByvehno(vehicleNo));

		if (data == null || data.size() == 0 || data.get(0) == null) {
			return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(new Date().toString(), HttpStatus.OK,
					"Unable to find the records for: " + vehicleNo, null), HttpStatus.OK);
		}

		return new ResponseEntity<ResponseWrapper>(
				new ResponseWrapper(new Date().toString(), HttpStatus.OK, "OK", data), HttpStatus.OK);

	}

	@GetMapping("findAllDeviceData")
	public ResponseEntity<ResponseWrapper> findAllDeviceData() {

		return new ResponseEntity<ResponseWrapper>(new ResponseWrapper(new Date().toString(), HttpStatus.OK, "OK",
				services.getAddDeviceMatserService().findAll()), HttpStatus.OK);

	}

	@PostMapping("dealerratingbyvendor")
	public @ResponseBody ResponseEntity<List<Vehicledetails>> getVehicledetails() throws ResourceNotFoundException {

		// if ("".equals(vehicleno)) {
		// throw new ResourceNotFoundException("Vehicle No can't be Blank");
		// }

		// else if (!vehicleno.matches("^[a-zA-Z0-9]+$")) {
		// throw new ResourceNotFoundException("Special Characters not allowed: " +
		// vehicleno);
		// }

		List<Vehicledetails> result;
		try {
			String SQL = "SELECT sr_no, vendor_name, gps_dealer_name, contact_name, contact_no, "
					+ "email_id, address, circle "
					+ "FROM mobileapp.dealer_agg_rating where vendor_name='iTriangle Infotech'";

			result = this.JdbcTemplate.query(SQL, new RowMapper<Vehicledetails>() {
				public Vehicledetails mapRow(ResultSet rs, int rowNum) throws SQLException {
					Vehicledetails veh = new Vehicledetails();
					veh.setVehicleRegNo(rs.getString("vendor_name"));
					veh.setImeiNo(rs.getString("gps_dealer_name"));
					veh.setChassisNo(rs.getString("contact_name"));
					veh.setLatitude(rs.getString("contact_no"));
					veh.setLongitude(rs.getString("contact_no"));
					veh.setDateTime(rs.getString("sr_no"));
					return veh;
				}
			});

			// if (vehs.isEmpty()) {
			// throw new ResourceNotFoundException("Data not found for this Vehicle No: " +
			// vehicleno);
			// }
		} catch (DataAccessException e) {
			throw new ResourceNotFoundException("Invalid input " + e);
		}

		return new ResponseEntity<List<Vehicledetails>>(result, HttpStatus.OK);
	}

}