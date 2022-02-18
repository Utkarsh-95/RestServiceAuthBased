package com.bootrest.spring.entities;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.bootrest.spring.controller.Controller;

@Entity
@Table(name = "add_dev_inst", schema = "mobileapp")
@EntityListeners(AuditingEntityListener.class)
public class AddDeviceTableData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String imeino;
	private String mob;
	private String vehno;
	private String compname;
	private String image;
	private String address;
	private String adddatetime;
	private String imagefilename;
	private String latitude;
	private String longitude;
	private String loginname;
	private String profilepic;
	private String profilepicfilename;
	private String deviceimage;
	private String deviceimagefilename;
	private String otherimage;
	private String otherimagefilename;
	private String polled_status;
	private String range_status;

	public AddDeviceTableData() {
	}

	public AddDeviceTableData(long id, String imeino, String mob, String vehno, String compname, String image,
			String address, String adddatetime, String imagefilename, String latitude, String longitude,
			String loginname, String profilepic, String profilepicfilename, String deviceimage,
			String deviceimagefilename, String otherimage, String otherimagefilename, String polled_status,
			String range_status) {
		super();
		this.id = id;
		this.imeino = imeino;
		this.mob = mob;
		this.vehno = vehno;
		this.compname = compname;
		this.image = image;
		this.address = address;
		this.adddatetime = adddatetime;
		this.imagefilename = imagefilename;
		this.latitude = latitude;
		this.longitude = longitude;
		this.loginname = loginname;
		this.profilepic = profilepic;
		this.profilepicfilename = profilepicfilename;
		this.deviceimage = deviceimage;
		this.deviceimagefilename = deviceimagefilename;
		this.otherimage = otherimage;
		this.otherimagefilename = otherimagefilename;
		this.polled_status = polled_status;
		this.range_status = range_status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getImeino() {
		return imeino;
	}

	public void setImeino(String imeino) {
		this.imeino = imeino;
	}

	public String getMob() {
		return mob;
	}

	public void setMob(String mob) {
		this.mob = mob;
	}

	public String getVehno() {
		return vehno;
	}

	public void setVehno(String vehno) {
		this.vehno = vehno;
	}

	public String getCompname() {
		return compname;
	}

	public void setCompname(String compname) {
		this.compname = compname;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAdddatetime() {
		return adddatetime;
	}

	public void setAdddatetime(String adddatetime) {
		this.adddatetime = adddatetime;
	}

	public String getImagefilename() {
		return imagefilename;
	}

	public void setImagefilename(String imagefilename) {
		 String uniqueImageName = System.currentTimeMillis() + "";
		// String image = uniqueImageName;

		Controller.imageconverter(this.image, uniqueImageName);

		this.imagefilename = uniqueImageName;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLoginname() {
		return loginname;
	}

	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}

	public String getProfilepic() {
		return profilepic;
	}

	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}

	public String getProfilepicfilename() {
		return profilepicfilename;
	}

	public void setProfilepicfilename(String profilepicfilename) {
		 String uniqueImageName = System.currentTimeMillis() + "_p";
		// String image = uniqueImageName;

		Controller.imageconverter(this.profilepic, uniqueImageName + "_p");

		this.profilepicfilename = uniqueImageName;
	}

	public String getDeviceimage() {
		return deviceimage;
	}

	public void setDeviceimage(String deviceimage) {
		this.deviceimage = deviceimage;
	}

	public String getDeviceimagefilename() {
		return deviceimagefilename;
	}

	public void setDeviceimagefilename(String deviceimagefilename) {
		 String uniqueImageName = System.currentTimeMillis() + "_d";
		// String image = uniqueImageName;

		Controller.imageconverter(this.deviceimage, uniqueImageName + "_d");

		this.deviceimagefilename = uniqueImageName;
	}

	public String getOtherimage() {
		return otherimage;
	}

	public void setOtherimage(String otherimage) {
		this.otherimage = otherimage;
	}

	public String getOtherimagefilename() {
		return otherimagefilename;
	}

	public void setOtherimagefilename(String otherimagefilename) {
		 String uniqueImageName = System.currentTimeMillis() + "_o";
		// String image = uniqueImageName;

		Controller.imageconverter(this.otherimage, uniqueImageName + "_o");

		this.otherimagefilename = uniqueImageName;
	}

	public String getPolled_status() {
		return polled_status;
	}

	public void setPolled_status(String polled_status) {
		this.polled_status = polled_status;
	}

	public String getRange_status() {
		return range_status;
	}

	public void setRange_status(String range_status) {
		this.range_status = range_status;
	}

}
