package com.dy.oa.model;

public class ResponseMessage {
	
	private int result;
	private Object data;

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static ResponseMessage createDefault(){
		return new ResponseMessage();
	}
}
