package com.greatlearning.customermanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.customermanagement.entity.Customer;
import com.greatlearning.customermanagement.service.CustomerManagementService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerManagementService customerManagementService;
	
	@RequestMapping("/list")
	public String showCustomerList(Model model) {
		
		List<Customer> customerList = customerManagementService.getCustomerList();
		model.addAttribute("customerlist", customerList);
		return "customer-main-view";
	}
	
	@RequestMapping("/add")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		model.addAttribute("customer", customer);
		return "add-customer-view";
	}
	
	@RequestMapping("/delete")
	public String deleteCustomer(@RequestParam("id") int id) {
		
		customerManagementService.deleteCustomerById(id);
		return "redirect:list";
	}
	
	@RequestMapping("/update")
	public String updateCustomer(@RequestParam("id") int id, Model model){
		
		Customer customer = customerManagementService.getCustomerById(id);
		model.addAttribute("customer",customer);
		return "add-customer-view";
	}
	
	@RequestMapping("/save")
	public String saveCustomer(@RequestParam("id") int id, @RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName, @RequestParam("email") String email) {

		Customer customer;
		if (id != 0) {
			customer = customerManagementService.getCustomerById(id);
		} else {
			customer = new Customer();
		}
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setEmail(email);
		customerManagementService.saveCustomer(customer);

		return "redirect:list";
	}
}
