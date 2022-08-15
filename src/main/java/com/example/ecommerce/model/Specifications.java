package com.example.ecommerce.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "specifications")
public class Specifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int dungLuongPin;
	
	private String manHinh;
	
	private String camera;
	
	private String ram;
	
	private String cpu;
	
	private String cardDoHoa;
	
	private String oCung;
	
	private String nhuCau;
	
	private String os;
	
	private String theSim;
	
	private String dateRelase;
	
	@OneToOne(targetEntity = Product.class)
	private Product product;
	
	public String getDateRelase() {
		return dateRelase;
	}

	public void setDateRelase(String dataRelase) {
		this.dateRelase = dataRelase;
	}

	public String getTheSim() {
		return theSim;
	}

	public void setTheSim(String theSim) {
		this.theSim = theSim;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getCpu() {
		return cpu;
	}

	public void setCpu(String cpu) {
		this.cpu = cpu;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getDungLuongPin() {
		return dungLuongPin;
	}

	public void setDungLuongPin(int dungLuongPin) {
		this.dungLuongPin = dungLuongPin;
	}

	public String getManHinh() {
		return manHinh;
	}

	public void setManHinh(String manHinh) {
		this.manHinh = manHinh;
	}

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getCardDoHoa() {
		return cardDoHoa;
	}

	public void setCardDoHoa(String cardDoHoa) {
		this.cardDoHoa = cardDoHoa;
	}

	public String getoCung() {
		return oCung;
	}

	public void setoCung(String oCung) {
		this.oCung = oCung;
	}

	public String getNhuCau() {
		return nhuCau;
	}

	public void setNhuCau(String nhuCau) {
		this.nhuCau = nhuCau;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
