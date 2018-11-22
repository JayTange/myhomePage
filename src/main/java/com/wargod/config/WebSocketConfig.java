package com.wargod.config;

import com.wargod.service.WbSocketService;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author: tangJ
 * @Date: 2018/11/22 15:00
 * @description:
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(getHandler(),"wb/{ID}").setAllowedOrigins("*");
    }

    public WebSocketHandler getHandler(){
        return new WbSocketService();
    }
}
