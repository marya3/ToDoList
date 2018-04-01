/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

public class TaskDTO {

    private String project;
    private String title;
    private String dueDate;
    private String status;
    private String alert;
    
    public TaskDTO(String project,String title, String date, 
            String status, String alert)
    {
        this.project = project;
        this.title = title;
        this.dueDate = date;
        
        this.status = status;
        this.alert = alert;
    }
  /**
   * getter method
   * @return project
   */
  public String getProjectDTO()
  {
      return project;
  }
  /**
   * getter method
   * @return title
   */
   
  public String getTitleDTO()
  {
      return title;
  }
  /**
   * getter method
   * @return status
   */
  public String getStatusDTO()
  {
      return status;
  }
  /**
   * getter method
   * @return alert
   */
  public String getAlertDTO()
  {
      return alert;
  }
  
  /**
   * getter method
   * @return due date
   */
  
  public String getDueDateDTO()
  {
      return dueDate;
  }


}
