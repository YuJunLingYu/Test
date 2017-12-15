package com.itheima.crm.service;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.CustomerInfo;
import com.itheima.crm.utils.Page;

public interface CustomerService {
	List<Customer> getByCustomerInfo(CustomerInfo info);
	Page<Customer> getByCustomerInfoByPage(CustomerInfo info);
	Customer getCustomerByid(int id);
	void updateCustomerById(Customer customer);
	void deleteCustomer(int id);
}
