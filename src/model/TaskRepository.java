/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author tmp-sda-1161
 */
import java.util.ArrayList;
import java.util.Date;
import View.TaskDTO;
import dbhandler.FileHandler;
public class TaskRepository {
    FileHandler fh;    
    ArrayList<Task> taskList;
    //Task task = new Task(String title, Date date1,Date date2,
    //      String status,String alert);
    public TaskRepository()
    {
        fh = new FileHandler();
        taskList = new ArrayList<>();
    }
    public void addTask(TaskDTO tdto)
    {
        Task task = new Task(tdto);
        taskList.add(task);
        
    }
    public void showTaskList()
    {
        for(Task t:taskList)
        {
            System.out.println(t.getProject());
            System.out.println(t.getTitle());
            System.out.println(t.getDueDate());
            System.out.println(t.getStatus());
            System.out.println(t.getAlert());
        }
    }
    
    public void readFromFile()
    {
        
        Object o;
        o = fh.readFile();
        if (o == null)
        {
            System.out.println("null");
        }
        else
        {
            while (o!= null)
            {
                taskList.add((Task)o);
                o = fh.readFile();
            }
        }
    }
    public void writeToFile()
    {
        for (Task t: taskList)
        {
            System.out.print("inwritetofile");
            fh.writeFile(t);
            
        }
        
    }
            
}
