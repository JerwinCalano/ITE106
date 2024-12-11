Payroll System

This is a simple Java-based Payroll System built using the Swing library for GUI. The system allows users to manage employee records, calculate payroll, and save/load records to/from a file.

Features

Add Employee

  • Add new employees with their details, including hourly rate and hours worked.
Calculate Pay

  •Compute gross and net pay for a specific employee based on their ID.
Save Records

  •Save all employee records to a payroll.txt file.
Display Records

  •Display all saved employee records in a table.
Load Existing Records

  •Automatically load saved records from payroll.txt when the application starts.

Running the Application

 1.Clone or download the repository.

 2.Open the project in your preferred IDE.

 3.Compile and run the PayrollSystem class.

 4.Use the application interface to manage payroll records.

How to Use:

 1.Add an Employee

  • Fill in the fields for Employee ID, Name, Hourly Rate, and Hours Worked.
  • Click the Add Employee button.
  • The employee will be added to the table, and their gross/net pay will be calculated.

 2.Calculate Pay

  • Enter the Employee ID in the "Employee ID" field.

  • Click the Calculate Pay button.

  • The gross and net pay for the employee will be displayed in a popup.

 3.Save Records
  • Click the Save Record button to save all records to payroll.txt.

 4.Display Records
  • Click the Display Records button to load and display all records in the table.

 5.Load Existing Records
  • Existing records from payroll.txt will automatically load when the application starts.

File Structure

payroll.txt: Stores the saved employee payroll records in a CSV format. This file is created automatically when you save records.
