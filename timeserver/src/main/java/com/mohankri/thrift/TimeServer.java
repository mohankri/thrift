package com.mohankri.thrift;

/**
 * Hello world!
 *
 */

import java.io.IOException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TBinaryProtocol.Factory;
import org.apache.thrift.server.TServer;
import org.apache.thrift.server.TThreadPoolServer;
import org.apache.thrift.transport.TServerSocket;
import org.apache.thrift.transport.TTransportException;
import tserver.gen.TmServer;

public class TimeServer {
  private void start() {
    try {
      TServerSocket serverTransport = new TServerSocket(7911);
      TmServer.Processor processor =
                 new TmServer.Processor(new TimeServerImpl());
      Factory protFactory = new TBinaryProtocol.Factory(true, true);
      TThreadPoolServer.Args args =
                 new TThreadPoolServer.Args(serverTransport)
                 .processor(processor);

      TServer server = new TThreadPoolServer(args);
      System.out.println("Starting server on port 7911 ...");
      server.serve();
    } catch (TTransportException e) {
      e.printStackTrace();
    }
  }

  public static void main(String args[]) {
    TimeServer srv = new TimeServer();
    srv.start();
  }
}
