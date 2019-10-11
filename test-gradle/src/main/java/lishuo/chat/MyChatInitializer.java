package lishuo.chat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.StringUtil;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-10 17:16
 */

public class MyChatInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pip=ch.pipeline();
        //通过分隔符对消息进行解码
        pip.addLast(new DelimiterBasedFrameDecoder(4096, Delimiters.lineDelimiter()));
        //解码
        pip.addLast(new StringDecoder(CharsetUtil.UTF_8));
        //编码
        pip.addLast(new StringEncoder(CharsetUtil.UTF_8));
        //自定忆handler
        pip.addLast(new MyChatHandler());



    }
}
