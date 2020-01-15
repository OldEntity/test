package lishuo.idle;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleStateHandler;

import java.util.concurrent.TimeUnit;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-12 13:36
 */

public class ChatInitislizer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pip=ch.pipeline();
        pip.addLast(new IdleStateHandler(5,7,3, TimeUnit.SECONDS));
        pip.addLast(new ChatHandler());

    }
}
