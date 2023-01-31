package com.geyuxu.jms1;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by geyuxu on 2016/9/4.
 */
public class JMSConsumer {
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL;
    public static void main(String[] args) {
        ConnectionFactory connectionFactory;
        Connection connection;
        Session session;
        Destination destination;
        MessageConsumer messageConsumer;

        connectionFactory = new ActiveMQConnectionFactory(USERNAME,PASSWORD,BROKEURL);

        try {
            connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("myqueue1");
            messageConsumer = session.createConsumer(destination);

            while(true){
                TextMessage textMessage = (TextMessage) messageConsumer.receive(10000);
                if(textMessage != null){
                    System.out.println("接收消息： " + textMessage.getText());
                }
            }
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
