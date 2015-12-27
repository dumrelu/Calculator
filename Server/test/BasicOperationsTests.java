/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.calculator.common.Result;
import com.calculator.server.Calculator;
import java.rmi.RemoteException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Relu
 */
public class BasicOperationsTests {
    
    private Calculator calculator;
    
    @Before
    public void setUp() throws RemoteException 
    {
        calculator = new Calculator();
    }
    
    @After
    public void tearDown() 
    {
        calculator = null;
    }

    
    @Test
    public void addTest() throws RemoteException
    {
        calculator.setFirstOperand(1);
        calculator.setSecondOperand(2);
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(3, calculator.getResult().getNumber(), 0.00001);
    }
    
    @Test
    public void subtractTest() throws RemoteException
    {
        calculator.setFirstOperand(10.5);
        calculator.setSecondOperand(7.1);
        calculator.subtract();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(3.4, calculator.getResult().getNumber(), 0.00001);
    }
    
    @Test
    public void multiplyTest() throws RemoteException
    {
        calculator.setFirstOperand(6.32);
        calculator.setSecondOperand(9.55);
        calculator.multiply();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(60.356, calculator.getResult().getNumber(), 0.00001);
    }
    
    @Test
    public void divideTest() throws RemoteException
    {
        calculator.setFirstOperand(4758);
        calculator.setSecondOperand(32);
        calculator.divide();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(148.6875, calculator.getResult().getNumber(), 0.00001);
    }
}
