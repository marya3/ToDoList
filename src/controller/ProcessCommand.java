/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import View.TaskDTO;
import View.cmdLineInterface;
import model.TaskRepository;
import view.*;
public class ProcessCommand {
    TaskRepository trObj;
    cmdLineInterface cliObj;
    
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
            case 5: System.out.println("user selected 5");break;
            case 6: System.out.println("user selected 6");break;
            case 7: System.out.println("user selected 7");break;
        }     
    }

    public void callCreateTask(TaskDTO tdto)
    {
        trObj.addTask(tdto);
    }

    public TaskDTO showTL()
    {
        return trObj.showNextTask();
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
