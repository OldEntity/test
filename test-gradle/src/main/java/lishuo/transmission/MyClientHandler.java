package lishuo.transmission;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;



public class MyClientHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("我是客户端，接收到的远程地址是："+ctx.channel().remoteAddress());
        System.out.println("我是客户端，接收到的服务端发来的消息为："+msg);
        //ctx.writeAndFlush("I'm Client,Are you OK?");
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        while(true){
        ctx.writeAndFlush("来自客户端的问候！");
        Thread.sleep(5000);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}

