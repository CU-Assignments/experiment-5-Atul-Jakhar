//Student Class (Student.java):


import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private double gpa;

    public Student(int id, String name, double gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }

    public void displayDetails() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("GPA: " + gpa);
    }
}


//Serialization and Deserialization (SerializeDeserializeStudent.java):



import java.io.*;

public class SerializeDeserializeStudent {
    public static void main(String[] args) {
        String fileName = "student.ser";
        
        // Creating a Student object
        Student student = new Student(101, "John Doe", 3.8);

        // Serialization
        try (FileOutputStream fileOut = new FileOutputStream(fileName);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(student);
            System.out.println("Student object serialized to " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        }

        // Deserialization
        try (FileInputStream fileIn = new FileInputStream(fileName);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("\nDeserialized Student Details:");
            deserializedStudent.displayDetails();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }
}
