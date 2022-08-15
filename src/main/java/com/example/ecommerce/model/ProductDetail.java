package com.example.ecommerce.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "product_detail")
public class ProductDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Basic(fetch = FetchType.EAGER)
	private String ram;
	
	private Double price;
	
	@ManyToOne
	private Product product;
	
	@OneToMany(mappedBy = "productDetail")
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<BillDetail> billDetails;

	public ProductDetail() {
		super();
	}

	public ProductDetail(String ram, Double price) {
		super();
		this.ram = ram;
		this.price = price;
	}

	public ProductDetail(Integer id, String ram, Double price) {
		super();
		this.id = id;
		this.ram = ram;
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRam() {
		return this.ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}
