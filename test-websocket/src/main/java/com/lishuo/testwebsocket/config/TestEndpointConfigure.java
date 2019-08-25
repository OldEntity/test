package com.lishuo.testwebsocket.config;

import org.springframework.stereotype.Controller;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-08-13 13:54
 */
@Controller
@ServerEndpoint(value="/webLearnLi")
public class TestEndpointConfigure {
    @OnMessage
    public void onMessage(String message, Session session)
            throws IOException, InterruptedException {
        // 为测试目的打印客户机消息
        System.out.println("接受的结果: " + message);
        // 向客户机发送第一个消息
        session.getBasicRemote().sendText("发送第一条命令");
        //每5秒向客户端发送3条消息
        int sentMessages = 0;
        while (sentMessages < 3) {
            Thread.sleep(5000);
            session.getBasicRemote().
                    sendText("服务端发送数据次数"
                            + sentMessages);
            sentMessages++;
        }
        // 向客户端发送最后一条消息
        session.getBasicRemote().sendText("最后一条消息");
    }

    @OnOpen
    public void onOpen() {
        System.out.println("客户端连接");
    }

    @OnClose
    public void onClose() {
        System.out.println("客户端连接关闭！");
    }

}
