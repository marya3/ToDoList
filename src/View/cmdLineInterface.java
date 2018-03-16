/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import controller.ProcessCommand;
import java.util.ArrayList;
import java.util.Scanner;
public class cmdLineInterface {
    Scanner scanner;
    ProcessCommand pc;
    ArrayList<TaskDTO> taskDTOTaskList;
    int option;
    
    public cmdLineInterface()
    {
        scanner = new Scanner(System.in);
        pc = new ProcessCommand();
    }
    
    public void showMainMenu()
    {
        System.out.println(">> Welcome to ToDoly ");
        System.out.println(">> You have X tasks todo and Y tasks are done! ");
        System.out.println(">> Pick an option: ");
        System.out.println(">> (1) Show Task List (by date or project) ");
        System.out.println(">> (2) Add New Task ");
        System.out.println(">> (3) Edit Task (update, mark as done, remove) ");
        System.out.println(">> (4) Save and Quit ");
        System.out.print(">> ");
    }
    public int getUserInput()
    {
        String userinput = scanner.next();
        try
        {
            int choice = Integer.parseInt(userinput);
            return choice;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter correct option");
            return -1;
        }
    }
    private boolean validateUserInput(int low,int high, int input)
    {
        if (input == -1)
        {
            return false;
        }
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
    public void processUserInput()
    {   
        showMainMenu();
        option = getUserInput();
        boolean userDone = false;
        //while (option != 4)
        while(!userDone)
        {
            if (validateUserInput(1, 4, option))
            {
                switch (option)
                {
                    case 1: showReportHeading();
                            showReport();break;
                            //pc.processCommand(option,null);;break;
                    case 2: showAddTaskMenu();break;
                    case 3: edit();break;
                    case 4:pc.processCommand(4, null); 
                        userDone = true;break;
                }
                if (!userDone)
                {
                    showMainMenu();
                    option = getUserInput();

                }
            }
            else
            {
                option = getUserInput();
            }
        }
    }
    public void showAddTaskMenu()
    {
        System.out.println(">> Welcome to ToDoly ");
        System.out.println(">> You Picked option:2 to add a task ");
        System.out.println("Please enter following details ");
        
        System.out.print("Project: ");
        String project = scanner.next(); 
        System.out.print("Title for the Task: ");
        String title = scanner.next();
        System.out.print("DueDate: ");
        String date = scanner.next();
        System.out.println(">> ");
                
        TaskDTO tdto = new TaskDTO(project, title, date,"","Created","Green");
        
        pc.processCommand(option,tdto);
    }
            
    public void edit()
    {
        showReportHeading();
        showReport();
        System.out.print("Enter the number of task you want to edit: ");
        
        int taskNo = getUserInput();
        boolean validChoice = false;
        while(!validChoice)
            if (validateUserInput(1, taskDTOTaskList.size(), taskNo))
            {
                validChoice = true;
            }
            else
            {
                taskNo = getUserInput();
            
            }
        System.out.println("1 To change Project");
        System.out.println("2 To change Title");
        System.out.println("3 To change Duedate");
        System.out.print("Enter you choice: ");
        
        int editOption = getUserInput();
        validChoice = false;
        while(!validChoice)
            if (validateUserInput(1, 3, editOption))
            {
                validChoice = true;
            }
            else
            {
                editOption = getUserInput();
            
            }
        switch (editOption)
        {
            case 1: System.out.print("Enter project :");
                    String pr = scanner.next();
                    pc.edit(taskNo, editOption,pr);break;
            case 2: System.out.print("Enter title :");
                    String tt = scanner.next();
                    pc.edit(taskNo, editOption,tt);break; 
            case 3: System.out.print("Enter DueDate :");
                    String date = scanner.next();
                    pc.edit(taskNo, editOption,date);break;
            case 4: System.out.print("Enter status :");
                    String status = scanner.next();
                    pc.edit(taskNo, editOption,status);break;
        }        
    }
    public void showReportHeading()
    {
        /*
        System.out.print("Project");
        System.out.print("         ");
        System.out.print("Title");
        System.out.print("         ");
        System.out.print("Due Date");
        System.out.print("         ");
        System.out.print("Status");
        System.out.print("         ");
        System.out.println("Alert");
        */
        printRow("Project","Title","DueDate","Status","Alert");
        printRow("-------","-----","-------","------","-----");
    }
    private void printRow(String c0, String c1, String c2, String c3, String c4)
    {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s%n", c0, c1, c2,c3, c4);
    }       
    public void showReport()
    {
        
        
        taskDTOTaskList = pc.showTL();
        //TaskDTO tdto = pc.showTL();
        for(TaskDTO tdto:taskDTOTaskList)
        //while (tdto != null)
        {   
            printRow(tdto.getProjectDTO(),
                tdto.getTitleDTO(),
                tdto.getDueDateDTO(),
                tdto.getStatusDTO(),
                tdto.getAlertDTO());
        }
    }
}