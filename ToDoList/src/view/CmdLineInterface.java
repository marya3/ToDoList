/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import controller.ProcessCommand;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.time.format.*;
import java.time.*;
import java.util.Date;
import java.text.*;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;

public class CmdLineInterface {
    Scanner scanner;
    ProcessCommand pc;
    ArrayList<TaskDTO> taskDTOTaskList;
    int option;
    
    public CmdLineInterface(ProcessCommand pCmd)
    {
        scanner = new Scanner(System.in);
        pc = pCmd;
        taskDTOTaskList = pc.getTaskList();
    }
    /**
     * main module in view which loops till the user wants to interact with the 
     * application.
     */
    public void startApplication()
    {   
        boolean userDone = false;
        while(!userDone)
        {
            showMainMenu();
            option = getInputAndValidate(1,4);
            
            switch (option)
            {
                case 1: showTaskToTheUser();
                        break;
                case 2: addTask();
                        break;
                case 3: editTask();
                        break;
                case 4: exitTask();
                        userDone = true;
                        break;
            }
        }
    }
    
    /**
     * Method which is used for showing the options to the user
     */
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
    
    public void showTaskToTheUser()
    {
        System.out.println("1 To Show entire List");
        System.out.println("2 To View one at a time");
        System.out.println("3 To View sorted by Date");
        System.out.println("4 To Filter by Project");
        
        
        System.out.print("Enter you choice: ");
        option = getInputAndValidate(1, 4);
        switch(option)
        {
            case 1: showReportHeading();
                    showReport(taskDTOTaskList);
                    break;
            case 2: showOneAtTime();break;
            case 3: sortedByDate();break;
            case 4: filterByProject();break;
        }
    }
    public void addTask()
    {
        System.out.println(">> Welcome to ToDoly ");
        System.out.println(">> You Picked option:2 to add a task ");
        System.out.println("Please enter following details ");
        
        System.out.print("Project: ");
        String project = scanner.next(); 
        System.out.print("Title for the Task: ");
        String title = scanner.next();
        System.out.print("Enter DueDate in the format:MM/DD/YYYY ");
        String date = scanner.next();
        while(!validateDate(date))
        {
            System.out.print("Enter DueDate in the format(MM/DD/YYYY): ");
            date = scanner.next();
        }
        System.out.println(">> ");
                
        TaskDTO tdto = new TaskDTO(project, title, date,"","Created","Green");
        
        pc.createTask(tdto);
    }
    /**
     * 
     * @param inputDate as String, date entered by the user.
     * @return true if it a valid date else false
     */
    
    private boolean validateDate(String inputDate)
    {
        try {
            DateTimeFormatter formatter;  
            formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
            LocalDate date = LocalDate.parse(inputDate, formatter);
            
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            Date today = new Date();        
            String reportDate = df.format(today);
            LocalDate todayLocalDate = 
            LocalDate.parse(reportDate,formatter);
            
            if(todayLocalDate.isAfter(date)== true)
            {
                System.out.println("Date cannot be in the past");
                return false;
            }
            return true;
        }
        catch (DateTimeParseException exc) {
            System.out.printf("Invalid Date " );
            System.out.println(exc);
                  // Rethrow the exception.
            return false;
        }
    }

    public void editTask()
    {
        showReportHeading();
        showReport(taskDTOTaskList);
        if (taskDTOTaskList.isEmpty())
        {
            System.out.println("Nothing to edit ");
        }
        else
        {
            boolean userDone = false;
            while(!userDone)
            {
                System.out.print
                ("Enter the task Number you want to edit/remove or 0 to exit: ");
                int taskNo = getInputAndValidate(0, taskDTOTaskList.size());


                //System.out.println("0 To EXIT edit Menu");
                if (taskNo == 0)
                {
                    userDone = true;
                }
                else
                {
                    System.out.println("1 To update Project");
                    System.out.println("2 To update Title");
                    System.out.println("3 To update Duedate");
                    System.out.println("4 To update Status");
                    System.out.println("5 to remove the task");
                    System.out.print("Enter you choice: ");
                    int editOption = getInputAndValidate(0, 5);
                    switch (editOption)
                    {
                        //case 0: userDone = true;break;
                        case 1: 
                                System.out.print("Enter project :");
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
                        case 5: System.out.print("Enter status :");
                                pc.edit(taskNo, editOption,"delete");break;
                    }
                    showReportHeading();
                    showReport(taskDTOTaskList);
                }    
            }
        }
    }
    public void showReportHeading()
    {
        printRow("Task Number","Project","Title","DueDate","Status","Alert");
        printRow("-----------","-------","-----","-------","------","-----");
    }
    
    private void printRow(String c0, String c1, 
                          String c2, String c3, String c4, String c5)
    {
        System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s%n", 
                          c0, c1, c2,c3, c4, c5);
    }       
    
    public void showReport(ArrayList<TaskDTO> taskDTOArrayList)
    {
        int i = 0;
        
        //loadTasks();
        for(TaskDTO tdto:taskDTOArrayList)
        {   
            printRow(   Integer.toString(++i),
                        tdto.getProjectDTO(),
                        tdto.getTitleDTO(),
                        tdto.getDueDateDTO(),
                        tdto.getStatusDTO(),
                        tdto.getAlertDTO());
        }
    }
    
    private void loadTasks()
    {
        taskDTOTaskList = pc.getTaskList();
    }
    private void exitTask()
    {
        pc.quit();
    }
    
    public int getInputAndValidate(int low,int high)
    {
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
            int choice = Integer.parseInt(userinput);
            return choice;
        }
        catch (NumberFormatException e)
        {
            System.out.println("Please enter correct option");
            return -1;
        }
    }
    /**
     * Validates if the user has inputted the options shown on the screen.
     * @param lowest value that is accepted as the option from the menu
     * @param highest value that is accepted as the option from the menu
     * @param input value entered by the user
     * @return true is the value entered is acceptable
     */
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
    
    public void showOneAtTime()
    {
        taskDTOTaskList = pc.getTaskList();
        ListIterator<TaskDTO> it = taskDTOTaskList.listIterator();
        showReportHeading();
        int i=0;
        if (taskDTOTaskList.isEmpty())
        {
            System.out.print("List is empty");
            
        }
        else
        {
            //it.next();
            //populateItemFromList(taskDTOTaskList.get(0));
        }
        
        boolean userDone = false;
        boolean changeOfDirection = false;
        int lowIndex = 0;
        int highIndex = 2;
        while (!userDone)
        {
            editShowExitmenu();
            if (it.hasNext())
            {
                
                if(it.hasPrevious())
                {
                    editShowNextMenu();
                    editShowPrevMenu();
                    option = getInputAndValidate(0,2);
                }
                else
                {
                    editShowNextMenu();
                    option = getInputAndValidate(0,1);
                }
            }
            else if(it.hasPrevious())
            {
                editShowPrevMenu();
                option = getInputAndValidate(0,2);
                while (option == 1)
                {
                    System.out.println("Please enter correct choice");
                    option = getInputAndValidate(0,2);
                    
                }
            }
            
            switch(option)
            {
                case 0: userDone = true;break;
                case 1: showReportHeading();
                        //TaskDTO obj = it.next();
                        //if(!changeOfDirection){it.next();}
                        populateItemFromList(it.next());
                                ;break;
                        
//                        populateItemFromList(obj);break;
                case 2: showReportHeading();
                        //it.previous();
                        populateItemFromList(it.previous());
                        break;
//                        TaskDTO obj1 = it.previous();
//                        populateItemFromList(obj1);break;
            }
        }
    }
    public void editShowNextMenu()
    {
        System.out.println("Enter 1 to show Next");
       
    }
    public void editShowPrevMenu()
    {
        System.out.println("Enter 2 to show Prev");
       
    }
    public void editShowExitmenu()
    {
        System.out.println("Enter 0 to Exit");
    }
    public void populateItemFromList(TaskDTO tdto)
    {
        printRow(Integer.toString(1),
                 tdto.getProjectDTO(),
                 tdto.getTitleDTO(),
                 tdto.getDueDateDTO(),
                 tdto.getStatusDTO(),
                 tdto.getAlertDTO());
    }
    
    public static Comparator<TaskDTO> taskDateComparator = new Comparator<TaskDTO>()
    {
      public int compare(TaskDTO task1, TaskDTO task2) {
      String dueDate1 = task1.getDueDateDTO();
      String dueDate2 = task2.getDueDateDTO();
      return dueDate1.compareTo(dueDate2);
      }
    };
    
    public void sortedByDate(){
        
        //taskDTOTaskList = pc.getTaskList();
        Collections.sort(taskDTOTaskList,taskDateComparator);
        System.out.println("Task List Sorted on Date");
        showReportHeading();
        showReport(taskDTOTaskList);
    }
    
    public void filterByProject()
    {
        System.out.println("Enter the project: ");
        String projectToView = scanner.next();
        ArrayList<TaskDTO> taskDTOTaskListFiltered = new ArrayList<>();
        
        taskDTOTaskListFiltered = taskDTOTaskList.stream()
        .filter(taskdto -> projectToView.equals(taskdto.getProjectDTO()))
        .collect(Collectors.toCollection(ArrayList::new));
        if (taskDTOTaskListFiltered.isEmpty())
        {
            System.out.println("Project not created yet");
        }
        else 
        {
            showReportHeading();
            showReport(taskDTOTaskListFiltered);
        }
    }
}