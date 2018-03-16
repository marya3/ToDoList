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
      project = tdto.getProjectDTO();
      title    = tdto.getTitleDTO();
      duedate = tdto.getDueDateDTO();
      completiondate = tdto.getCompletionDateDTO();
      status = tdto.getStatusDTO();
      alert = tdto.getAlertDTO();
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
  public void setProject(String project)
  {
      this.project = project;
  }
  public void setTitle(String title)
  {
      this.title = title;
  }
  public void setStatus(String status)
  {
      this.status = status;
  }
  
  public void setDueDate(String dueDate)
  {
      this.duedate = dueDate;
  }
  public void setCompletionDate(String completionDate)
  {
      this.completiondate=completionDate;
  }

}

