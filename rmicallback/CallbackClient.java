package itanalyst.rmicallback;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CallbackClient {
    public static void main(String[] args) throws RemoteException, NotBoundException, InterruptedException {
        Registry registry = LocateRegistry.getRegistry(1099);

        IMessageSender server = (IMessageSender) registry.lookup("rmi://Sender");

        IMessageReceiver clientInterface = new MessageReceiverImpl();
        server.register(clientInterface);

        int count = 20;

        do {
            System.out.println("working...");
            Thread.sleep(2000);
            count -= 1;
        } while(count > 0);

        server.remove(clientInterface);
        System.out.println("closed");
    }
}
