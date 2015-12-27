package com.calculator.client;

import com.calculator.common.Constants;
import com.calculator.common.ICalculator;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class Main 
{
    public static void main(String[] args) throws RemoteException, NotBoundException 
    {
        Registry registry = LocateRegistry.getRegistry("localhost", Constants.PORT);
        
        ICalculator calculator = (ICalculator) registry.lookup(Constants.CALCULATOR_NAME);
        
        System.out.println("Client started!");
        System.out.println("Test message: " + calculator.testMethod());
    }
}
