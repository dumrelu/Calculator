package com.calculator.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Relu
 */
public interface ICalculatorFactory extends Remote
{
    public ICalculator createCalculator() throws RemoteException;
}
