package com.example.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<String> images=new ArrayList<String>();
	
	private String name;
	
	private int count;
	
	private float rate;
	
	private String description;
	
	@OneToMany(mappedBy = "product",fetch = FetchType.EAGER)
	List<ProductDetail> productDetails;
	
//	@ManyToOne
//	private Category category;
	
	@ManyToOne
	private Manufacturer manufacrurer;
	
	@OneToOne(targetEntity = Specifications.class)
	private Specifications specifications;
	
	@ManyToOne
	private Discount discount;
	

	public List<ProductDetail> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(List<ProductDetail> productDetails) {
		this.productDetails = productDetails;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getImage() {
		return images;
	}

	public void setImage( List<String> image) {
		this.images = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Category getCategory() {
//		return category;
//	}
//
//	public void setCategory(Category category) {
//		this.category = category;
//	}



	public Specifications getSpecifications() {
		return specifications;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	public Manufacturer getManufacrurer() {
		return manufacrurer;
	}

	public void setManufacrurer(Manufacturer manufacrurer) {
		this.manufacrurer = manufacrurer;
	}

	public void setSpecifications(Specifications specifications) {
		this.specifications = specifications;
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}
	
}
