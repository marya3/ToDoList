/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

/**
 *
 * @author tmp-sda-1161
 */

import controller.ProcessCommand;

import java.util.Scanner;
public class cmdLineInterface {
    Scanner scanner = new Scanner(System.in);
    ProcessCommand pc = new ProcessCommand();
    int option;
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
        option = Integer.parseInt(userinput);
        System.out.println(userinput);
        
        switch (option)
        {
        case 1: showReportHeading();
                showReport();break;
                //pc.processCommand(option,null);;break;
        case 2: System.out.println("user selected 2");showAddTaskMenu();break;
        case 3: edit();break;
        case 4: pc.processCommand(4, null);break;
        case 5: System.out.println("user selected 5");break;
        case 6: System.out.println("user selected 6");break;
        case 7: System.out.println("user selected 7");break;
        }
        
        return option;
    }
    public void showAddTaskMenu()
    {
        System.out.println(">> Welcome to ToDoly ");
        System.out.println(">> You Picked option:2 to add a task ");
        System.out.println("Please enter following details ");
        
        System.out.println("Project: ");
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
        String userinput = scanner.next();
        int taskNo = Integer.parseInt(userinput);
        System.out.println("1 To change Project");
        System.out.println("2 To change Title");
        System.out.println("3 To change Duedate");
        System.out.print("Enter you choice: ");
        String whatToChange = scanner.next();
        int editOption = Integer.parseInt(whatToChange);
        
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
        System.out.print("Project");
        System.out.print("         ");
        System.out.print("Title");
        System.out.print("         ");
        System.out.print("Due Date");
        System.out.print("         ");
        System.out.print("Status");
        System.out.print("         ");
        System.out.println("Alert");
    }
            
    public void showReport()
    {
        TaskDTO tdto = pc.showTL();
        while (tdto != null)
        {
            System.out.print(tdto.getProjectDTO());
            System.out.print("         ");
            System.out.print(tdto.getTitleDTO());
            System.out.print("         ");
            System.out.print(tdto.getDueDateDTO());
            System.out.print("         ");
            System.out.print(tdto.getStatusDTO());
            System.out.print("         ");
            System.out.println(tdto.getAlertDTO());
            tdto = pc.showTL();
        }
    }
}