/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author tmp-sda-1161
 */
public class HandleInputAndValidationTest {
    
    public HandleInputAndValidationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getInputAndValidate method, of class HandleInputAndValidation.
     */
    @Ignore
    @Test
    public void testGetInputAndValidate() {
        System.out.println("getInputAndValidate");
        int low = 0;
        int high = 0;
        HandleInputAndValidation instance = new HandleInputAndValidation();
        int expResult = 0;
        int result = instance.getInputAndValidate(low, high);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInput method, of class HandleInputAndValidation.
     */
    @Ignore
    @Test
    public void testGetUserInput() {
        System.out.println("getUserInput");
        HandleInputAndValidation instance = new HandleInputAndValidation();
        int expResult = 0;
        int result = instance.getUserInput();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValidatedDate method, of class HandleInputAndValidation.
     */
    @Ignore
    @Test
    public void testGetValidatedDate() {
        System.out.println("getValidatedDate");
        HandleInputAndValidation instance = new HandleInputAndValidation();
        String expResult = "";
        String result = instance.getValidatedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInputString method, of class HandleInputAndValidation.
     */
    @Ignore
    @Test
    public void testGetUserInputString() {
        System.out.println("getUserInputString");
        HandleInputAndValidation instance = new HandleInputAndValidation();
        String expResult = "";
        String result = instance.getUserInputString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserInputLongString method, of class HandleInputAndValidation.
     */
    @Ignore
    @Test
    public void testGetUserInputLongString() {
        System.out.println("getUserInputLongString");
        HandleInputAndValidation instance = new HandleInputAndValidation();
        String expResult = "";
        String result = instance.getUserInputLongString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateDate method, of class HandleInputAndValidation.
     */
    @Test
    public void testValidateDatePastDate() {
        System.out.println("Invalid Date");
        String inputDate = "03/31/2018";
        HandleInputAndValidation instance = new HandleInputAndValidation();
        boolean expResult = false;
        boolean result = instance.validateDate(inputDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    
    
    @Test
    public void testValidateDateValidDate() {
        System.out.println("valid Date");
        String inputDate = "04/12/2018";
        HandleInputAndValidation instance = new HandleInputAndValidation();
        boolean expResult = true;
        boolean result = instance.validateDate(inputDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    @Test
    public void testValidateDateInvalidInput() {
        System.out.println("validateDate");
        String inputDate = "20180412";
        HandleInputAndValidation instance = new HandleInputAndValidation();
        boolean expResult = false;
        boolean result = instance.validateDate(inputDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Validates if the user input falls between the lowest and the highest
     * allowed values.
     */
    @Test
    public void testvalidateUserInputValidInput(){
        int low = 0;
        int high = 5;
        int input = 4;
        HandleInputAndValidation instance = new HandleInputAndValidation();
        boolean expResult = true;
        boolean result = instance.validateUserInput(low, high, input);
        assertEquals(expResult, result);
    }
    /**
     * Validates if the user input falls between the lowest and the highest
     * allowed values.
     */
    @Test
    public void testvalidateUserInputInValidInput(){
        int low = 0;
        int high = 5;
        int input = 6;
        HandleInputAndValidation instance = new HandleInputAndValidation();
        boolean expResult = false;
        boolean result = instance.validateUserInput(low, high, input);
        assertEquals(expResult, result);
    }

    /**
     * Test of validStatus method, of class HandleInputAndValidation.
     */
    
    @Test
    public void testValidStatusInprogress() {
        System.out.println("validStatus");
        String userInput = "inprogress";
        HandleInputAndValidation instance = new HandleInputAndValidation();
        boolean expResult = true;
        boolean result = instance.validStatus(userInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of validStatus method, of class HandleInputAndValidation.
     */
    
    @Test
    public void testValidStatusInvalidSatus() {
        System.out.println("InvalidStatus");
        String userInput = "done";
        HandleInputAndValidation instance = new HandleInputAndValidation();
        boolean expResult = false;
        boolean result = instance.validStatus(userInput);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    
    /**
     * Test of getDaysBetweenDates method, of class HandleInputAndValidation.
     */
    @Ignore
    @Test
    public void testGetDaysBetweenDates() {
        System.out.println("getDaysBetweenDates");
        HandleInputAndValidation instance = new HandleInputAndValidation();
        long expResult = 0L;
        long result = instance.getDaysBetweenDates();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
