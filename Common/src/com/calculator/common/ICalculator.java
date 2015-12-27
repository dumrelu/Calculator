package com.calculator.common;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author Relu
 */
public interface ICalculator extends Remote
{
    // Seteaza primul operand folosit de operatii.
    public void setFirstOperand(double firstOperand) throws RemoteException;
    
    // Seteaza al doilea operand folosit de operatii.
    public void setSecondOperand(double secondOperand) throws RemoteException;
    
    // Returneaza rezultatul ultimei operatiuni efectuate.
    public Result getResult() throws RemoteException;
    
    /*                          Operatii de baza.                        */
    
    // op1 + op2
    public void add() throws RemoteException;
    
    // op1 - op2
    public void subtract() throws RemoteException;
    
    // op1 * op2
    public void multiply() throws RemoteException;
    
    // op1 / op2
    public void divide() throws RemoteException;
}
