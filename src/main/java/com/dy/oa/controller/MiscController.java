package com.dy.oa.controller;

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
	private transient MessageService service;
	
	@RequestMapping(method = RequestMethod.GET)
    public String getIndexPage() {
        return "pushMessage";
    }
	
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	@ResponseBody
    public  ResponseMessage createUser(@RequestBody Message message) {
		ResponseMessage response = ResponseMessage.createDefault();
		response.setResult(0);
		return response;
    }
}
