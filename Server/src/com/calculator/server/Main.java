package com.calculator.server;

import com.calculator.common.Constants;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Main 
{

    public static void main(String[] args) throws RemoteException 
    {
        Registry registry = LocateRegistry.createRegistry(Constants.PORT);
        
        Calculator calculator = new Calculator();
        registry.rebind(Constants.CALCULATOR_NAME, calculator);
        
        CalculatorFactory factory = new CalculatorFactory();
        registry.rebind(Constants.CALCULATOR_FACTORY_NAME, factory);
        
        System.out.println("Server started!");
    }
    
}
