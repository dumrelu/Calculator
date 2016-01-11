package com.calculator.server;

import com.calculator.common.ICalculator;
import com.calculator.common.ICalculatorFactory;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Relu
 */
public class CalculatorFactory extends UnicastRemoteObject implements ICalculatorFactory
{
    public CalculatorFactory() throws RemoteException
    {
        super();
    }
    
    @Override
    public ICalculator createCalculator() throws RemoteException 
    {
        return new Calculator();
    }
    
}
