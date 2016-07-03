package com.dy.oa.dao;

import java.util.List;

import com.dy.oa.model.Device;

public interface DeviceDao {
	public void insert(Device device);
	public List<Device> getDevice(int type);
}
