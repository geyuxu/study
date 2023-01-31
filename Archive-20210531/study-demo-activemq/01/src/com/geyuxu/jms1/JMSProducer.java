package com.geyuxu.jms1;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by geyuxu on 2016/9/4.
 */
public class JMSProducer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final int SENDNUM = 10000;

    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageProducer messageProducer;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);

        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(true,Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("myqueue1");
            messageProducer = session.createProducer(destination);
            sendMessage(session,messageProducer);
            session.commit();
        } catch (JMSException e) {
            e.printStackTrace();
        }


    }

    public static void sendMessage(Session session,MessageProducer messageProducer){
        for (int i = 0 ;i<JMSProducer.SENDNUM; i++){

            try {
                TextMessage textMessage = session.createTextMessage("This is a text message : " + i);
                System.out.println("发送的消息为： " + textMessage.getText());
                messageProducer.send(textMessage);
            } catch (JMSException e) {
                e.printStackTrace();
            }

        }

    }
}
