# Artemis User Guide

![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://i.postimg.cc/9FRwQGpp/Screenshot-2026-03-06-014411.png)

Artemis is a CLI-based task manager that helps you to keep track of your tasks, deadlines, events, and todos efficiently. It supports fast command-line interaction while automatically saving all changes to locally on your device.

## Features
***
### Viewing Help
Command: `menu`  
Displays the full user guide and command list
***
### Adding Todo Tasks

Use this feature to add a simple task without a date

Command format:  
`todo <task description>`

Example:  
`todo read book`

Expected output:
```
    Got it. I've added this task: 
      [T][ ] read book
    Now you have 9 tasks in the list.
```
***
### Adding Deadlines

Use this feature to add a task that has a specific due date.

Command format:  
`deadline <task description> /by date`


Example:  
`deadline return book /by June 6`

Expected output:  
```
    Got it. I've added this task: 
      [D][ ] return book (by: June 6)
    Now you have 8 tasks in the list. 
 ```
***
### Adding Events

Use this feature to add a task that occurs within a time frame.

Command format:  
`event <task description> /from <start time> /to <end time>`

Example:
```
event team meeting /from 2pm /to 4pm
```
Expected output:
```
    Got it. I've added this task: 
      [E][ ] team meeting (from: 2pm to: 4pm)
    Now you have 10 tasks in the list. 
```
***
### Marking and Unmarking Tasks

Use these features to update the completion status of a task.

Command format:  

Mark a task as done  
`mark <task number>`

Mark a task as not done  
`unmark <task number>`

Example:
```
mark 1
unmark 2
```
Expected output:
```
     Nice! I've marked this task as done:
       [T][X] read book
     OK, I've marked this task as not done yet:
       [T][ ] return book
```
***
### Deleting Tasks

Remove tasks you no longer need.

Command format:
`delete <task number>`

Example:  
```
delete 3
```
Expected output:
```
    Noted. I've removed this task: 
      [D][ ] watch movie (by: today)
    Now you have 9 tasks in the list. 
```
***
### Finding Tasks

Search for the tasks containing specific keywords in their description.

Command format:  
`find <keyword>`

Example:
```
find book
```
Expected output:
```
    Here are the tasks in your list:
    1. [T][X] read book
    2. [D][X] return book (by: June 6th)
```
***
### List all Tasks

Command format:  
`list`

Expected output:
```
    Here are the tasks in your list:
    1. [T][X] read book
    2. [D][X] return book (by: June 6th)
```
***
### Exiting the Program

Command format:  
`bye`

Outcome:
All changes are automatically saved.
***


## Command Reference

| Action                  | Command format                                                                 |
|-------------------------|-------------------------------------------------------------------------------|
| Add Deadline             | `deadline <task description> /by <date>`                                      |
| Add ToDo                 | `todo <task description>`                                                     |
| Add Event                | `event <task description> /from <start time> /to <end time>`                 |
| Mark Task Done           | `mark <task number>`                                                          |
| Mark Task Not Done       | `unmark <task number>`                                                        |
| Delete Task              | `delete <task number>`                                                        |
| Find Task                | `find <keyword>`                                                              |
| List All Tasks           | `list`                                                                        |
| Exit Program             | `bye`                                                                         |

---