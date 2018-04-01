/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;
import java.time.temporal.ChronoUnit;

public class HandleInputAndValidation {
    
    Scanner scanner = new Scanner(System.in);;
    Date today;
    DateTimeFormatter formatter;
    DateFormat df;       
    long daysBetweenDates;
    public HandleInputAndValidation()
    {
        formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        today = new Date();
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy");       
    }
/**
 * method to get input from user and validate it to fall in between the range 
 * defined by the low and high passed as parameters.
 * @param low - lower limit
 * @param high - higher limit
 * @return the validated user choice.
 */
    public int getInputAndValidate(int low,int high)
    {
        System.out.print("Enter you choice: ");
        int choice = getUserInput();
        boolean validChoice = false;
        while(!validChoice)
            if (validateUserInput(low, high, choice))
            {
                validChoice = true;
            }
            else
            {
                choice = getUserInput();
            
            }
        return choice;
    }
    /**
     * Method uses scanner to read the input provided by the user 
     * @return user input in integer form
     */
    public int getUserInput()
    {
        String userinput = scanner.next();
        try
        {
            System.out.println("inside getuserinput");
            int choice = Integer.parseInt(userinput);
            return choice;
        }
        catch (NumberFormatException e)
        {
            //System.out.println("Please enter correct option");
            return -1;
        }
    }
       
    /**
     * Validates if the user has inputted the options shown on the screen.
     * @param low - lowest value that is accepted as the option from the menu
     * @param high - highest value that is accepted as the option from the menu
     * @param input - value entered by the user
     * @return true is the value entered is acceptable
     */
    public boolean validateUserInput(int low,int high, int input)
    {
        if ((input <= high) && (input >= low))
        {
            return true;
        }
        else
        {
            System.out.println("Please enter correct option");
            return false;
        }
    }
    
    /**
     * method to read date from the user validates it to be in correct format
     * and in future.
     * @return validated date as String
     */
    public String getValidatedDate()
    {
        System.out.print("Enter DueDate in the format(MM/DD/YYYY): ");
        String userInputDate = getUserInputString();
        while(!validateDate(userInputDate))
        {
            System.out.print("Enter DueDate in the format(MM/DD/YYYY): ");
            userInputDate = getUserInputString();
        }
        return userInputDate;
    }
    
    public String getUserInputString()
    {
        return scanner.next();
    }
    
    public String getUserInputLongString()
    {
        return scanner.nextLine();
    }
    /**
     * 
     * @param inputDate as String, date entered by the user.
     * @return true if it a valid date else false
     */
    
    public boolean validateDate(String inputDate)
    {
        try {
            
            LocalDate date = LocalDate.parse(inputDate, formatter);
//            
//            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");       
//            String reportDate = df.format(today);
            
            LocalDate todayLocalDate = LocalDate.now();
//            LocalDate.parse(reportDate,formatter);
//            
            
//            Date dateToValidate = df.parse(inputDate);
            if(todayLocalDate.isAfter(date)== true)
//            if(dateToValidate.after(today))
            {
                System.out.println("Date cannot be in the past");
                return false;
            }
            
            daysBetweenDates = ChronoUnit.DAYS.between(todayLocalDate,date);
            
            return true;
        }
        catch (DateTimeParseException exc) {
            System.out.printf("Invalid Date " );
            System.out.println(exc);
                  // Rethrow the exception.
            return false;
        }
//        catch(ParseException pe){
//            System.out.printf("Invalid Date " );
//            System.out.println(pe);
//                  // Rethrow the exception.
//            return false;
//        }
            
    }
    
    /**
     * method to get valid status from the user. It shows the valid status that
     * a user can enter and validates the same.
     * @return validated status
     */
    public String getValidatedStatus()
    {
        System.out.println("Please enter any of the status");
        showValidStatuses();
        String userInput = scanner.next();
           
        while(!validStatus(userInput))
        {
            System.out.println("Please enter any of the status");
            showValidStatuses();
            userInput = scanner.next();
            
        }
        return userInput.toUpperCase();
    }
    
    /**
     * method to check the user input agains the list of statuses in enum.
     * @param userInput 
     * @return true if the status is one from the enum
     */
    public boolean validStatus(String userInput)
    {
        for (PossibleStatuses ps: PossibleStatuses.values())
            {
                if (ps.name().equals(userInput.toUpperCase()))
                {
                    return true;
                }
            }
        return false;
    }
    
    /**
     * method to display valid statuses. 
     */
    public void showValidStatuses()
    {    for (PossibleStatuses ps: PossibleStatuses.values())
        {
            System.out.print(ps.name() + " ");
        }
    }
    
    public long getDaysBetweenDates()
    {
        return daysBetweenDates;
    }
}
