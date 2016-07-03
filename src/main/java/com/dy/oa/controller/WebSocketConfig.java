package com.dy.oa.controller;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
	@Override    
    public void registerStompEndpoints(StompEndpointRegistry registry) {        
        registry.addEndpoint("/socket").withSockJS();       
    }
	
    @Override    
    public void configureMessageBroker(MessageBrokerRegistry registry) {  
        registry.enableSimpleBroker("/topic");      
        registry.setApplicationDestinationPrefixes("/app"); 
    }
}
