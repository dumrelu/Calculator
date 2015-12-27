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
public class StateTest {
    
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
    public void resultStateTest() throws RemoteException
    {
        calculator.setFirstOperand(1);
        calculator.setSecondOperand(2);
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(3, calculator.getResult().getNumber(), 0.00001);
        
        calculator.setSecondOperand(4);
        calculator.multiply();
        
        result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(12, calculator.getResult().getNumber(), 0.00001);
    }
    
    @Test
    public void isOperandSetTest() throws RemoteException
    {
        calculator.setFirstOperand(1);
        assertTrue(calculator.isFirstOperandSet());
        assertFalse(calculator.isSecondOperandSet());
        calculator.setSecondOperand(2);
        assertTrue(calculator.isSecondOperandSet());
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(3, calculator.getResult().getNumber(), 0.00001);
        assertTrue(calculator.isFirstOperandSet());
        assertFalse(calculator.isSecondOperandSet());
    }
}
