package com.dy.oa.controller;

import org.springframework.stereotype.Controller;

@Controller
public class WSAttemptController {
	@Autowired
	private SimpMessagingTemplate simpMessagingTemplate;
	
	@RequestMapping("/ws/index")
	public String getIndex(){
		return "";
	}
	
	@MessageMapping("/change_notice")
	@SendTo("/topic/notice")
	public String getMessage(String value){
		return value;
	}
}
