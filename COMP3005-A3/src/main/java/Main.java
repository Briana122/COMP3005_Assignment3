import java.sql.*;

public class Main {
        public static void main(String[] args){
        // information to establish connection with postgreSQL database
        String url = "jdbc:postgresql://localhost:5432/Assignment3";
        String user = "postgres";
        String password = "password";

        // try to establish a connection to the database with the information above
        try{
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            // connection established
            if(connection != null){
                System.out.println("Connected to the database");

                // insert the queries you want to run here

                // To get all students in the table
//                getAllStudents(connection);

                // To add new student to the database
//                addStudent(connection, "Lily", "Tee",
//                        "lilly.tee@example.com", "2023-09-30");
//                getAllStudents(connection);

                // To update student with student_id with new_email
//                updateStudentEmail(connection, 4,
//                        "lily.tee@example.com");
//                getAllStudents(connection);

                // To delete student with student_id
//                deleteStudent(connection, 4);
//                getAllStudents(connection);

                connection.close();
            }
            // connection failed to establish
            else{
                System.out.println("Failed to connect to the database");
            }
        // catch any exceptions that occur during the execution
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void getAllStudents(Connection connection){
        // try block to catch any errors or exceptions that may occur while preparing or executing the query
        try{
            // create query get all the entries in the students table
            PreparedStatement pstmt = connection.prepareStatement("SELECT * FROM students");
            // execute the query
            ResultSet resultSet = pstmt.executeQuery();

            // print out the data returned by the query
            System.out.println("Getting all students");
            System.out.println("Student ID \t\t First Name \t\t Last Name \t\t Email \t\t\t\t\t\t Enrollment Date");
            while(resultSet.next()){
                System.out.println(resultSet.getString("student_id") + "\t\t\t\t " +
                        resultSet.getString("first_name") + "\t\t\t\t " +
                        resultSet.getString("last_name") + "\t\t\t " +
                        resultSet.getString("email") + "\t\t " +
                        resultSet.getString("enrollment_date"));
            }
        }
        // catch any exceptions
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void addStudent(Connection connection, String first_name, String last_name, String email, String enrollment_date){
        // try block to catch any errors or exceptions that may occur while preparing or executing the query
        try{
            // create query to insert a new row to the table
            PreparedStatement pstmt = connection.prepareStatement("INSERT INTO students (first_name, last_name, email, enrollment_date) VALUES(?, ?, ?, ?)");

            // populate query with the provided student information
            pstmt.setString(1, first_name);
            pstmt.setString(2, last_name);
            pstmt.setString(3, email);
            // parsing enrollment_date to be of the correct Date type before sending the query
            Date enrollmentDate = Date.valueOf(enrollment_date);
            pstmt.setDate(4, enrollmentDate);

            // execute the query to add new student and print success message
            if(pstmt.executeUpdate() > 0){
                System.out.println("Added Student " + first_name + " " + last_name);
            }
            else{
                System.out.println("Unable to add Student. Please try again");
            }
        }
        // catch any exceptions
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void updateStudentEmail(Connection connection, int student_id, String new_email){
        // try block to catch any errors or exceptions that may occur while preparing or executing the query
        try{
            // create query to update the entry who has student id = student_id with email = new_email
            PreparedStatement pstmt = connection.prepareStatement("UPDATE students SET email = ? WHERE student_id = ?");

            // populate query with the provided student_id and new_email
            pstmt.setString(1, new_email);
            pstmt.setInt(2, student_id);

            // execute the query to update entry and print success message
            if(pstmt.executeUpdate() > 0){
                System.out.println("Update Student with new email: " + new_email);
            }
            else{
                System.out.println("Unable to update Student. Please try again");
            }
        }
        // catch any exceptions
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void deleteStudent(Connection connection, int student_id){
        // try block to catch any errors or exceptions that may occur while preparing or executing the query
        try{
            // create query to delete student entry with student id = student_id
            PreparedStatement pstmt = connection.prepareStatement("DELETE FROM students WHERE student_id = ?");

            // populate query with the given student_id
            pstmt.setInt(1, student_id);

            // execute the query to delete entry and print success message
            if(pstmt.executeUpdate() > 0){
                System.out.println("Successful deletion");
            }
            else{
                System.out.println("Unable to delete Student. Please try again");
            }
        }
        // catch any exceptions
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
