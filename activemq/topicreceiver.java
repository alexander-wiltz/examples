package itanalyst.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.w3c.dom.Text;

import javax.jms.*;

public class topicreceiver {
    public static void main(String[] args) throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        Connection connection = connectionFactory.createConnection();

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Destination destination = session.createTopic("TestTopic");

        //Consumer
        MessageConsumer consumer = session.createConsumer(destination);

        connection.start();
        System.out.println("Wait for messages...");
        Message message = consumer.receive();
        System.out.println("Message received: ");

        if (message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            System.out.println(textMessage.getText());
        }
        connection.close();
    }
}
