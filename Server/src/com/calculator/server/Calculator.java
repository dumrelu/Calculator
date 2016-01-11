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
    private double m_memory;

    public Calculator() throws RemoteException
    {
        m_result = new Result();
        m_firstOperand = 0.0;
        m_firstOperandSet = true;
        m_secondOperand = 0.0;
        m_secondOperandSet = false;
        m_memory = 0;
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
        m_firstOperand = 0;
        m_firstOperandSet = true;
        m_secondOperand = 0;
        m_secondOperandSet = false;
        
        if(result.hasNoError())
        {
            m_firstOperand = result.getNumber();
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
        double result = m_firstOperand + m_secondOperand;
        if(Double.isInfinite(result))
            setResult(new Result("Overflow"));
        else 
            setResult(new Result(result));
    }

    @Override
    public void subtract() throws RemoteException 
    {
       checkSecondOperandValue();
       double result = m_firstOperand - m_secondOperand;
        if(Double.isInfinite(result))
            setResult(new Result("Overflow"));
        else 
            setResult(new Result(result));
    }

    @Override
    public void multiply() throws RemoteException 
    {
        checkSecondOperandValue();
        double result = m_firstOperand * m_secondOperand;
        if(Double.isInfinite(result))
            setResult(new Result("Overflow"));
        else 
            setResult(new Result(result));
    }

    @Override
    public void divide() throws RemoteException 
    {
        checkSecondOperandValue();
        double result = m_firstOperand / m_secondOperand;
        if(Double.isNaN(result))
            setResult(new Result("Undefined result"));
        else if(Double.isInfinite(result))
            setResult(new Result("Can't divide by 0"));
        else
            setResult(new Result(result));
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
        double result = 1.0 / getCurrentOperand();
        if(Double.isNaN(result))
            setCurrentOperand(new Result("Undefined result"));
        else if(Double.isInfinite(result))
            setCurrentOperand(new Result("Can't divide by 0"));
        else
            setCurrentOperand(new Result(result));
    }

    @Override
    public void pow() throws RemoteException 
    {
        checkSecondOperandValue();
        double result = Math.pow(m_firstOperand, m_secondOperand);
        if(Double.isInfinite(result))
            setResult(new Result("Overflow"));
        else 
            setResult(new Result(result));
    }

    @Override
    public void factorial() throws RemoteException 
    {
        int result = 1;
        int currentOperand = (int) getCurrentOperand();
        if(currentOperand < 0)
        {
            setCurrentOperand(new Result("Invalid input"));
            return;
        }
        
        for(int i = currentOperand; i > 1; --i)
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
        m_memory += getCurrentOperand();
    }

    @Override
    public void memorySubtract() throws RemoteException 
    {
        m_memory -= getCurrentOperand();
    }

    @Override
    public void memoryStore() throws RemoteException 
    {
        m_memory = getCurrentOperand();
    }

    @Override
    public void memoryRead() throws RemoteException 
    {
        setCurrentOperand(new Result(m_memory));
    }

    @Override
    public void memoryClear() throws RemoteException 
    {
        m_memory = 0.0;
    }

    @Override
    public void reset() throws RemoteException 
    {
        m_firstOperand = 0.0;
        m_firstOperandSet = true;
        m_secondOperand = 0.0;
        m_secondOperandSet = false;
    }

    @Override
    public double getFirstOperand() throws RemoteException 
    {
        return m_firstOperand;
    }

    @Override
    public double getSecondOperand() throws RemoteException 
    {
        return m_secondOperand;
    }
    
}
