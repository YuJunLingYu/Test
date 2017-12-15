package com.itheima.crm.contorller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.CustomerInfo;
import com.itheima.crm.service.BaseDictService;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;

@Controller
public class CustomerContorller {
	@Value("${CUSTOMER_FROM_TYPE}")
	private String CUSTOMER_FROM_TYPE;
	@Value("${CUSTOMER_INDUSTRY_TYPE}")
	private String CUSTOMER_INDUSTRY_TYPE;
	@Value("${CUSTOMER_LEVEL_TYPE}")
	private String CUSTOMER_LEVEL_TYPE;
	@Autowired
	private BaseDictService baseDictService;
	@Autowired
	private CustomerService customerService;

	@RequestMapping("/list.action")
	public String getList(Model model, CustomerInfo info) {
		List<BaseDict> fromList = baseDictService.getByTypeCode(CUSTOMER_FROM_TYPE);
		List<BaseDict> industryList = baseDictService.getByTypeCode(CUSTOMER_INDUSTRY_TYPE);
		List<BaseDict> levelList = baseDictService.getByTypeCode(CUSTOMER_LEVEL_TYPE);
		Page<Customer> page = customerService.getByCustomerInfoByPage(info);
		model.addAttribute("page", page);
		model.addAttribute("fromType", fromList);
		model.addAttribute("industryType", industryList);
		model.addAttribute("levelType", levelList);
		
		model.addAttribute("custName", info.getCustName());
		model.addAttribute("custSource", info.getCustSource());
		model.addAttribute("custIndustry", info.getCustIndustry());
		model.addAttribute("custLevel", info.getCustLevel());

		return "customer";
	}
	
	
	@RequestMapping("customer/edit.action")
	@ResponseBody
	public Customer getCustomerByid( int id){
		Customer customer =  customerService.getCustomerByid(id);
		return customer;
	}
	@RequestMapping("customer/update.action")
	@ResponseBody
	public String updateCustomer(Customer customer){
		customerService.updateCustomerById(customer);
		return "ok";
	}
	@RequestMapping("customer/delete.action")
	@ResponseBody
	public String deleteCustomer(int id){
		customerService.deleteCustomer(id);
		return "ok";
	}
}
