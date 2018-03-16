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
//import java.util.Date;
import View.TaskDTO;
import dbhandler.FileHandler;
public class TaskRepository {
    FileHandler fh;    
    ArrayList<Task> taskList;
    ListIterator<Task> taskIT;
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
    public TaskDTO showNextTask()
    {
        Task tk;
        if (taskIT.hasNext())
        {
            tk = (Task) taskIT.next();
            TaskDTO tdto = new TaskDTO
                    (tk.getProject(),
                     tk.getTitle(),
                     tk.getDueDate(),
                     tk.getCompletionDate(),
                     tk.getStatus(),
                     tk.getAlert()
                    );
            return tdto;
        }
        return null;
    }
    public TaskDTO showPrevTask()
    {
        
        Task tk;
        if (taskIT.hasPrevious())
        {
            tk = (Task) taskIT.previous();
            TaskDTO tdto = new TaskDTO
                    (tk.getProject(),
                     tk.getTitle(),
                     tk.getDueDate(),
                     tk.getCompletionDate(),
                     tk.getStatus(),
                     tk.getAlert()
                    );
            return tdto;
        }
        return null;
        
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
            System.out.print("inwritetofile");
            fh.writeFile(taskList);
        
    }
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
                case 4: tk.setStatus(value);break;
                
            }
        }
    }
    public void initializeIT()
    {
        taskIT = taskList.listIterator();
    }
}
