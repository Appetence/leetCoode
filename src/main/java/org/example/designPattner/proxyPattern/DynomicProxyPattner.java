package org.example.designPattner.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.example.designPattner.proxyPattern.action.GActionInterface;
import org.example.designPattner.proxyPattern.action.GRoleAction;
import org.example.designPattner.proxyPattern.handler.GInvockeHandler;

public class DynomicProxyPattner {

  public static void main(String[] args) {
    // 具体obj
    GActionInterface handle = new GRoleAction();
    // invocation method
    InvocationHandler proxy = new GInvockeHandler(handle);
    // classLoader class proxyObj
    // GActionInterface action = (GActionInterface)
    // Proxy.newProxyInstance(proxy.getClass().getClassLoader(),new Class[] {
    // GActionInterface.class }, proxy);
    GActionInterface action = (GActionInterface) Proxy.newProxyInstance(proxy.getClass().getClassLoader(),
        handle.getClass().getInterfaces(), proxy);
    action.normalMethod(" proxy");
    action.specificalMethod(" proxy");
  }

}
