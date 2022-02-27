package itanalyst.rmicallback;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IMessageReceiver extends Remote {
    void sendToClient(String msg) throws RemoteException;
}
