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
import java.io.*;
import model.Task;

public class FileHandler {
    ObjectInputStream is;
    ObjectOutputStream os;
    /**
     * Constructor to create the Objectinput Stream to read object file.
     */
    public FileHandler()
    {
       try
        {
            is = new ObjectInputStream(new FileInputStream("Task.txt"));
        }
       catch(IOException e)
       {
           //System.out.println("cannot open file");
       }
    }  
    
    /**
     * Module to loop over the records in the file.
     * @return individual Task to the Model to create the array list
     */
    public Task readFile()
    {
       try{
            Task tsk = (Task) is.readObject();
            return tsk;
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
     * module to write the file.
     * @param Arraylist of tasks.
     */
    public void writeFile(ArrayList<Task> tl)
    {
       try {
           os = new ObjectOutputStream(new FileOutputStream("Task.txt"));
           for (Task t: tl)
           {
                os.writeObject(t);
           }
        }
        catch(Exception e)
        {
            System.out.println("writing failed");
        }
    }   
}