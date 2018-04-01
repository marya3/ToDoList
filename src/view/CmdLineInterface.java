/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import utility.HandleInputAndValidation;
import controller.ProcessCommand;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;
import utility.*;


public class CmdLineInterface {
    Scanner scanner;
    ProcessCommand pc;
    ArrayList<TaskDTO> taskDTOTaskList;
    ArrayList<CompletedTasksDTO> completedTaskDTOList;
    StaticDisplays staticDisplay;
    HandleInputAndValidation handleInputFromUser;
    int option;
    
    public CmdLineInterface(ProcessCommand pCmd)
    {
        scanner = new Scanner(System.in);
        pc = pCmd;
        staticDisplay = new StaticDisplays();
        handleInputFromUser = new HandleInputAndValidation();
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
            staticDisplay.showMainMenu();
            option = handleInputFromUser.getInputAndValidate(1,5);
            
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
                case 5: showStatistics();
                        break;
            }
        }
    }
    /**
     * method to handle tasks display to the user
     */
    public void showTaskToTheUser()
    {
        staticDisplay.showReportingMenu();
        option = handleInputFromUser.getInputAndValidate(1, 5);
        
        switch(option)
        {
            case 1: loadTasks();
                    staticDisplay.showReportHeading();
                    showReport(taskDTOTaskList);
                    break;
            case 2: showOneAtTime();break;
            case 3: sortedByDate();break;
            case 4: filterByProject();break;
            case 5: showCompletedTasks();break;
            //case 6: showStatistics();break;
        }
    }
    /**
     * method to receive user inputs for creating a task
     * 
     */
    public void addTask()
    {
        System.out.println("Please enter following details ");
        
        System.out.print("Project: ");
        String project = scanner.nextLine();
        
        System.out.print("Title for the Task: ");
        String title = scanner.nextLine();
        
        String date = handleInputFromUser.getValidatedDate();
        //System.out.print("enter date");
        //String date = handleInputFromUser.getUserInputString();
        
        //System.out.println("days between dates: " + 
        //handleInputFromUser.getDaysBetweenDates());
        
        String alert=PossibleAlerts.GREEN.toString();
        switch((int)handleInputFromUser.getDaysBetweenDates())
        {
            case 0: alert = PossibleAlerts.RED.toString();break;
            case 1: alert = PossibleAlerts.YELLOW.toString();break;
        }
        
        TaskDTO tdto = new TaskDTO(project, title, date,
        PossibleStatuses.CREATED.toString(),alert);
        pc.createTask(tdto);
        
        System.out.println("Task Added successfully ");
    }
    /**
     * method to handle edit task. It reads the task number which is to be edited
     * takes user input for the attribute to be edited
     * takes user input for the new value of the attribute
     * passes all information to controller
     */
    public void editTask()
    {
        loadTasks();
        staticDisplay.showReportHeading();
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
                int taskNo = handleInputFromUser
                             .getInputAndValidate(0, taskDTOTaskList.size());

                //System.out.println("0 To EXIT edit Menu");
                if (taskNo == 0)
                {
                    userDone = true;
                }
                else
                {
                    staticDisplay.showEditMenu();
                    int editOption = handleInputFromUser.getInputAndValidate(0, 5);
                    switch (editOption)
                    {
                        //case 0: userDone = true;break;
                        case 1: System.out.print("Enter project :");
                                String pr = scanner.nextLine();
                                pc.edit(taskNo, editOption,pr);break;
                        case 2: System.out.print("Enter title :");
                                String tt = scanner.nextLine();
                                pc.edit(taskNo, editOption,tt);break; 
                        case 3: System.out.print("Enter DueDate :");
                                String date = handleInputFromUser.getValidatedDate();
                                pc.edit(taskNo, editOption,date);break;
                        case 4: String status = handleInputFromUser.getValidatedStatus();
                                pc.edit(taskNo, editOption,status);break;
                        case 5: pc.edit(taskNo, editOption,"DELETE");break;
                    }
                    staticDisplay.showReportHeading();
                    loadTasks();
                    showReport(taskDTOTaskList);
                }    
            }
        }
    }
    
 
    /**
     * method to display all the tasks at a time
     * @param taskDTOArrayList 
     */
    public void showReport(ArrayList<TaskDTO> taskDTOArrayList)
    {
        int i = 0;
        for(TaskDTO tdto:taskDTOArrayList)
        {   
            populateItemFromList(++i, tdto);
        }
    }
    
    /**
     * method to get the tasks from model to view
     */
    private void loadTasks()
    {
        taskDTOTaskList = pc.getTaskList();
    }
    
    /**
     * method to get completed tasks from model to view
     */
    private void loadCompletedTasks()
    {
        completedTaskDTOList = pc.getCompletedTaskList();
    }
    
    /**
     * method to call controller method save arrayLists of open tasks and 
     * completed tasks to files.
     */
    private void exitTask()
    {
        pc.quit();
    }
    
    
    /**
     * method to display one task at a time
     * user can display next task or previous task.
     */
    
    public void showOneAtTime()
    {
        loadTasks();
        ListIterator<TaskDTO> it = taskDTOTaskList.listIterator();
        staticDisplay.showReportHeading();
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
//        boolean changeOfDirection = false;
//        int lowIndex = 0;
//        int highIndex = 2;
        while (!userDone)
        {
            editShowExitmenu();
            if (it.hasNext())
            {
                
                if(it.hasPrevious())
                {
                    editShowNextMenu();
                    editShowPrevMenu();
                    option = handleInputFromUser.getInputAndValidate(0,2);
                }
                else
                {
                    editShowNextMenu();
                    option = handleInputFromUser.getInputAndValidate(0,1);
                }
            }
            else if(it.hasPrevious())
            {
                editShowPrevMenu();
                option = handleInputFromUser.getInputAndValidate(0,2);
                while (option == 1)
                {
                    System.out.println("Please enter correct choice");
                    option = handleInputFromUser.getInputAndValidate(0,2);
                    
                }
            }
            
            switch(option)
            {
                case 0: userDone = true;break;
                case 1: staticDisplay.showReportHeading();
                        //TaskDTO obj = it.next();
                        //if(!changeOfDirection){it.next();}
                        populateItemFromList(++i,it.next());
                                ;break;
                        
//                        populateItemFromList(obj);break;
                case 2: staticDisplay.showReportHeading();
                        //it.previous();
                        populateItemFromList(--i,it.previous());
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
    public void populateItemFromList(int taskNo,TaskDTO tdto)
    {
        staticDisplay.printRow(Integer.toString(taskNo),
                 tdto.getProjectDTO(),
                 tdto.getTitleDTO(),
                 tdto.getDueDateDTO(),
                 tdto.getStatusDTO(),
                 tdto.getAlertDTO());
    }
    
    /**
     * 
     */
    public static Comparator<TaskDTO> taskDateComparator = new Comparator<TaskDTO>()
    {
      /**
       * @override
       * @param task1
       * @param task2
       * @return 
       */
      @Override
      public int compare(TaskDTO task1, TaskDTO task2) {
      String dueDate1 = task1.getDueDateDTO();
      String dueDate2 = task2.getDueDateDTO();
      return dueDate1.compareTo(dueDate2);
      }
    };
    
    public void sortedByDate(){
        
        //taskDTOTaskList = pc.getTaskList();
        loadTasks();
        Collections.sort(taskDTOTaskList,taskDateComparator);
        System.out.println("Task List Sorted on Date");
        staticDisplay.showReportHeading();
        showReport(taskDTOTaskList);
    }
    
    
    /**
     * method to accept user input for project and display all the tasks for 
     * that project
     */
    public void filterByProject()
    {
        loadTasks();
        System.out.println("Enter the project: ");
        String projectToView = scanner.next();
        ArrayList<TaskDTO> taskDTOTaskListFiltered;
        
        taskDTOTaskListFiltered = taskDTOTaskList.stream()
        .filter(taskdto -> projectToView.equals(taskdto.getProjectDTO()))
        .collect(Collectors.toCollection(ArrayList::new));
        if (taskDTOTaskListFiltered.isEmpty())
        {
            System.out.println("Project not created yet");
        }
        else 
        {
            staticDisplay.showReportHeading();
            showReport(taskDTOTaskListFiltered);
        }
    }
    
    /**
     * method to display all completed tasks
     */
    public void showCompletedTasks()
    {
        loadCompletedTasks();
        staticDisplay.showReportHeadingForCompletedTask();
        showcompletedTaskReport(completedTaskDTOList);
        
    }
    
    /**
     * method to display statistics like 
     * open tasks
     * closed tasks
     * tasks closed before due date
     * tasks closed after due date
     * % of tasks met due date
     * % of tasks missed due date
     */
    public void showStatistics()
    {
        loadTasks();
        loadCompletedTasks();
        staticDisplay.showReportHeadingForStat();
        int openTasks, completedTasks, completedOnTime, 
            missedDate;
        double successRate, missedRate;
        long missedDateLong;
        openTasks = taskDTOTaskList.size();
        
        
        if(!(completedTaskDTOList.isEmpty())){
           
            completedTasks = completedTaskDTOList.size();
        
            missedDateLong = completedTaskDTOList.stream()
                         .filter(cT -> cT.getAlertDTO().equals("MISSED"))
                         .count();
            missedDate = (int) missedDateLong;
            completedOnTime = completedTasks - missedDate;

            missedRate = (((double)missedDate/(double)completedTasks)*100);
            DecimalFormat df = new DecimalFormat("##.00");
            successRate = 100 - missedRate;
            staticDisplay.printRow(String.valueOf(openTasks), 
                    String.valueOf(completedTasks),
                    String.valueOf(completedOnTime),
                    String.valueOf(missedDate),
                    String.valueOf(df.format(successRate)),
                    String.valueOf(df.format(missedRate)));
        }
    }
    
    public void showcompletedTaskReport(ArrayList<CompletedTasksDTO> completedtaskDTOArrayList)
    {
        int i = 0;
        for(CompletedTasksDTO tdto:completedtaskDTOArrayList)
        {   
            staticDisplay.printRow(   Integer.toString(++i),
                        tdto.getProjectDTO(),
                        tdto.getTitleDTO(),
                        tdto.getDueDateDTO(),
                        tdto.getDateOfCompletionDTO(),
                        tdto.getAlertDTO());
        }
    }
}