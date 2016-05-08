package com.dy.oa.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dy.oa.dao.DeviceDao;
import com.dy.oa.model.Device;
import com.dy.oa.service.DeviceService;

@Service
public class DeviceServiceImpl implements DeviceService {
	@Resource
	private transient DeviceDao dao;
	
	@Override
	public void addDevice(Device device) throws Exception {
		dao.insert(device);
	}
}
