# COMP 3005 Assignment 3
### March 15, 2024  - Winter 2024

## Ensure You Have the Following Installed
- IntelliJ - IDE used to write the code
- javac (java compiler)

## Before Running the Program
1. Ensure that url is set with the correct port number and postgres database name on line 5. If the database is on the same machine as the one used to run the program, it should look something like 
	 ```String url = "jdbc:postgresql://localhost:{INSERT_PORT_NUMBER}/{INSERT_DATABASE_NAME}";```
	 
2. Ensure that the correct username to the associated database is set on line 6. It should look something like 
	```String user = "{INSERT_USERNAME}";```
	
3. Ensure that the correct password to the associated database is set on line 7. It should look something like 
```String password = "{INSERT_PASSWORD}";```

4. Create a new table named `students` in your postgreSQL database by running the following command
```
-- Create students Table
CREATE TABLE Students (
	student_id SERIAL,
	first_name VARCHAR(255) NOT NULL,
	last_name VARCHAR(255) NOT NULL,
   		email VARCHAR(255) NOT NULL UNIQUE,
	enrollment_date DATE,
	PRIMARY KEY (student_id)
);
```
5. Populate the `students` database with the following commands:
```
INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES
	('John', 'Doe', 'john.doe@example.com', '2023-09-01'),
	('Jane', 'Smith', 'jane.smith@example.com', '2023-09-01'),
	('Jim', 'Beam', 'jim.beam@example.com', '2023-09-02');
```
6. Ensure that you include one of the following the commands you want to run to line 18:
	- To get all the students in the database, insert the following command to line 18: 
		```getAllStudents(connection);```
	- To get add a student to the database, insert the following command to line 18: 
		```addStudent(connection, "{INSERT_FIRST_NAME}", "{INSERT_LAST_NAME}", "{INSERT_EMAIL}", "{INSERT_DATE}");```
	- To update a student's email, insert the following command to line 18: 
		```updateStudentEmail(connection, {INSERT_STUDENT_ID}, "{INSERT_NEW_EMAIL}");```
	- To delete a student using their student id, insert the following command to line 18: 
		```deleteStudent(connection, {INSERT_STUDENT_ID});```

## To Run the Program
1. `Git clone` and open the project in IntelliJ
2. Ensure you have pgAdmin running and ensure you have followed the steps under **Before Running the Program**
3. Press the green arrow beside the line numbers for public static void main or the green arrow on the top right corner
	>**Note:** if there is a `version 5 not supported` error, go to `Files` > `Settings` > `Build, Execution, Deployment` > `Java Compiler` and change the `Target bytecode version` (on the right side) is set to the latest version.
4. The results should appear in the console log under the "Run" tab
5. Check if the results are the same in pgAdmin (or any other postgreSQL user interface)

## Video Link (YouTube)
Here is the video: https://youtu.be/8IAWXdtRnNw
