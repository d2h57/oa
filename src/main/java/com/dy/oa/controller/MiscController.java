package com.dy.oa.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dy.oa.model.Message;
import com.dy.oa.model.ResponseMessage;
import com.dy.oa.service.MessageService;

@Controller
@RequestMapping("/misc")
public class MiscController {
	@Resource
	private transient MessageService service;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "pushMessage";
    }
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	@ResponseBody
    public  ResponseMessage addMessage(@RequestBody Message message) throws Exception {
		ResponseMessage response = ResponseMessage.createDefault();
		service.addMessage(message);
		response.setResult(0);
		return response;
    }
}
