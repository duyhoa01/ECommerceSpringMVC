package com.example.ecommerce.controller;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;
import com.example.ecommerce.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
    ServletContext servletContext;
	
	@GetMapping("/")
	public ModelAndView home() {
		return new ModelAndView("admin_dashboard");
	}
	
	@GetMapping("/product")
	public ModelAndView adminProduct(@RequestParam(value = "key",required = false ) String key 
									,@PageableDefault(
											page = 0,
											size = 3
											) Pageable pageable) {
		System.out.println(key);
		System.out.println(pageable.getOffset());
		System.out.println(pageable.getPageSize());
		
		List<Product> products;
		Long count;
		if (key!=null) {
			products=adminService.getListProduct(key,pageable);
			count=adminService.countProductWithKey(key);
//			products=adminService.getAllProduct();
			//System.out.println(products.size());
		} else {
//			products=adminService.getAllProduct();
			products=adminService.findAll(pageable);
			count=adminService.countProducts();
		}
		ModelAndView model=new ModelAndView("admin_product_list");
		model.addObject("key", key);
		model.addObject("products",products);
		model.addObject("offset",pageable.getOffset());
		model.addObject("count",count);
		return model;
	}
	
	@GetMapping("/product/new")
	public ModelAndView adminProductNew() {
		Product product=new Product();
		List<Manufacturer> manufacturers=adminService.getAllManufacturer();
		System.out.println(manufacturers.get(0));
		ModelAndView model=new ModelAndView("admin_product_form");
		model.addObject("product",product);
		model.addObject("manufacturers",manufacturers);
		return model;
	}
	
	@PostMapping("/product/save")
	public ModelAndView saveProduct(@ModelAttribute("product") Product product,
									@RequestParam(value = "rams", required = false) List<String> rams,
									@RequestParam(value = "prices",required = false) List<String> prices,
									@RequestParam("files") MultipartFile files[]) {
		System.out.println(product.getId());
		List<String> images=new ArrayList<String>();
		String fileName="";
		for (MultipartFile file : files) {
			if(file !=null && !file.isEmpty()) {
				try {
					String uploadsDir = "/static/images/";
	                String realPathtoUploads =  servletContext.getRealPath(uploadsDir);
	                if(! new File(realPathtoUploads).exists())
	                {
	                    new File(realPathtoUploads).mkdir();
	                }
	                fileName=realPathtoUploads+file.getOriginalFilename();
	                File dest = new File(fileName);
	                file.transferTo(dest);
	                images.add(uploadsDir+file.getOriginalFilename());
				} catch (Exception e) {
					
				}
			}
		}
		product.setImage(images);
		List<ProductDetail> productDetails=new ArrayList<ProductDetail>();
		for (int i = 0; i < rams.size(); i++) {
			ProductDetail productDetail;
//				if(product.getId()!=null) {
//					productDetail=new ProductDetail(product.getProductDetails().get(i).getId(),rams.get(i), Double.parseDouble(prices.get(i)));
//				} else {
//					productDetail=new ProductDetail(rams.get(i), Double.parseDouble(prices.get(i)));
//				}
			productDetail=new ProductDetail(rams.get(i), Double.parseDouble(prices.get(i)));
			productDetail.setProduct(product);
			productDetails.add(productDetail);
			System.out.println(productDetail.getRam());
		}
		product.setProductDetails(productDetails);
		if(product.getId()==null) {
			adminService.addProduct(product);
		} else {
			adminService.updateProduct(product);
		}
		
		return new ModelAndView("redirect:/admin/product");
		
	}
	
	@GetMapping("/product/{id}")
	public ModelAndView detailProduct(@PathVariable Integer id) {
		Product product=adminService.getProductById(id);
		ModelAndView model=new ModelAndView("admin_product_detail");
		model.addObject("product",product);
		return model;
	}
	
	@GetMapping("/product/{id}/edit")
	public ModelAndView editProduct(@PathVariable Integer id) {
		Product product=adminService.getProductById(id);
		List<Manufacturer> manufacturers=adminService.getAllManufacturer();
		System.out.println(product.getProductDetails().get(0).getId());
		System.out.println(manufacturers.get(0));
		ModelAndView model=new ModelAndView("admin_product_form");
		model.addObject("product",product);
		model.addObject("manufacturers",manufacturers);
		return model;
	}
	
}
