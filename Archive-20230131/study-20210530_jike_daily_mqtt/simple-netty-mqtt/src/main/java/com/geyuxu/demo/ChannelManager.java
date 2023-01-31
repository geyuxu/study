package com.geyuxu.demo;

import io.netty.channel.Channel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChannelManager {
    public static void saveChannelMapping(String clientIdentifier, Channel channel) {
    }

    private static Map<String,List<Channel>> channelMap = new HashMap<>();

    public static void saveTopics(Channel channel, List<String> collect) {
        collect.stream().forEach(a->{
            List<Channel> channels = channelMap.get(a);
            if(channels==null){
                channels = new ArrayList<>();
                channelMap.put(a,channels);
            }
            channels.add(channel);
        });
    }

    public static List<Channel> listChannels(String topic){
        return channelMap.get(topic);
    }
}
