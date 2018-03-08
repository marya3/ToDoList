/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.util.Date;

/**
 *
 * @author tmp-sda-1161
 */
public class TaskDTO {

    public String project;
    public String title;
    public String date1;
    public String date2;
    public String status;
    public String alert;
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
}
