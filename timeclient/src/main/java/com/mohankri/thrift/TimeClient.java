package com.mohankri.thrift;

/**
 * Hello world!
 *
 */
import java.net.SocketException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import tserver.gen.TmServer.Client;
public class TimeClient {
   private void start(){
      TTransport transport;
      try {
         transport = new TSocket("localhost", 7911);
         TProtocol protocol = new TBinaryProtocol(transport);Client client = new Client(protocol);
         transport.open();
         long time = client.time();
         System.out.println("Time from server:" + time);
         transport.close();
      } catch (TTransportException e) {
         e.printStackTrace();
      } catch (TException e) {
         e.printStackTrace();
      }
   }
 
   public static void main(String[] args) {
      TimeClient c = new TimeClient();
      c.start();
   }
}
