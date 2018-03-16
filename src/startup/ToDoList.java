/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package startup;

/**
 *
 * @author tmp-sda-1161
 */
import View.*;
public class ToDoList {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        cmdLineInterface cmdlI = new cmdLineInterface();
        //cmdlI.showMainMenu();
        cmdlI.processUserInput();
        
//        int choice = cmdlI.getUserInput();
//        while (choice != 4)
//        {
//            cmdlI.showMainMenu();
//            choice = 
//        }
        
    }
    
}
