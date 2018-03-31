# ToDoList
An Application to maintain ToDo list for a User.
User can _create_ task for ```projects with title, due dates and maintain the status```.
Tasks can be marked _complete_ when the user has completed one. The system will _update_ the completion date when the task is marked as completed. Tasks can also be _updated_ with the new values of _project, title, status and due Date_.
Application can show the list of Tasks as per the project and due dates and will alert the user for any approaching dead lines with the field alert populated as RED.

## User Manual

### Installation
- Download the code from github resposity by clicking [here](https://github.com/marya3/ToDoList).
- Compile the code using ```javac```.
- Run the application by using ```java``` _application name_

## Instructions

When the application is launched a user can navigate to any of the following options.

### Main menu of the application
- (1) Show Task List
- (2) Add New Task
- (3) Edit Task (update, mark as done, remove)
- (4) Save and Quit
- (5) To Show Statistics

### Show Task List Menu
- (1) To Show entire List
  - Lists all the open tasks.
- (2) To View one at a time
  - User can browse over the list(can go to next or prev).
- (3) To View sorted by Date
  - User can view the open tasks list ordered by Date in ascending order.
- (4) To Filter by Project
  - User can view the open tasks belonging to a project.
- (5) To Show list of Completed Task
  - User can view all the completed task. 

### Add New Task 
- User can add a new task to the List. To create a new task following information is required. 
  - Project - User is prompted to enter.
  - Title - User is prompted to enter.
  - Due Date - User is prompted to enter. User can enter a valid date in mm/dd/yyyy format. Also, a date in the past is not a             valid date.
  - Status - It is set to CREATED automatically.
  - Alert - It is set as per the below rules.
    - GREEN - If the due date is more 2 days from the creation date.
    - YELLOW - If the due date is less than 2 days and more than 1 day from the date of creation.
    - RED - If the due date is same as the creation date.
    
### Edit Task
- When the User chooses to edit a task a whole list of open tasks is presented to the user. 
- User can select the task number or 0 to exit.
- After user enters the task number the user can choose one from the below.
  - Update Project
    - User can select option 1 to change the Project. User is prompted to enter the new value of the project.
  - Update Title
    - User can select option 2 to change the Title. User is prompted to enter the new value.  
  - Update Due Date
    - User can select option 3 to change the Due Date. User is prompted to enter the new value.  
  - Update Status
    - User can select option 4 to change the Status. User is prompted to Select the new value from the displayed list. A user can mark a Task as COMPLETED. It is removed from the list of open tasks.
  - Remove
    - User can select option 5 to remove the task.
    
### Save and Quit
- User can select to Quit the application. Current state of Open and Completed tasks are saved to files.

### Show Statistics
- User can select to view the statistics. This option displays.
  - Number of Open Tasks
  - Number of Completed Tasks.
  - Number of Tasks closed before Due date.
  - Number of Tasks closed after Due date.
  - Percent of tasks closed before Due Date. 
  - Percent of tasks closed after Due Date. 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
