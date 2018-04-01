/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tmp-sda-1161
 */
package model;

import java.util.ArrayList;
import java.util.ListIterator;
import view.TaskDTO;
import view.CompletedTasksDTO;
import utility.*;
import dbhandler.FileHandler;
import utility.HandleInputAndValidation;


public class TaskRepository {
    FileHandler fileHandler;    
    ArrayList<Task> taskList;
    ArrayList<CompletedTask> taskListCompleted;
    ListIterator<Task> taskIT;
    ListIterator<CompletedTask> taskCompletedIT;
    HandleInputAndValidation validateDate;

    public TaskRepository()
    {
        fileHandler = new FileHandler();
        taskList = new ArrayList<>();
        taskListCompleted = new ArrayList<>();
        validateDate = new HandleInputAndValidation();
    }
    /**
     * module adds the task to the arraylist.
     * @param tdto is the DTO containing the inputs entered by the user
     */    
    public void addTask(TaskDTO tdto)
    {
        Task task = new Task(tdto);
        taskList.add(task);
    }
    
    /**
     * Method uses Iterator to get the next Task in the Arraylist
     * @return dto
     */
    public TaskDTO getNextTask()
    {
        Task tk;
        if (taskIT.hasNext())
        {
            tk = (Task) taskIT.next();
            TaskDTO tdto = new TaskDTO
                    (tk.getProject(),
                     tk.getTitle(),
                     tk.getDueDate(),
                     tk.getStatus(),
                     tk.getAlert()
                    );
            return tdto;
        }
        return null;
    }
    /**
     * Method uses Iterator to get the previous Task in the ArrayList
     * @return 
     */
    public TaskDTO getPrevTask()
    {
        
        Task tk;
        if (taskIT.hasPrevious())
        {
            tk = taskIT.previous();
            TaskDTO tdto = new TaskDTO
                    (tk.getProject(),
                     tk.getTitle(),
                     tk.getDueDate(),
                     tk.getStatus(),
                     tk.getAlert()
                    );
            return tdto;
        }
        return null;
        
    }
    
    /**
     * this is one time method which executes in the start of the application
     * to read all the records from the file and load the ArrayList.
     */
    public void readFromFile()
    {
        boolean completedTask = false;
        Object fileRecord;
        fileRecord = fileHandler.readFile(completedTask);
        Task tsk;
        while (fileRecord!= null)
        {
            tsk = (Task) fileRecord;
            taskList.add(tsk);
            if (!(validateDate.validateDate(tsk.getDueDate())))
            {
                tsk.setStatus(PossibleStatuses.OVERDUE.toString());
                tsk.setAlert(PossibleAlerts.RED.toString());
            }
            fileRecord = fileHandler.readFile(completedTask);
            
        }
        
        completedTask = true;
        
        Object fileRecordCom = fileHandler.readFile(completedTask);
        CompletedTask complTsk;
        while (fileRecordCom!= null)
        {
            complTsk = (CompletedTask) fileRecordCom;
            taskListCompleted.add(complTsk);
            fileRecordCom = fileHandler.readFile(completedTask);
        }
    }
    /**
     * One time method. Called before closing the application to write all the
     * tasks to the file
     */
    public void writeToFile()
    {
        
        fileHandler.writeFile(taskList);
        
        fileHandler.writeFileCom(taskListCompleted);
    }
   
    /**
     * Method to edit the task.
     * @param Tno - task index which is to be edited.
     * @param attrib that needs to be edited like project, title, status, 
     * due date
     * @param value - value of the changed attribute.
     */
    public void editTask(int Tno, int attrib, String value)
    {
        Task tk = taskList.get(Tno);
        if (tk != null)
        {
            switch(attrib)
            {
                case 1: tk.setProject(value);break;
                case 2: tk.setTitle(value);break;
                case 3: tk.setDueDate(value);
                case 4: tk.setStatus(value);
                        processIfCompleted(Tno,value);
                        break;
                case 5: taskList.remove(tk);
            }
        }
    }
    
    /**
     * places the iterator to the beginning of the ArrayList.
     */
    public void initializeIT()
    {
        taskIT = taskList.listIterator();
        taskCompletedIT = taskListCompleted.listIterator();
    }
    
    /**
     * Method checks if a task has to be marked as completed. 
     * if the status of the task completed it is moved to 
     * completed task list and deleted from 
     * open task list.
     * @param Tno
     * @param value 
     */
    
    public void processIfCompleted(int Tno, String value)
    {
        if (value.toUpperCase().equals(PossibleStatuses.COMPLETED.toString()))
        {
           
            TaskDTO tdto = new TaskDTO
                    (taskList.get(Tno).getProject(),
                     taskList.get(Tno).getTitle(),
                     taskList.get(Tno).getDueDate(),
                     taskList.get(Tno).getStatus(),
                     taskList.get(Tno).getAlert()
                    );
            CompletedTask completedTask = new CompletedTask(tdto);
            taskListCompleted.add(completedTask);
            taskList.remove(Tno);
        }
    }
    /**
     * creates DTO for completed tasks
     * @return completedTaskDTO
     */
    public CompletedTasksDTO getNextCompletedTask()
    {
        CompletedTask completedTask;
        if (taskCompletedIT.hasNext())
        {
            completedTask = taskCompletedIT.next();
            
             CompletedTasksDTO tdto = new CompletedTasksDTO
                    (completedTask.getProject(),
                     completedTask.getTitle(),
                     completedTask.getDueDate(),
                     completedTask.getCompletionDate(),
                     completedTask.getStatus(),
                     completedTask.getAlert()
                    );
            return tdto;
        }
        return null;
    }
    
    public int getTaskListSize(){
        return taskList.size();
    }
    public int getCompletedTaskListSize(){
        return taskListCompleted.size();
    }
}
