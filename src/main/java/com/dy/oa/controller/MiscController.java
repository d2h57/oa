package com.dy.oa.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.oa.annotation.OaController;
import com.dy.oa.common.OaConstants;
import com.dy.oa.model.Device;
import com.dy.oa.model.Message;
import com.dy.oa.model.ResponseMessage;
import com.dy.oa.service.DeviceService;
import com.dy.oa.service.MessageService;

@Controller
@RequestMapping("/misc")
public class MiscController {
	@Resource
	private transient MessageService service;
	
	@Resource
	private transient DeviceService deviceService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "misc";
    }
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	@ResponseBody
    public  ResponseMessage addMessage(@RequestBody Message message) throws Exception {
		ResponseMessage response = ResponseMessage.createDefault();
		service.addMessage(message);
		response.setResult(OaConstants.MESSAGE_SUCCESS);
		return response;	
    }
	
	@OaController
	@ResponseBody
	@RequestMapping(value = "/device", method = RequestMethod.POST)
    public  ResponseMessage addDevice(@RequestBody Device device) throws Exception {
		ResponseMessage response = ResponseMessage.createDefault();
		deviceService.addDevice(device);
		response.setResult(OaConstants.MESSAGE_SUCCESS);
		return response;
    }
	
	@OaController
	@ResponseBody
	@RequestMapping("/device")
    public  ResponseMessage getDevice() throws Exception {
		ResponseMessage response = ResponseMessage.createDefault();
		List<Device> devices = deviceService.getDevice(0);
		response.setResult(OaConstants.MESSAGE_SUCCESS);
		response.setData(devices);
		return response;
    }
}
