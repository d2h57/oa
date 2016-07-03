package com.dy.oa.service;

import java.util.List;

import com.dy.oa.model.Device;

public interface DeviceService {
	public void addDevice(Device device) throws Exception;
	public List<Device> getDevice(int type);
}
