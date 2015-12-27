package com.calculator.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote
{
    public String testMethod() throws RemoteException;
}
