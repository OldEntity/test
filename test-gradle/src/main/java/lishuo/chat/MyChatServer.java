package lishuo.chat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-10 17:06
 */

public class MyChatServer {
    public static void main(String[] args) {
        EventLoopGroup bossgroup=new NioEventLoopGroup();
        EventLoopGroup workergroup=new NioEventLoopGroup();

        try{
            ServerBootstrap serverBootstrap=new ServerBootstrap();
            serverBootstrap.group(bossgroup,workergroup).channel(NioServerSocketChannel.class).
                    childHandler(new MyChatInitializer());
            ChannelFuture future=serverBootstrap.bind(8899).sync();
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            bossgroup.shutdownGracefully();
            workergroup.shutdownGracefully();
        }


    }
}
