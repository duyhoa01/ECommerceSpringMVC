package com.example.ecommerce.controller;

import java.io.File;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ecommerce.dao.StaffDao;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.CustommerService;
import com.example.ecommerce.service.RoleService;
import com.example.ecommerce.service.StaffService;

@Controller
@RequestMapping("/staff")
public class StaffController {
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
    ServletContext servletContext;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private CustommerService custommerService;
	
	@GetMapping("/customer")
	public ModelAndView home(@RequestParam(value = "key",required = false ) String key 
							,@PageableDefault(
									page = 0,
									size = 8
									) Pageable pageable) {
		List<Customer> customers;
		ModelAndView model= new ModelAndView("staff_customer");
		Long count;
		if (key!=null) {
			customers=staffService.getListCustomer(key,pageable);
			count=staffService.countCustomerWithKey(key);
		} else {
			customers=staffService.getListCustomer(pageable);
			count=staffService.countCustomer();
		}
		model.addObject("key", key);
		model.addObject("customers",customers);
		model.addObject("offset",pageable.getOffset());
		model.addObject("count",count);
		return model;
	}
	
	@GetMapping("/customer/new")
	public ModelAndView adminProductNew() {
		Customer customer=new Customer();
		ModelAndView model=new ModelAndView("staff_customer_new");
		model.addObject("custommer",customer);
		
		return model;
	}
	
	@PostMapping(value = "/customer/save",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView saveUserMode(@ModelAttribute("custommer") Customer custommer,
							BindingResult result,RedirectAttributes redirectAttributes,
							@RequestParam("fileUpload") MultipartFile file) {

		System.out.println(custommer);
		System.out.println(file.getOriginalFilename());
		String fileName="";
		User user=custommer.getUser();
		if(file !=null && !file.isEmpty()) {
			try {
				String uploadsDir = "/static/profile/";
                String realPathtoUploads =  servletContext.getRealPath(uploadsDir);
                if(! new File(realPathtoUploads).exists())
                {
                    new File(realPathtoUploads).mkdir();
                }
                fileName=realPathtoUploads+file.getOriginalFilename();
                File dest = new File(fileName);
                file.transferTo(dest);
                user.setImage(uploadsDir+file.getOriginalFilename());
			} catch (Exception e) {
				
			}
			
		}
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setRole(roleService.getOrCreateRole("CUSTOMER"));
		user.setStatus(true);
		custommer.setUser(user);
		if(custommer.getId()==null) {
			staffService.addcustommer(custommer);
		} else {
			staffService.updateCustommer(custommer);
		}
		
		return new ModelAndView("redirect:/staff/customer");
	}
	
	@GetMapping("/customer/{id}/edit")
	public ModelAndView editCustommer(@PathVariable Integer id) {
		Customer customer=staffService.getCustomerById(id);
		ModelAndView model=new ModelAndView("staff_customer_new");
		model.addObject("custommer",customer);

		return model;
	}
	
	@GetMapping("/customer/{id}/delete")
	public ModelAndView deleteCustommer(@PathVariable Integer id) {
		staffService.deleteCustommer(id);
		return new ModelAndView("redirect:/staff/");
	}
}
