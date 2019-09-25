package com.lishuo.testwebsocket.config;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @Program：test
 * @Description：
 * @Author：LearnLi
 * @Create:2019-09-23 15:32
 */

@ServerEndpoint("/websocket/{username}")
@Component
public class WebSocketServer {
    //连接用户数量
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    ///与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;


    //接收sid
    private String username = "";






    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新窗口开始监听:" + username + ",当前在线人数为" + getOnlineCount());
        this.username=username;
        try {
            sendMessage("连接成功!");
        } catch (IOException e) {
            System.out.println("连接失败");
        }

    }



    /**
     * 群发自定义消息
     * */
    public static void sendInfo(String message,@PathParam("username") String username) throws IOException {
        System.out.println("推送消息到窗口"+username+"，推送内容:"+message);
        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if(username=="all") {
                    item.sendMessage(message);
                }else if(item.username.equals(username)){
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }










    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }
    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }


    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }



    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }


}
