package org.example.designPattner.proxyPattern.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class GInvockeHandler implements InvocationHandler {

  private Object obj;

  public GInvockeHandler(Object obj) {
    this.obj = obj;
  }

  @Override
  public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
    Object result = method.invoke(this.obj, args);
    return result;
  }

}
