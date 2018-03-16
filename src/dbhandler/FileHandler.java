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
    public FileHandler()
    {
       try
        {is = new ObjectInputStream(new FileInputStream("Task.txt"));
        }
       catch(IOException e)
       {
           System.out.println("cannot open file");
       }
    }  
    public Task readFile()
    {
       try {
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