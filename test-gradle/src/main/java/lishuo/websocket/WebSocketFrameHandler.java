package lishuo.websocket;


import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-12 16:50
 */

public class WebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) throws Exception {
        System.out.println("收到的消息："+msg.text());


        ctx.writeAndFlush(new TextWebSocketFrame("服务器时间："+ LocalDateTime.now()));
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {

        System.out.println("用户："+ctx.channel().id().asLongText()+"上线");
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        System.out.println("用户："+ctx.channel().id().asLongText()+"下线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
