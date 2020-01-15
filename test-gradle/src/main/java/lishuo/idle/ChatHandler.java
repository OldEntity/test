package lishuo.idle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-12 13:37
 */

public class ChatHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event=(IdleStateEvent)evt;
            String str="";
            switch (event.state()){
                case READER_IDLE: str="读空闲"; break;
                case WRITER_IDLE: str="写空闲"; break;
                case ALL_IDLE: str="读写空闲"; break;
            }
            System.out.println(ctx.channel().remoteAddress()+"===超时事件："+str);
            ctx.channel().close();
        }

    }
}
