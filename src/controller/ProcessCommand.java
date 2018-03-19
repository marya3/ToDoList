/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import view.TaskDTO;
import model.TaskRepository;
import java.util.ArrayList;

public class ProcessCommand {
    TaskRepository taskRepositoryObj;
    
    
    public ProcessCommand()
    {
        taskRepositoryObj = new TaskRepository();
        taskRepositoryObj.readFromFile();
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
     * Module to create arraylist of type TaskDTO from the arrayslist of tasks.
     * @return Arraylist to view to show
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

    public void edit(int tNo, int taskAttrib, String value)
    {
        taskRepositoryObj.editTask(tNo-1,taskAttrib,value);
    }
    
    
    public void quit()
    {
        taskRepositoryObj.writeToFile();
    }
}
