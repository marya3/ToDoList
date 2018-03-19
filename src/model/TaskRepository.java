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
import dbhandler.FileHandler;

public class TaskRepository {
    FileHandler fh;    
    ArrayList<Task> taskList;
    ListIterator<Task> taskIT;

    public TaskRepository()
    {
        fh = new FileHandler();
        taskList = new ArrayList<>();
    
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
                     tk.getCompletionDate(),
                     tk.getStatus(),
                     tk.getAlert()
                    );
            return tdto;
        }
        return null;
    }
    /**
     * Method uses Iterator to get the previous Task in the Arraylist
     * @return 
     */
    public TaskDTO getPrevTask()
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
    
    /**
     * this is one time method which executes in the start of the application
     * to read all the records from the file and load the Arraylist.
     */
    public void readFromFile()
    {
        
        Object o;
        o = fh.readFile();
        while (o!= null)
        {
            taskList.add((Task)o);
            o = fh.readFile();
        }
        
    }
    /**
     * One time method. Called before closing the application to write all the
     * tasks to the file
     */
    public void writeToFile()
    {
        fh.writeFile(taskList);
    }
    
    /**
     * Method to edit the task.
     * @param Tno - task index which is to be edited.
     * @param attrib that needs to be edited like project, title, status, duedate
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
                case 4: tk.setStatus(value);break;
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
    }
}
