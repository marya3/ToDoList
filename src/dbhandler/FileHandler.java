/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbhandler;

/**
 *
 * @author tmp-sda-1161
 */
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import model.Task;
import model.CompletedTask;

public class FileHandler {
    ObjectInputStream isOpenTask;
    ObjectOutputStream osOpenTask;
    
    ObjectInputStream isCompletedTask;
    ObjectOutputStream osCompletedTask;
    /**
     * Constructor to create the Objectinput Stream to read object file.
     */
    public FileHandler()
    {
       try
        {
            isOpenTask = new ObjectInputStream(new FileInputStream("Task.txt"));
            isCompletedTask = new ObjectInputStream(new FileInputStream("CompletedTask.txt"));
            
        }
       catch(IOException e)
       {
           //System.out.println("cannot open file");
       }
    }  
    
    /**
     * Method to loop over the records in the file.
     * @param completedTask is set to true when reading completedTask file.
     * @return individual Task to Model to create the array list
     */
    public Object readFile(boolean completedTask)
    {
       try{
           if (completedTask) 
           {    return isCompletedTask.readObject();}
           else {
                return isOpenTask.readObject();
           }
            //return tsk;
          }
       catch(EOFException e)
       {
           return null;
       }
       catch(Exception e)
       {
           return null;
       }
          
    }
    
    /**
     * 
     * method to write to the file.
     * @param tl is the ArrayList to be written to the file
     */
    public void writeFileCom(List<CompletedTask> tl)
    {
    
        try {
            osOpenTask = new ObjectOutputStream(new FileOutputStream("CompletedTask.txt"));
            for (CompletedTask t: tl)
            {
                 osOpenTask.writeObject(t);
            }
         }
         catch(Exception e)
         {
             System.out.println("writing failed");
         }
    }
    
    public void writeFile(List<Task> tl)
    {
      
       try {
           osOpenTask = new ObjectOutputStream(new FileOutputStream("Task.txt"));
           for (Task t: tl)
           {
                osOpenTask.writeObject(t);
           }
        }
        catch(Exception e)
        {
            System.out.println("writing failed");
        }
    }
}