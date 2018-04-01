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
import view.*;

import controller.ProcessCommand;

public class ToDoList {

    /**
     * main method to start the application.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProcessCommand processCommand = new ProcessCommand();
        CmdLineInterface cmdlI = new CmdLineInterface(processCommand);
        cmdlI.startApplication();
        
    }
    
}
