package lishuo.transmission;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;



public class MyServerHandler extends SimpleChannelInboundHandler<String> {
    /**
     *
     * @param ctx 连接成功后获得的远程信息（通道信息）
     * @param msg 获得的msg，格式是自己定义的如下面是String
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress()+","+msg);
        ctx.channel().writeAndFlush("From Server:"+ UUID.randomUUID());
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();

    }
}
