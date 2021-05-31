package com.geyuxu.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.mqtt.*;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;


public class MyMqttHandlers extends SimpleChannelInboundHandler<MqttMessage> {

    public static final MyMqttHandlers INSTANCE = new MyMqttHandlers();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MqttMessage msg) {
        switch (msg.fixedHeader().messageType()) {
            case CONNECT:
                connect(ctx, (MqttConnectMessage) msg);
                break;
            case SUBSCRIBE:
                subscribe(ctx, (MqttSubscribeMessage) msg);
                break;
            case PINGREQ:
                pingReq(ctx);
                break;
            //... 处理其他报文
            default:
        }
    }

    private void pingReq(ChannelHandlerContext ctx) {


    }

    private void connect(ChannelHandlerContext ctx, MqttConnectMessage msg) {
        String clientIdentifier = msg.payload().clientIdentifier();
//        String userName = msg.payload().userName();
//        String password = new String(msg.payload().passwordInBytes());
//        // 此处可以鉴权
//        System.out.println(clientIdentifier + " " + userName + " " + password);
        // 此处保存用户和连接之间的关系
        ChannelManager.saveChannelMapping(clientIdentifier, ctx.channel());
        MqttFixedHeader connAckFixedHeaderRes = new MqttFixedHeader(MqttMessageType.CONNACK, false, MqttQoS.AT_MOST_ONCE, false, 0);
        // 连接成功设置为 MqttConnectReturnCode.CONNECTION_ACCEPTED，失败可以返回其他状态码
        MqttConnAckVariableHeader connAckVariableHeader = new MqttConnAckVariableHeader(MqttConnectReturnCode.CONNECTION_ACCEPTED, false);
        MqttConnAckMessage ackMessage = new MqttConnAckMessage(connAckFixedHeaderRes, connAckVariableHeader);
        ctx.channel().writeAndFlush(ackMessage);
    }

    private void subscribe(ChannelHandlerContext ctx, MqttSubscribeMessage msg) {
        List<MqttTopicSubscription> topics = msg.payload().topicSubscriptions();
        // 存储客户端订阅的主题
        ChannelManager.saveTopics(ctx.channel(),
                topics.stream().map(MqttTopicSubscription::topicName).collect(Collectors.toList()));
        System.out.println(" 订阅成功：" + topics);
        MqttFixedHeader header = new MqttFixedHeader(MqttMessageType.SUBACK, false, MqttQoS.AT_LEAST_ONCE, false, 0);
        MqttMessageIdAndPropertiesVariableHeader variableHeader = new MqttMessageIdAndPropertiesVariableHeader(msg.variableHeader().messageId(), null);
        MqttSubAckPayload payload = new MqttSubAckPayload();
        MqttSubAckMessage ackMessage = new MqttSubAckMessage(header, variableHeader, payload);
        ctx.writeAndFlush(ackMessage);
    }

    



}
