package itanalyst.rmiexample;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    public static void main(String[] args) throws RemoteException {
        IServerInterface serverInterface = new ServerInterfaceImpl();

        Registry registry = LocateRegistry.createRegistry(1099);
        UnicastRemoteObject.exportObject(serverInterface,0);
        registry.rebind("rmi://sayHello",serverInterface);

        System.out.println("Server is ready...");
    }

}
