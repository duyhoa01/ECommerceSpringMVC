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
	
	
	private static void getMinMaxPin(List<Integer> pins) {
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

	@Override
	public List<Product> getListProduct(String key, List<Integer> manufactures, List<Integer> price, List<Integer> pins,Pageable pageable) {
		getMinMaxPin(pins);
		return productDao.getListProduct(key, manufactures, price, minPin, maxPin,pageable);
	}

	@Override
	public Long countwithKeyManuPriPin(String key, List<Integer> manufactures, List<Integer> price,
			List<Integer> pins) {
		getMinMaxPin(pins);
		return productDao.countwithKeyManuPriPin(key, manufactures, price, minPin,maxPin);
	}

	@Override
	public List<Integer> getAllId() {
		return manufacturerDao.getAllId();
	}

}
