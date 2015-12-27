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

    public void setResultNumber(double number)
    {
        m_result.setNumber(number);
        m_firstOperand = number;
    }
    
    @Override
    public void add() throws RemoteException 
    {
        //Overflow?
        setResultNumber(m_firstOperand + m_secondOperand);
    }

    @Override
    public void subtract() throws RemoteException 
    {
       setResultNumber(m_firstOperand - m_secondOperand);
    }

    @Override
    public void multiply() throws RemoteException 
    {
        setResultNumber(m_firstOperand * m_secondOperand);
    }

    @Override
    public void divide() throws RemoteException 
    {
        setResultNumber(m_firstOperand / m_secondOperand);
    }

    @Override
    public void invert() throws RemoteException 
    {
        setResultNumber(1.0 / m_firstOperand);
    }

    @Override
    public void pow() throws RemoteException 
    {
        setResultNumber(Math.pow(m_firstOperand, m_secondOperand));
    }

    @Override
    public void factorial() throws RemoteException 
    {
        int result = 1;
        for(int i = (int) m_firstOperand; i > 1; --i)
            result *= i;
        setResultNumber(result);
    }

    @Override
    public void sqrt() throws RemoteException 
    {
        setResultNumber(Math.sqrt(m_firstOperand));
    }
    
}
