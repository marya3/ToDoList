/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author tmp-sda-1161
 */
import View.TaskDTO;
import model.TaskRepository;
public class ProcessCommand {
    TaskRepository obj;
    public ProcessCommand()
    {
        obj = new TaskRepository();
        obj.readFromFile();
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
        obj.addTask(tdto);
    }
    public void showTL()
    {
        obj.showTaskList();
    }
    public void quit()
    {
        obj.writeToFile();
    }
    
}
