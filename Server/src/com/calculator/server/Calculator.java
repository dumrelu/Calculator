package com.calculator.server;

import com.calculator.common.ICalculator;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements ICalculator
{

    public Calculator() throws RemoteException
    {
        
    }
    
    @Override
    public String testMethod() throws RemoteException 
    {
        return "Hello World";
    }
    
}
