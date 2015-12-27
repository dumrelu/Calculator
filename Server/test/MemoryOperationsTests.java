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
public class MemoryOperationsTests {
    
    private Calculator calculator;
    
    @Before
    public void setUp() throws RemoteException
    {
        calculator = new Calculator();
        calculator.setFirstOperand(0);
        calculator.setSecondOperand(100);
        calculator.memoryStore();
        calculator.setSecondOperand(0);
    }
    
    @After
    public void tearDown() 
    {
        calculator = null;
    }

    @Test
    public void readStoreTest() throws RemoteException
    {
        calculator.memoryRead();
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(100, result.getNumber(), 0.0001);
    }
    
    @Test
    public void addTest() throws RemoteException
    {
        calculator.setSecondOperand(1);
        calculator.memoryAdd();
        calculator.memoryRead();
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(101, result.getNumber(), 0.0001);
    }
    
    @Test
    public void subtractTest() throws RemoteException
    {
        calculator.setSecondOperand(1);
        calculator.memorySubtract();
        calculator.memoryRead();
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(99, result.getNumber(), 0.0001);
    }
    
    @Test
    public void clearTest() throws RemoteException
    {
        calculator.memoryClear();
        calculator.memoryRead();
        calculator.add();
        
        Result result = calculator.getResult();
        assertFalse(result.hasError());
        assertEquals(0, result.getNumber(), 0.0001);
    }
}
