package itanalyst.rmiexample;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {
    public static void main(String[] args) throws RemoteException, NotBoundException {
        Registry registry = LocateRegistry.getRegistry(1099);

        Remote remoteInterface = registry.lookup("rmi://sayHello");
        // Fehler sollte im allgemeinen mit try catch behandelt werden

        if(remoteInterface instanceof IServerInterface) {
            IServerInterface remoteObject = (IServerInterface) remoteInterface;

            System.out.println("Start");
            System.out.println(remoteObject.sayHello("Alex"));
            System.out.println("Ende");
        }
    }
}
