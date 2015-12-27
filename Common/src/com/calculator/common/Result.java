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
    
    public Result(double number)
    {
        m_number = number;
    }
    
    public Result()
    {
        this(0);
    }
    
    public double getNumber()
    {
        return m_number;
    }
    
    public void setNumber(double number)
    {
        m_number = number;
    }
}
