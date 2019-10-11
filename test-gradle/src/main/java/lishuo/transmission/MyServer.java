package lishuo.transmission;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;



public class MyServer {


    public static void main(String[] args) throws InterruptedException {

        //创建事件循环组
        //boss用来分发连接
        EventLoopGroup bossgroup =new NioEventLoopGroup();
        //worker用来执行业务处理与回调
        EventLoopGroup workergroup=new NioEventLoopGroup();
        try {
            //创建服务器启动器
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            //将事件循环组放入group（），设定用nio作为通道方式
            serverBootstrap.group(bossgroup,workergroup).channel(NioServerSocketChannel.class).
                    childHandler(new MyServerInitializer());
            //绑定服务器监听端口，sync（）用来持续监听，开启通道
            ChannelFuture channelFuture=serverBootstrap.bind(8899).sync();
            //关闭通道
            channelFuture.channel().closeFuture().sync();
        }finally {
            //优雅的关闭事件循环组
            bossgroup.shutdownGracefully();
            workergroup.shutdownGracefully();
        }



    }
}
