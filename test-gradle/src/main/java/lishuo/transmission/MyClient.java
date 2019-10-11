package lishuo.transmission;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;


public class MyClient {
    public static void main(String[] args) {
        EventLoopGroup loopGroup=new NioEventLoopGroup();
        try {
            Bootstrap bootstrap=new Bootstrap();
            bootstrap.group(loopGroup).channel(NioSocketChannel.class).
                    handler(new MyClientInitializer());
            ChannelFuture cf=bootstrap.connect("localhost",8899).sync();
            cf.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            System.out.println("错误！");
        } finally {
            loopGroup.shutdownGracefully();
        }

    }
}
