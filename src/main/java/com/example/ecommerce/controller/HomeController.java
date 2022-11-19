package com.example.ecommerce.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.ecommerce.dao.CustommerDao;
import com.example.ecommerce.dao.ManufacturerDao;
import com.example.ecommerce.model.Admin;
import com.example.ecommerce.model.Customer;
import com.example.ecommerce.model.Manufacturer;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;
import com.example.ecommerce.model.Staff;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.AdminService;
import com.example.ecommerce.service.CustommerService;
import com.example.ecommerce.service.HomeService;
import com.example.ecommerce.service.RoleService;
import com.example.ecommerce.service.StaffService;
import com.example.ecommerce.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private StaffService staffService;
	
	@Autowired
	private CustommerService custommerService;
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
    ServletContext servletContext;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/")
	public String homeView() {
		User user=userService.getUser("admin");
		return "index";
	}
	
	@RequestMapping(value = "/admin-save")
	public ModelAndView saveAdmin() {

		String fileName="";
		User user=new User();
		Admin admin=new Admin();
		user.setUsername("admin");
		user.setPassword("admin");
		String hashedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(hashedPassword);
		user.setRole(roleService.getOrCreateRole("ADMIN"));
		user.setStatus(true);
		admin.setUser(user);
		adminService.addAdmin(admin);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/user-save",method = RequestMethod.POST,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
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
		custommerService.addcustommer(custommer);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/staff-save",method = RequestMethod.POST,consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ModelAndView saveStaff(@ModelAttribute("staff") Staff staff,
							BindingResult result,RedirectAttributes redirectAttributes,
							@RequestParam("fileUpload") MultipartFile file) {

		String fileName="";
		User user=staff.getUser();
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
		user.setRole(roleService.getOrCreateRole("STAFF"));
		user.setStatus(false);
		staff.setUser(user);
		staffService.addStaff(staff);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/loginPage")
	public ModelAndView loginPage(ModelAndView model) {
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public ModelAndView hello() {
		Collection<SimpleGrantedAuthority> authorities = 
				(Collection<SimpleGrantedAuthority>) SecurityContextHolder.getContext().getAuthentication().getAuthorities();

		List<String> roles=new ArrayList<String>();
		for (SimpleGrantedAuthority simple : authorities) {
			roles.add(simple.getAuthority().toString());
		}
		
		if (roles.get(0).equals("ROLE_ADMIN")) {
			return new ModelAndView("redirect:/admin/");
		}
		if (roles.get(0).equals("ROLE_STAFF")) {
			return new ModelAndView("redirect:/staff/customer");
		}
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/user-signup",method = RequestMethod.GET)
	private ModelAndView userFormSignup(ModelAndView model) {
		Customer custommer=new Customer();
		model.addObject("custommer",custommer);
		model.setViewName("user_signup");
		return model;
	}
	
	@RequestMapping(value = "/staff-signup",method = RequestMethod.GET)
	private ModelAndView staffFormSignup(ModelAndView model) {
		Staff staff=new Staff();
		model.addObject("staff",staff);
		model.setViewName("staff_signup");
		return model;
	}
	
	@RequestMapping(value = "/shop",method = RequestMethod.GET)
	private ModelAndView shop(ModelAndView model,
								@RequestParam(value = "key",required = false ,defaultValue = "") String key ,
								@RequestParam(value = "manufacturer", required = false) List<Integer> manufacturer,
								@RequestParam(value = "price", required = false) List<Integer> price,
								@RequestParam(value = "pin", required = false) List<Integer> pin,
								@PageableDefault(
										page = 0,
										size = 6
										) Pageable pageable) {
		List<Integer> manufacturerCop;
		if (manufacturer==null) {
			manufacturerCop=homeService.getAllId();
			manufacturer=new ArrayList<Integer>();
			manufacturer.add(0);
		} else if(manufacturer.contains(0)) {
			manufacturerCop=homeService.getAllId();
		} else {
			manufacturerCop=manufacturer;
		}
		if(pin==null) {
			pin=new ArrayList<Integer>();
			pin.add(0);
		}
		if(price==null) {
			price=new ArrayList<Integer>();
			price.add(0);
		}
		List<ProductDetail> products= homeService.getListProduct(key, manufacturerCop, price, pin,pageable);	
		Long count=homeService.countwithKeyManuPriPin(key, manufacturerCop, price, pin);
		model.setViewName("shop");
		List<Manufacturer> manufacturers=homeService.getAllManufacturers();
		model.addObject("manufacturers",manufacturers);
		model.addObject("products",products);
		model.addObject("key",key);
		model.addObject("manufacturer",manufacturer);
		model.addObject("offset",pageable.getOffset());
		model.addObject("count",count);
		model.addObject("pin",pin);
		model.addObject("price",price);
		return model;
	}
	@GetMapping("/product/{id}")
	public ModelAndView detailProduct(@PathVariable Integer id) {
		ModelAndView model=new ModelAndView("product_detail");
		return model;
	}
}
