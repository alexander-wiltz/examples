package itanalyst.rmicallback;

import java.rmi.RemoteException;

public class MessageReceiverImpl implements IMessageReceiver {

    @Override
    public void sendToClient(String msg) throws RemoteException {
        System.out.println("### " + msg + " ###");
    }
}
