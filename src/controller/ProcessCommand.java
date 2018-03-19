/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.TaskDTO;
import model.TaskRepository;
import java.util.ArrayList;
public class ProcessCommand {
    TaskRepository trObj;
    
    public ProcessCommand()
    {
        trObj = new TaskRepository();
        trObj.readFromFile();
        trObj.initializeIT();
    }

    public void processCommand(int option, TaskDTO tdto)
    {
        switch (option)
        { 
            case 1: showTL();break;
            case 2: callCreateTask(tdto);break;
            case 3: System.out.println("user selected 3");break;
            case 4: quit();break;
        }     
    }

    public void callCreateTask(TaskDTO tdto)
    {
        trObj.addTask(tdto);
    }

    public ArrayList<TaskDTO> showTL()
    {
        trObj.initializeIT();
        ArrayList<TaskDTO> tdtoList = new ArrayList<>();
        TaskDTO objTDTO = trObj.showNextTask();
        while (objTDTO != null)
        {
            tdtoList.add(objTDTO);
            objTDTO = trObj.showNextTask();
        }
        return tdtoList;
    }

    public void quit()
    {
        trObj.writeToFile();
    }

    public void edit(int tNo, int taskAttrib, String value)
    {
        trObj.editTask(tNo-1,taskAttrib,value);
    }
}
