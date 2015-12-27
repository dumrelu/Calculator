package com.calculator.server;

import com.calculator.common.ICalculator;
import com.calculator.common.Result;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements ICalculator
{
    private Result m_result;
    private double m_firstOperand;
    private double m_secondOperand;

    public Calculator() throws RemoteException
    {
        m_result = new Result();
        m_firstOperand = 0.0;
        m_secondOperand = 0.0;
    }
    
    @Override
    public String testMethod() throws RemoteException 
    {
        return "Hello World";
    }

    @Override
    public void setFirstOperand(double firstOperand) throws RemoteException 
    {
        m_firstOperand = firstOperand;
    }

    @Override
    public void setSecondOperand(double secondOperand) throws RemoteException 
    {
        m_secondOperand = secondOperand;
    }

    @Override
    public Result getResult() throws RemoteException 
    {
        return m_result;
    }

    @Override
    public void add() throws RemoteException 
    {
        //Overflow?
        m_result.setNumber(m_firstOperand + m_secondOperand);
    }

    @Override
    public void subtract() throws RemoteException 
    {
        m_result.setNumber(m_firstOperand - m_secondOperand);
    }

    @Override
    public void multiply() throws RemoteException 
    {
        m_result.setNumber(m_firstOperand * m_secondOperand);
    }

    @Override
    public void divide() throws RemoteException 
    {
        m_result.setNumber(m_firstOperand / m_secondOperand);
    }
    
}
