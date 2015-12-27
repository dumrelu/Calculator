package com.calculator.server;

import com.calculator.common.ICalculator;
import com.calculator.common.Result;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Calculator extends UnicastRemoteObject implements ICalculator
{
    private Result m_result;
    private boolean m_firstOperandSet;
    private double m_firstOperand;
    private boolean m_secondOperandSet;
    private double m_secondOperand;

    public Calculator() throws RemoteException
    {
        m_result = new Result();
        m_firstOperand = 0.0;
        m_firstOperandSet = true;
        m_secondOperand = 0.0;
        m_secondOperandSet = false;
    }

    @Override
    public void setFirstOperand(double firstOperand) throws RemoteException 
    {
        m_firstOperand = firstOperand;
        m_firstOperandSet = true;
    }

    @Override
    public void setSecondOperand(double secondOperand) throws RemoteException 
    {
        m_secondOperand = secondOperand;
        m_secondOperandSet = true;
    }

    @Override
    public Result getResult() throws RemoteException 
    {
        return m_result;
    }

    private void setResult(Result result)
    {
        m_result = result;
        m_firstOperandSet = false;
        m_secondOperandSet = false;
        
        if(result.hasNoError())
        {
            m_firstOperand = result.getNumber();
            m_firstOperandSet = true;
        }
    }
    
    private void checkSecondOperandValue()
    {
        if(!m_secondOperandSet)
            m_secondOperand = m_firstOperand;
    }
    
    @Override
    public void add() throws RemoteException 
    {
        checkSecondOperandValue();
        //Overflow?
        setResult(new Result(m_firstOperand + m_secondOperand));
    }

    @Override
    public void subtract() throws RemoteException 
    {
       checkSecondOperandValue();
       setResult(new Result(m_firstOperand - m_secondOperand));
    }

    @Override
    public void multiply() throws RemoteException 
    {
        checkSecondOperandValue();
        setResult(new Result(m_firstOperand * m_secondOperand));
    }

    @Override
    public void divide() throws RemoteException 
    {
        checkSecondOperandValue();
        setResult(new Result(m_firstOperand / m_secondOperand));
    }

    private double getCurrentOperand()
    {
        if(m_secondOperandSet)
            return m_secondOperand;
        return m_firstOperand;
    }
    
    private void setCurrentOperand(Result result)
    {
        m_result = result;
        if(result.hasError())
            return;
        
        if(m_secondOperandSet)
            m_secondOperand = result.getNumber();
        else
            m_firstOperand = result.getNumber();
    }
    
    @Override
    public void invert() throws RemoteException 
    {
        setCurrentOperand(new Result(1.0 / getCurrentOperand()));
    }

    @Override
    public void pow() throws RemoteException 
    {
        checkSecondOperandValue();
        setResult(new Result(Math.pow(m_firstOperand, m_secondOperand)));
    }

    @Override
    public void factorial() throws RemoteException 
    {
        int result = 1;
        for(int i = (int) getCurrentOperand(); i > 1; --i)
            result *= i;
        setCurrentOperand(new Result(result));
    }

    @Override
    public void sqrt() throws RemoteException 
    {
        setCurrentOperand(new Result(Math.sqrt(getCurrentOperand())));
    }

    @Override
    public boolean isFirstOperandSet() throws RemoteException 
    {
        return m_firstOperandSet;
    }

    @Override
    public boolean isSecondOperandSet() throws RemoteException 
    {
        return m_secondOperandSet;
    }

    @Override
    public void memoryAdd() throws RemoteException 
    {
        
    }

    @Override
    public void memorySubtract() throws RemoteException 
    {
        
    }

    @Override
    public void memoryStore() throws RemoteException 
    {
        
    }

    @Override
    public void memoryRead() throws RemoteException 
    {
        
    }

    @Override
    public void memoryClear() throws RemoteException 
    {
        
    }
    
}
