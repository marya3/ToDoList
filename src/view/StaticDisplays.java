/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

public class StaticDisplays {
    /**
     * method which is used for showing the options to the user
     */
    public void showMainMenu()
    {
        
        System.out.println("");
        System.out.println("");
        System.out.println("*******************************");
        System.out.println(">> Welcome to ToDoly Main Menu");
        System.out.println("*******************************");
        System.out.println(">> Pick an option: ");
        System.out.println(">> (1) Show Task List ");
        System.out.println(">> (2) Add New Task ");
        System.out.println(">> (3) Edit Task (update, mark as done, remove) ");
        System.out.println(">> (4) Save and Quit ");
        System.out.println(">> (5) To Show Statistics");
        System.out.println("*******************************");
        System.out.print(">> ");
    }
    /**
     * method to display option for viewing the tasks
     */
    public void showReportingMenu(){
        System.out.println("");
        System.out.println("");
        System.out.println("**********************************");
        System.out.println(">> Welcome to ToDoly Display Menu");
        System.out.println("**********************************");
        
        System.out.println(">> (1) To Show entire List");
        System.out.println(">> (2) To View one at a time");
        System.out.println(">> (3) To View sorted by Date");
        System.out.println(">> (4) To Filter by Project");
        System.out.println(">> (5) To Show list of Completed Task");
    }
            
    /**
     * method to display option available for editing tasks
     */
    public void showEditMenu()
    {
        System.out.println("");
        System.out.println("");
        System.out.println("*******************************");
        System.out.println(">> Welcome to ToDoly Edit Menu");
        System.out.println("*******************************");
        System.out.println(">> (1) To update Project");
        System.out.println(">> (2) To update Title");
        System.out.println(">> (3) To update Duedate");
        System.out.println(">> (4) To update Status");
        System.out.println(">> (5) to remove the task");
    }
    
    /**
     * method to display heading for open tasks
     */
    public void showReportHeading()
    {
        printRow("Task Number","Project","Title","DueDate","Status","Alert");
        printRow("-----------","-------","-----","-------","------","-----");
    }
    
    /**
     * method to display heading for completed tasks
     */
    public void showReportHeadingForCompletedTask()
    {
        printRow("Task Number","Project","Title","DueDate","Completion date","Alert");
        printRow("-----------","-------","-----","-------","---------------","-----");
    }
    
    
    /**
     * method to display heading for statistics
     */
    public void showReportHeadingForStat()
    {
        printRow("Open Tasks","Completed Tasks","Met Deadline","Missed Deadline","Success rate","Missed Rate");
        printRow("----------","---------------","------------","---------------","------------","-----------");
    }
    
     /**
     * 
     * method to display the tasks information spaced equally
     * @param c0
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     * @param c5 
     */
    public void printRow(String c0, String c1, 
                          String c2, String c3, String c4, String c5)
    {
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s%n", 
                          c0, c1, c2,c3, c4, c5);
    }   
}
