package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.CustomerMapper;
import com.itheima.crm.pojo.Customer;
import com.itheima.crm.pojo.CustomerInfo;
import com.itheima.crm.service.CustomerService;
import com.itheima.crm.utils.Page;
@Service
public class CustomerServiceImpl implements CustomerService {
	@Autowired
	private CustomerMapper customerMapper;
	@Override
	public List<Customer> getByCustomerInfo(CustomerInfo info) {
		// TODO Auto-generated method stub
		List<Customer> list = customerMapper.getByCustomerInfo(info);
		return list;
	}
	//查询分页数据
	@Override
	public Page<Customer> getByCustomerInfoByPage(CustomerInfo info) {
		// TODO Auto-generated method stub
		info.setStart((info.getPage()-1)*info.getRows());
		Page<Customer> page = new Page<>();
		List<Customer> list = customerMapper.getByCustomerInfoByPage(info);
		page.setRows(list);
		int total = customerMapper.getTotal(info);
		page.setTotal(total);
		page.setPage(info.getPage());
		page.setSize(info.getRows());
		return page;
	}
	@Override
	public Customer getCustomerByid(int id) {
		// TODO Auto-generated method stub
		Customer customer = customerMapper.getCustomerById(id);
		return customer;
	}
	@Override
	public void updateCustomerById(Customer customer) {
		// TODO Auto-generated method stub
		customerMapper.updateCustomer(customer);
	}
	@Override
	public void deleteCustomer(int id) {
		// TODO Auto-generated method stub
		customerMapper.deletCustomer(id);
	}
	

}
