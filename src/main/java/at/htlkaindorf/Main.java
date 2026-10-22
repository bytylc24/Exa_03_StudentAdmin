package at.htlkaindorf;

import at.htlkaindorf.csv.IllegalCsvValueException;
import at.htlkaindorf.csv.StudentsCsvReader;
import at.htlkaindorf.pojo.Classname;
import at.htlkaindorf.pojo.Student;

import java.io.IOException;
import java.util.Map;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        StudentsCsvReader reader = new StudentsCsvReader();

        Map<Classname, TreeSet<Student>> students = reader.readFromCsvFile();

        int total = 0;
        for (Map.Entry<Classname, TreeSet<Student>> entry : students.entrySet()) {
            System.out.println(entry.getKey().getName() + " (" + entry.getValue().size() + " students)");
            entry.getValue().forEach(System.out::println);
            total += entry.getValue().size();
        }
        System.out.println("Total: " + total);

        try {
            reader.parseLine("1,A,B,01/01/2009,X,4BHIF,2.0");
        } catch (IllegalCsvValueException e) {
            System.out.println("OK: " + e.getMessage());
        }
        try {
            reader.parseLine("1,A,B,01/01/2009,F,5ZHIF,2.0");
        } catch (IllegalCsvValueException e) {
            System.out.println("OK: " + e.getMessage());
        }
    }
}
