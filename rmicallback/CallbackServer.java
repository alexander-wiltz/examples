package itanalyst.rmicallback;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;

public class CallbackServer {

    public static void main(String[] args) throws RemoteException, InterruptedException {
        MessageSenderImpl msgSender = new MessageSenderImpl();

        Registry registry = LocateRegistry.createRegistry(1099);
        UnicastRemoteObject.exportObject(msgSender,0);

        registry.rebind("rmi://Sender", msgSender);
        System.out.println("Server is ready...");

        // DEMO
        DateFormat df = DateFormat.getDateTimeInstance();

        do {
            String str = "Message from Server at " + df.format(new Date());
            System.out.println("Sending " + str);
            msgSender.sendMessage(str);
            Thread.sleep(1500);
        } while (true);
    }
}
