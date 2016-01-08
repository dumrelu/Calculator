package com.calculator.common;

import java.io.Serializable;

/**
 *  Incapsuleaza resultatul si erorile operatiilor 
 * efectuate de calculator.
 * 
 * TODO: erori.
 * 
 * @author Relu
 */
public class Result implements Serializable
{
    private double m_number;
    private String m_error;
    
    public Result(double number)
    {
        m_number = number;
        m_error = null;
    }
    
    public Result()
    {
        this(0);
    }
    
    public Result(String error)
    {
        m_error = error;
    }
    
    public double getNumber()
    {
        return m_number;
    }
    
    public String getError()
    {
        return m_error;
    }
    
    public void setNumber(double number)
    {
        m_number = number;
    }
    
    public boolean hasError()
    {
        return m_error != null;
    }
    
    public boolean hasNoError()
    {
        return !hasError();
    }
}
