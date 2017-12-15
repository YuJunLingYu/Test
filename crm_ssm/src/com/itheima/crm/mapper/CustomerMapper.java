package com.itheima.crm.mapper;

import java.util.List;

import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.CustomerInfo;

public interface CustomerMapper {
	//查询用户列表
	List<Customer> getByCustomerInfo(CustomerInfo info);
	//分页查询用户列表
	List<Customer> getByCustomerInfoByPage(CustomerInfo info);
	
	int getTotal(CustomerInfo info);
	
	Customer getCustomerById(int id);
	
	void updateCustomer(Customer customer);
	void deletCustomer(int id);
}
