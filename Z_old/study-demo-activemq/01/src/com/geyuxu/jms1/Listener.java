package com.geyuxu.jms1;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by geyuxu on 2016/9/4.
 */
public class Listener implements MessageListener {

    @Override
    public void onMessage(Message message) {
        try {
            System.out.println("接收到的消息： " + ((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
