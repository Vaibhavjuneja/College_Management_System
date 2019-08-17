import java.rmi.*;
public interface infMessage extends Remote
{
 String SendReceiveMessage(String x) throws RemoteException;
}