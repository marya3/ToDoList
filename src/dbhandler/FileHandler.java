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
import java.io.FileReader;
import java.io.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.ArrayList;
public class FileHandler {
    ObjectInputStream is;
    ObjectOutputStream os;
    public FileHandler()
            
    {
       try
        {is = new ObjectInputStream(new FileInputStream("Task.txt"));
        }
       catch(Exception e)
       {System.out.println("File not found" + e);}
      
       
    }  

    public Object readFile()
    {
       try {
           is.readObject();
           System.out.println("reading file" + is.toString()); 
           return is;
            }
       catch(Exception e){
           System.out.println("reading failed" + e);
           return null;
       }
       
    }
    
    public void writeFile(Object s)
    {
       try {
           os = new ObjectOutputStream(new FileOutputStream("Task.txt"));
           os.writeObject(s);
           System.out.println("writing to file");
        }
        catch(Exception e)
        {
            System.out.println("writing failed");
        }
    }   
}