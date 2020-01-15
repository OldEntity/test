package lishuo.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;

import java.net.InetSocketAddress;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-12 16:41
 */

public class WebSocketServer {
    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup boss=new NioEventLoopGroup();
        EventLoopGroup worker=new NioEventLoopGroup();

        try {
            ServerBootstrap sbt=new ServerBootstrap();
            sbt.group(boss,worker).channel(NioServerSocketChannel.class).
                    handler(new LoggingHandler(LogLevel.INFO)).
                    childHandler(new WebSocketInitializer());
            ChannelFuture cf=sbt.bind(new InetSocketAddress(8899)).sync();
            cf.channel().closeFuture().sync();
        }finally {
            boss.shutdownGracefully();
            worker.shutdownGracefully();
        }

    }
}
