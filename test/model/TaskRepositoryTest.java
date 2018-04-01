/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Ignore;
import static org.junit.Assert.*;
import view.CompletedTasksDTO;
import view.TaskDTO;
import java.util.ArrayList;


/**
 *
 * @author tmp-sda-1161
 */
public class TaskRepositoryTest {
    
    TaskRepository instance;
    TaskDTO tdto1, tdto2;
    
    public TaskRepositoryTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ArrayList<Task> testTaskList = new ArrayList<>();
        ArrayList<CompletedTask> testCompletedTaskList = new ArrayList<>();
        //TaskDTO tdto1;
        instance = new TaskRepository();
        tdto1 = new TaskDTO("TestProject", "Test title1","04/10/2018",
                "CREATED", "GREEN");
        tdto2 = new TaskDTO("TestProject", "Test title2","04/04/2018",
                "CREATED", "GREEN");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addTask method, of class TaskRepository.
     */
    @Test
    public void testAddTask() {
        System.out.println("addTask");
        
        //TaskRepository instance = new TaskRepository();
        
        //TaskRepository instance = new TaskRepository();
        instance.addTask(tdto1);
        assertEquals(1, instance.getTaskListSize());
    }

    /**
     * Test of editTask method, of class TaskRepository.
     */
    
    @Test
    public void testEditStatusInprogress(){
        instance.addTask(tdto1);
        instance.initializeIT();
        int Tno = 0;
        int attrib = 4;
        String value = "INPROGRESS";
        instance.editTask(Tno, attrib, value);

        assertEquals("INPROGRESS",instance.getNextTask().getStatusDTO());
        
    }
    
    @Test
    public void testEditTaskComplete() {
        System.out.println("editTaskComplete");
        int Tno = 1;
        int attrib = 4;
        instance.addTask(tdto1);
        instance.addTask(tdto2);
        assertEquals(2,instance.getTaskListSize());
        String value = "COMPLETED";
        
        instance.editTask(Tno, attrib, value);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1, instance.getCompletedTaskListSize());
        assertEquals(1,instance.getTaskListSize());
    }
    
    @Test
    public void testEditRemoveTask(){
        int Tno = 1;
        int attrib = 5;
        String value = "Delete";
        instance.addTask(tdto1);
        instance.addTask(tdto2);
        instance.editTask(Tno, attrib, value);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1,instance.getTaskListSize());
    }
}
