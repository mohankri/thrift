package com.mohankri.thrift;

import org.apache.thrift.TException;
import tserver.gen.*;
class TimeServerImpl implements TmServer.Iface {
   @Override
   public long time() throws TException {
      long time = System.currentTimeMillis();
      System.out.println("time() called: " + time);
      return time;
   }
}
