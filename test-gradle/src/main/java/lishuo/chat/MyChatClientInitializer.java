package lishuo.chat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-11 15:39
 */

public class MyChatClientInitializer extends ChannelInitializer<SocketChannel> {


    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pip=ch.pipeline();
        pip.addLast(new DelimiterBasedFrameDecoder(4069, Delimiters.lineDelimiter()));
        pip.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pip.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pip.addLast(new MyChatClientHandler());
    }
}
