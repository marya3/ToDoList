import java.util.*;
import java.util.Scanner;

public class ToDoDriverClass
{

	public static void main(String[] args)
	{
		UserInterface UI = new UserInterface();
		String 
		UI.printOptions();
		UI.getUserInput();

	}


}

class Project
{
	private String projectName;

	public Project(String name)
	{
		projectName = name;
	}
	public String getProjectName()
	{
		return projectName;
	}
}

class Task
{
	
}

class UserInterface
{
	Scanner scanner = new Scanner(System.in);
	String userInput = "4";
	public void printOptions()
	{
		System.out.println(">> Welcome to ToDoly");
		System.out.println(">> You have X tasks todo and Y tasks are done!");
		System.out.println(">> Pick an option: ");
		System.out.println(">> (1) Show Task List (by date or project)");
		System.out.println(">> (2) Add New Task");
		System.out.println(">> (3) Edit Task (update, mark as done, remove)");
		System.out.println(">> (4) Save and Quit");
		
	}
	public String getUserInput()
	{
		userInput = scanner.next();
		System.out.println("user entered " + userInput);
		return userInput;	
	}
		
	
}
