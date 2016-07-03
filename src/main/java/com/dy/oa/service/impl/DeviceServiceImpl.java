package com.dy.oa.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dy.oa.dao.DeviceDao;
import com.dy.oa.model.Device;
import com.dy.oa.service.DeviceService;

@Transactional
@Service
public class DeviceServiceImpl implements DeviceService {
	@Resource
	private transient DeviceDao dao;
	
	@Override
	public void addDevice(Device device) throws Exception {
		dao.insert(device);
	}

	@Override
	public List<Device> getDevice(int type) {
		return dao.getDevice(type);
	}
}
