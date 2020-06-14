package com.lishuo.testocr.service.nettymodule;

import com.lishuo.testocr.comm.util.MethodInvokeMeta;
import com.lishuo.testocr.comm.util.NullWritable;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Program：test
 * @Description：初始化设定配置
 * @Author：LearnLi
 * @Create:2020-03-26 10:59
 */

public class CustomChannelInitializerClient extends ChannelInitializer {

    private Logger logger = LoggerFactory.getLogger(CustomChannelInitializerClient.class);

    private MethodInvokeMeta methodInvokeMeta;

    private Object response;

    public CustomChannelInitializerClient(MethodInvokeMeta methodInvokeMeta) {
        if (!"toString".equals(methodInvokeMeta.getMethodName())) {
            logger.info("[CustomChannelInitializerClient] 调用方法名：{}，入参：{},参数类型：{}，返回值类型{}"
                    , methodInvokeMeta.getMethodName()
                    , methodInvokeMeta.getArgs()
                    , methodInvokeMeta.getParameterTypes()
                    , methodInvokeMeta.getReturnType());
        }
        this.methodInvokeMeta = methodInvokeMeta;
    }

    public Object getResponse() {
        if (response instanceof NullWritable) {
            return null;
        }
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
    @Override
    protected void initChannel(Channel channel) throws Exception {

    }
}
