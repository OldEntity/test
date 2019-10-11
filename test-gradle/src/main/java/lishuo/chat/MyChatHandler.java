package lishuo.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * @Program：test-gradle
 * @Description：
 * @Author：LearnLi
 * @Create:2019-10-11 14:32
 */

public class MyChatHandler extends SimpleChannelInboundHandler<String> {

    private static ChannelGroup channelGroup=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.forEach(ch->{
            if(ch!=channel){
                ch.writeAndFlush(channel.remoteAddress()+":发送的消息："+msg+"\n");
            }else{
                ch.writeAndFlush("我："+msg+"\n");
            }

        });




    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush("服务器："+channel.remoteAddress()+"加入\n");
        channelGroup.add(channel);
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        channelGroup.writeAndFlush("服务器："+channel.remoteAddress()+"退出\n");
        //为什么不调用channelGroup.remove()方法，因为ChannelGroup这个全局变量会自动剔除失效的连接。
    }


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        System.out.println(channel.remoteAddress()+"上线\n");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel=ctx.channel();
        System.out.println(channel.remoteAddress()+"下线\n");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
