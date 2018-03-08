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
import View.TaskDTO;
import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable
{
  private String project;
  private String title;
  private String duedate;
  private String completiondate;
  private String status;
  private String alert;
  
  public Task(TaskDTO tdto)
  {
      project = tdto.project;
      title    = tdto.title;
      duedate = tdto.date1;
      completiondate = tdto.date2;
      status = tdto.status;
      alert = tdto.alert;
  }
  public String getProject()
  {
      return project;
  }
  public String getTitle()
  {
      return title;
  }
  public String getStatus()
  {
      return status;
  }
  public String getAlert()
  {
      return alert;
  }
  public String getDueDate()
  {
      return duedate.toString();
  }
  public String getCompletionDate()
  {
      return completiondate.toString();
  }
}

