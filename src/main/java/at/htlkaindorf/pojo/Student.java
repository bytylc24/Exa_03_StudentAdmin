package at.htlkaindorf.pojo;

import java.util.Objects;

public class Student implements Comparable<Student> {
    private Long id;
    private Byte catalogNr;
    private String firstname;
    private String lastname;
    private Float gradeAverage;
    private Classname classname;
    private Gender gender;

    public Student(Long id, Byte catalogNr, String firstname, String lastname,
                   Float gradeAverage, Classname classname, Gender gender) {
        this.id = id;
        this.catalogNr = catalogNr;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gradeAverage = gradeAverage;
        this.classname = classname;
        this.gender = gender;
    }

    // the csv file contains no catalog number, it is assigned after parsing
    public Student(Long id, String firstname, String lastname,
                   Float gradeAverage, Classname classname, Gender gender) {
        this(id, null, firstname, lastname, gradeAverage, classname, gender);
    }

    public Long getId() {
        return id;
    }

    public Byte getCatalogNr() {
        return catalogNr;
    }

    public void setCatalogNr(Byte catalogNr) {
        this.catalogNr = catalogNr;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Float getGradeAverage() {
        return gradeAverage;
    }

    public void setGradeAverage(Float gradeAverage) {
        this.gradeAverage = gradeAverage;
    }

    public Classname getClassname() {
        return classname;
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Student other) {
        return catalogNr.compareTo(other.catalogNr);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", catalogNr=" + catalogNr +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gradeAverage=" + gradeAverage +
                ", classname=" + classname +
                ", gender=" + gender +
                '}';
    }
}
