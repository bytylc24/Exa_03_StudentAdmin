package at.htlkaindorf.csv;

import at.htlkaindorf.pojo.Classname;
import at.htlkaindorf.pojo.Gender;
import at.htlkaindorf.pojo.Student;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.EnumMap;
import java.util.Map;
import java.util.TreeSet;

public class StudentsCsvReader {
    private static final String FINAL_PATH = "src/main/resources/students_classes.csv";

    public Map<Classname,TreeSet<Student>> readFromCsvFile() throws IOException {
        Map<Classname, TreeSet<Student>> students = new EnumMap<>(Classname.class);
        for(Classname classname : Classname.values()){
            students.put(classname,new TreeSet<>());
        }

        try(BufferedReader br = new BufferedReader(new FileReader(FINAL_PATH))){
            br.readLine();

            String line;
            while( (line = br.readLine()) != null){
                if(line.isBlank()) continue;
                Student student = parseLine(line);
                TreeSet<Student> studentSet = students.get(student.getClassname());
                student.setCatalogNr((byte) (studentSet.size() + 1));
                studentSet.add(student);
            }
        }
        return students;
    }

    public Student parseLine(String line){
        String[] tokens = line.split(",");
        if(tokens.length != 7){
            throw new IllegalArgumentException("Expected 7 tokens in line but found " + tokens.length);
        }

        return new Student(
                Long.parseLong(tokens[0].trim()),
                tokens[1].trim(),
                tokens[2].trim(),
                Float.parseFloat(tokens[6].trim()),
                parseClassname(tokens[5].trim()),
                parseGender(tokens[4].trim())
        );
    }

    private Classname parseClassname(String value){
        for(Classname classname : Classname.values()){
            if(classname.getName().equals(value)){
                return classname;
            }
        }
        throw new IllegalCsvValueException("Unsupported classname: " + value);
    }

    private Gender parseGender(String value){
        try{
            return Gender.valueOf(value);
        }catch(IllegalArgumentException e){
            throw new IllegalCsvValueException("Unsupported gender: " + value);
        }
    }
}
