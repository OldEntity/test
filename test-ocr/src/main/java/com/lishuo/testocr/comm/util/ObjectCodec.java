package com.lishuo.testocr.comm.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageCodec;

import java.util.List;

/**
 * @Program：test
 * @Description：消息转码
 * @Author：LearnLi
 * @Create:2020-03-26 11:05
 */

public class ObjectCodec extends MessageToMessageCodec<ByteBuf, Object> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Object msg, List<Object> out) throws Exception {
        byte[] data = ObjectSerializerUtils.serilizer(msg);
        ByteBuf buf = Unpooled.buffer();
        buf.writeBytes(data);
        out.add(buf);
    }

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf msg, List<Object> out) throws Exception {
        byte[] bytes = new byte[msg.readableBytes()];
        msg.readBytes(bytes);
        Object deSerilizer = ObjectSerializerUtils.deSerilizer(bytes);
        out.add(deSerilizer);
    }
}
