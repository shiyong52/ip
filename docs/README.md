# Artemis User Guide

// Product screenshot goes here

Artemis is a CLI-based task manager that helps you to keep track of your tasks, deadlines, events, and todos efficiently. It supports fast command-line interaction while automatically saving all changes to locally on your device.

## Adding Deadlines

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

## Adding ToDo Tasks

Use this feature to add a simple task without a date

Command format:
`todo <task description>`

Example
`todo read book`

Expected output:
```
    Got it. I've added this task: 
      [T][ ] read book
    Now you have 9 tasks in the list.
```

## Adding Events

Use
// Feature details