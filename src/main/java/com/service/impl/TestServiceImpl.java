package com.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Dict;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DictMapper;
import com.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	DictMapper dictMapper;
	
	@Override
	public Object Test() {
		PageHelper.offsetPage(0, 10);
		List<Dict> dicts = dictMapper.selectAll();
		PageInfo<Dict> info = new PageInfo<Dict>(dicts);
		return info;
	}
	
}
