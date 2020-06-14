package com.lishuo.testocr.service.nettymodule;

import com.fasterxml.jackson.core.ObjectCodec;
import com.lishuo.testocr.comm.util.MethodInvokeMeta;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Program：test
 * @Description：netty客户端处理器适配类
 * @Author：LearnLi
 * @Create:2020-03-26 10:25
 */

public class ClientChannelHandlerAdapter extends ChannelHandlerAdapter {

    private Logger logger = LoggerFactory.getLogger(ClientChannelHandlerAdapter.class);
    private MethodInvokeMeta methodInvokeMeta;
    private CustomChannelInitializerClient customChannelInitializerClient;

    public ClientChannelHandlerAdapter(MethodInvokeMeta methodInvokeMeta, CustomChannelInitializerClient customChannelInitializerClient) {
        this.methodInvokeMeta = methodInvokeMeta;
        this.customChannelInitializerClient = customChannelInitializerClient;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.info("客户端出异常了,异常信息:{}", cause.getMessage());
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        if (methodInvokeMeta.getMethodName().endsWith("toString") && !"class java.lang.String".equals(methodInvokeMeta.getReturnType().toString()))
            logger.info("客户端发送信息参数:{},信息返回值类型：{}", methodInvokeMeta.getArgs(), methodInvokeMeta.getReturnType());
        ctx.writeAndFlush(methodInvokeMeta);

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        customChannelInitializerClient.setResponse(msg);
    }
}
