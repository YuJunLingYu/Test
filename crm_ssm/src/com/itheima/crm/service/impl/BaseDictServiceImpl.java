package com.itheima.crm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itheima.crm.mapper.BaseDictMapper;
import com.itheima.crm.pojo.BaseDict;
import com.itheima.crm.service.BaseDictService;
@Service
public class BaseDictServiceImpl implements BaseDictService{
	@Autowired
	private BaseDictMapper baseDictMapper; 
	@Override
	public List<BaseDict> getByTypeCode(String typeCode) {
		// TODO Auto-generated method stub
		List<BaseDict> list = baseDictMapper.getByTypeCode(typeCode);
		return list;
	}

}
