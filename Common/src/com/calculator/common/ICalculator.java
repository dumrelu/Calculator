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
    
    // Indica daca primul operand a fost setat. Primul operator se seteaza
    //ca fiind rezultatul ultimei operatii in mod automat.
    // Primul operand va fi mereu setat cand nu au aparut erori.
    public boolean isFirstOperandSet() throws RemoteException;
    
    // Seteaza al doilea operand folosit de operatii.
    public void setSecondOperand(double secondOperand) throws RemoteException;
    
    // Indica daca al doilea operand a fost setat.
    public boolean isSecondOperandSet() throws RemoteException;
    
    // Returneaza rezultatul ultimei operatiuni efectuate.
    public Result getResult() throws RemoteException;
    
    // op1 = 0, op2 = unset.
    public void reset() throws RemoteException;
    
    /*                          Operatii de baza.                        */
    
    // r = op1 + op2
    public void add() throws RemoteException;
    
    // r = op1 - op2
    public void subtract() throws RemoteException;
    
    // r = op1 * op2
    public void multiply() throws RemoteException;
    
    // r = op1 / op2
    public void divide() throws RemoteException;
    
    /*                          Operatii extinse.                        */
    
    // opx = 1/opx
    public void invert() throws RemoteException;
    
    // r = op1 ^ op2
    public void pow() throws RemoteException;
    
    // opx = opx!
    public void factorial() throws RemoteException;
    
    // opx = sqrt(opx)
    public void sqrt() throws RemoteException;
    
    /*                          Operatii memorie.                        */
    
    // m = m + opx
    public void memoryAdd() throws RemoteException;
    
    // m = m - opx
    public void memorySubtract() throws RemoteException;
    
    // m = opx
    public void memoryStore() throws RemoteException;
    
    // opx = m
    public void memoryRead() throws RemoteException;
    
    // m = 0
    public void memoryClear() throws RemoteException;
}
