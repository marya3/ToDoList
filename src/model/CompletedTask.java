/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import view.TaskDTO;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CompletedTask extends Task implements Serializable {
    
    String dateOfCompletion;
    /**
     * 
     * @param tdto task DTO for creating the object of CompletedTask Type
     * 
     */
    public CompletedTask(TaskDTO tdto) {
        super(tdto);
        setCompletionDate();
        setAlert();
        
    }
    
    public String getCompletionDate()
    {
      return dateOfCompletion;
    }
    
    /**
     * method to set dateOfCompletion as today the day it is marked completed.
     */
    private void setCompletionDate()
    {
      DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
      Date today = new Date();        
      dateOfCompletion = df.format(today);
    }
    
    /**
     * method to set the Alert as MISSED if the completion 
     * date is after the dueDate.
     * 
     */
    private void setAlert()
    {
        Date dueDt, compDt;
        try {
            
            dueDt = new SimpleDateFormat("MM/dd/yyyy").parse(getDueDate());
            compDt = new SimpleDateFormat("MM/dd/yyyy").parse(dateOfCompletion);
        
            if (compDt.after(dueDt))
            {
                super.setAlert("MISSED");
            }
            else
            {super.setAlert("MET");}
        }
        catch(ParseException e){
            setAlert("Alert not set");
        }
    }
}
