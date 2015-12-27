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
public class ExtendedOperationsTests {
    
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
    public void invertTest() throws RemoteException
    {
        calculator.setFirstOperand(0);
        calculator.setSecondOperand(2);
        calculator.invert();
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(0.5, result.getNumber(), 0.0001);
    }
    
    @Test
    public void powTest() throws RemoteException
    {
        calculator.setFirstOperand(2);
        calculator.setSecondOperand(10);
        calculator.pow();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(1024, result.getNumber(), 0.0001);
    }
    
    @Test
    public void factorialTest() throws RemoteException
    {
        calculator.setFirstOperand(10);
        calculator.factorial();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(3628800, result.getNumber(), 0.0001);
    }
    
    @Test
    public void sqrtTest() throws RemoteException
    {
        calculator.setFirstOperand(8);
        calculator.sqrt();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(2.8284, result.getNumber(), 0.0001);
    }
}
