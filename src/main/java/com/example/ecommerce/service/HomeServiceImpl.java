package com.example.ecommerce.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.dao.ManufacturerDao;
import com.example.ecommerce.dao.ProductDao;
import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;


@Service
@Transactional
public class HomeServiceImpl implements HomeService {
	
	@Autowired
	private ManufacturerDao manufacturerDao;
	
	@Autowired
	private ProductDao productDao;

	@Override
	public List<Manufacturer> getAllManufacturers() {
		return manufacturerDao.getAllManufacturer();
	}
	
	private static int maxPin=0;
	private static int minPin=10000;
	private static double minPrice=0;
	private static double maxPrice=100000000;
	
	
	private static void getMinMaxPin(List<Integer> pins) {
		maxPin=0;minPin=10000;
		if (pins!=null ) {
			int min=pins.get(0);
			int max=pins.get(0);
			for (Integer pin : pins) {
				if(min>pin) min=pin;
				if(max<pin) max=pin;
			}
			switch (min) {
			case 1: {
				minPin=0;
				break;
			}
			case 2: {
				minPin=3001;
				break;
			}
			case 3: {
				minPin=4001;
				break;
			}
			default:
				minPin=0;
				break;
			}
			
			switch (max) {
			case 1: {
				maxPin=3000;
				break;
			}
			case 2: {
				maxPin=4000;
				break;
			}
			case 3: {
				maxPin=10000;
				break;
			}
			default:
				maxPin=10000;
				break;
			}
		}
	}
	
	private static void getMinMaxPrice(List<Integer> prices) {
		minPrice=0;maxPrice=100000000;
		if (prices!=null ) {
			int min=prices.get(0);
			int max=prices.get(0);
			for (Integer pin : prices) {
				if(min>pin) min=pin;
				if(max<pin) max=pin;
			}
			switch (min) {
			case 1: {
				minPrice=0;
				break;
			}
			case 2: {
				minPrice=2000000;
				break;
			}
			case 3: {
				minPrice=4000000;
				break;
			}
			case 4: {
				minPrice=7000000;
				break;
			}
			case 5: {
				minPrice=14000000;
				break;
			}
			default:
				minPin=0;
				break;
			}
			
			switch (max) {
			case 1: {
				maxPrice=2000000;
				break;
			}
			case 2: {
				maxPrice=4000000;
				break;
			}
			case 3: {
				maxPrice=7000000;
				break;
			}
			case 4: {
				maxPrice=14000000;
				break;
			}
			case 5: {
				maxPrice=100000000;
				break;
			}
			default:
				maxPrice=100000000;
				break;
			}
		}
	}

	@Override
	public List<ProductDetail> getListProduct(String key, List<Integer> manufactures, List<Integer> price, List<Integer> pins,Pageable pageable) {
		getMinMaxPin(pins);
		getMinMaxPrice(price);
		return productDao.getListProduct(key, manufactures, price, minPin, maxPin,minPrice,maxPrice,pageable);
	}

	@Override
	public Long countwithKeyManuPriPin(String key, List<Integer> manufactures, List<Integer> price,
			List<Integer> pins) {
		getMinMaxPin(pins);
		getMinMaxPrice(price);
		return productDao.countwithKeyManuPriPin(key, manufactures, price, minPin,maxPin,minPrice,maxPrice);
	}

	@Override
	public List<Integer> getAllId() {
		return manufacturerDao.getAllId();
	}

}
