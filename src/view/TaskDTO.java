/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
/**
 *
 * @author tmp-sda-1161
 */
public class TaskDTO {

    private String project;
    private String title;
    private String date1;
    private String date2;
    private String status;
    private String alert;
    
    public TaskDTO(String project,String title, String date1, String date2,
            String status, String alert)
    {
        this.project = project;
        this.title = title;
        this.date1 = date1;
        this.date2 = date2;
        this.status = status;
        this.alert = alert;
    }
    
  public String getProjectDTO()
  {
      return project;
  }
  public String getTitleDTO()
  {
      return title;
  }
  public String getStatusDTO()
  {
      return status;
  }
  public String getAlertDTO()
  {
      return alert;
  }
  public String getDueDateDTO()
  {
      return date1;
  }
  public String getCompletionDateDTO()
  {
      return date2;
  }

}
