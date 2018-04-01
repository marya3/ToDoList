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
import view.TaskDTO;
import java.io.Serializable;

public class Task implements Serializable
{
  private String project;
  private String title;
  protected String duedate;
  //private String completiondate;
  private String status;
  private String alert;
  
  public Task(TaskDTO tdto)
  {
      project = tdto.getProjectDTO();
      title    = tdto.getTitleDTO();
      duedate = tdto.getDueDateDTO();
      //completiondate = tdto.getCompletionDateDTO();
      status = tdto.getStatusDTO();
      alert = tdto.getAlertDTO();
  }
  
  /**
   * Getter method
   * @return project
   */
  
  public String getProject()
  {
      return project;
  }
  
  
  /**
   * Getter method
   * @return title
   */
  
  public String getTitle()
  {
      return title;
  }
  
  /**
   * Getter method
   * @return status
   */
  
  public String getStatus()
  {
      return status;
  }
  
  /**
   * Getter method
   * @return alert
   */
  
  public String getAlert()
  {
      return alert;
  }
  
  /**
   * Getter method
   * @return dueDate
   */
  
  public String getDueDate()
  {
      return duedate;
  }
  
  /**
   * Setter to update value of project
   * @param project 
   */
  public void setProject(String project)
  {
      this.project = project;
  }
  
  /**
   * Setter to update value of title
   * @param title 
   */
  
  public void setTitle(String title)
  {
      this.title = title;
  }
  
  /**
   * Setter to update value of status
   * @param status 
   */
  public void setStatus(String status)
  {
      this.status = status;
  }
  
  /**
   * Setter to update value of dueDate
   * @param dueDate 
   */
  public void setDueDate(String dueDate)
  {
      this.duedate = dueDate;
  }
  
  /**
   * Setter to update value of alert
   * @param alert 
   */
  public void setAlert(String alert)
  {
      this.alert = alert;
  }
  
 
          
}

