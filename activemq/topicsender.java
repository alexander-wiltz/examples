package itanalyst.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class topicsender {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("TestTopic");

        //Producer
        MessageProducer producer = session.createProducer(destination);

        connection.start();
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText("Hallo");
        producer.send(textMessage);
        connection.close();
    }
}
