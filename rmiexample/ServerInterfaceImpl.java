package itanalyst.rmiexample;

import java.rmi.RemoteException;

public class ServerInterfaceImpl implements IServerInterface {

    @Override
    public String sayHello(String name) throws RemoteException {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Hello " + name;
    }
}
