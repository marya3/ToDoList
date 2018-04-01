/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.TaskDTO;
import view.CompletedTasksDTO;
import model.TaskRepository;
import java.util.ArrayList;

public class ProcessCommand {
    TaskRepository taskRepositoryObj;
    
    
    public ProcessCommand()
    {
        taskRepositoryObj = new TaskRepository();
        taskRepositoryObj.readFromFile();
        //taskRepositoryObj.readCompletedTaskFile();
        taskRepositoryObj.initializeIT();
    }

    /**
     * calls creates task from model.
     * @param tdto is the TaskDTO to receive the values entered by the user
     */
    public void createTask(TaskDTO tdto)
    {
        taskRepositoryObj.addTask(tdto);
    }

    /**
     * Module to create ArrayList of type TaskDTO from the ArrayList of tasks.
     * @returns ArrayList to view to show
     */
    public ArrayList<TaskDTO> getTaskList()
    {
        taskRepositoryObj.initializeIT();
        ArrayList<TaskDTO> tdtoList = new ArrayList<>();
        TaskDTO objTDTO = taskRepositoryObj.getNextTask();
        while (objTDTO != null)
        {
            tdtoList.add(objTDTO);
            objTDTO = taskRepositoryObj.getNextTask();
        }
        return tdtoList;
    }

    /**
     * 
     * @param tNo - taskNumber which is to be edited.
     * @param taskAttrib - attribute to be changed like project, title, status
     * @param value - new value of the attribute
     */
    public void edit(int tNo, int taskAttrib, String value)
    {
        taskRepositoryObj.editTask(tNo-1,taskAttrib,value);
    }
    
    /**
     * method calls methods to write to file. Invoked only at the time of
     * quitting the application.
     */
    public void quit()
    {
        taskRepositoryObj.writeToFile();
    }
    
     /**
     * Module to create ArrayList of type CompletedTaskDTO from the ArrayList 
     * of tasks completed tasks.
     * @returns ArrayList to view to show
     */
    
    public ArrayList<CompletedTasksDTO> getCompletedTaskList()
    {
        taskRepositoryObj.initializeIT();
        ArrayList<CompletedTasksDTO> tdtoCompletedList = new ArrayList<>();
        CompletedTasksDTO objCompletedTDTO = 
                taskRepositoryObj.getNextCompletedTask();
        while (objCompletedTDTO != null)
        {
            tdtoCompletedList.add(objCompletedTDTO);
            objCompletedTDTO = 
                taskRepositoryObj.getNextCompletedTask();
        }
        return tdtoCompletedList;
    }
    
}
