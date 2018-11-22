package com.wargod.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author: tangJ
 * @Date: 2018/11/22 15:39
 * @description:
 */
public class WbSocketService extends TextWebSocketHandler {

    Gson gson = new Gson();
    ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        String payLoad = message.getPayload();
        Map<String, String> map = gson.fromJson(payLoad, HashMap.class);
        System.out.println("接受的数据：" + map);
        scheduledExecutorService.scheduleAtFixedRate(getTask(session), 0, 5, TimeUnit.SECONDS);
    }

    private Runnable getTask(WebSocketSession session) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    session.sendMessage(new TextMessage("服务器返回的消息是：" + UUID.randomUUID().toString().replace("-", "")));
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        };
    }
}
