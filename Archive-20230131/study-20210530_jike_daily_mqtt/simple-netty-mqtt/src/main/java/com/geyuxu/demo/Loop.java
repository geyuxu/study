package com.geyuxu.demo;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.handler.codec.mqtt.*;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class Loop implements Runnable{
    @Override
    public void run() {
        while(true) {
            String topic = "demo";
            List<Channel> channels = ChannelManager.listChannels(topic);
            if (channels == null) {
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                continue;
            }
            channels.forEach(channel -> {
                MqttPublishVariableHeader variableHeader = new MqttPublishVariableHeader(topic, 0);
                ByteBuf payload = Unpooled.copiedBuffer("hello world", StandardCharsets.UTF_8);
                MqttFixedHeader fixedHeader = new MqttFixedHeader(MqttMessageType.PUBLISH, false, MqttQoS.AT_LEAST_ONCE, false, 0);
                MqttPublishMessage mqttPublishMessage = new MqttPublishMessage(fixedHeader, variableHeader, payload);
                channel.writeAndFlush(mqttPublishMessage);
            });

            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
