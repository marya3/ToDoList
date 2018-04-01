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
public class CompletedTasksDTO extends TaskDTO{
    
    String dateOfCompletion;

    /**
     * Constructor
     * @param project
     * @param title
     * @param dueDate
     * @param dateOfCompletion
     * @param status
     * @param alert
     */
    public CompletedTasksDTO(String project, String title, String dueDate,
                             String dateOfCompletion, String status, 
                             String alert) 
    {
        super(project, title, dueDate, status, alert);
        this.dateOfCompletion = dateOfCompletion;
    }
    /**
     * getter method to return the date the task was completed
     * @return 
     */
    public String getDateOfCompletionDTO()
    {
        return dateOfCompletion;
    }
}
