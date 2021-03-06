package com.dy.oa.model;

public class Device {
	private String id;
	private int type;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return new StringBuilder("Device [id=").append(id)
				.append(", type=").append(type).append("]")
				.toString();
	}
}
