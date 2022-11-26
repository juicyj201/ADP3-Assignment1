package za.ac.cput.Domain.Entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * Keziah Robinson
 * 219113149
 * Student Entity
 * 05 April 2021
 *
 */

@Entity
@Table(name = "student")
public class Student implements Serializable
{
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentID")
    private long studentID;
    @Column(name = "studFirstName")
    private String studFirstName;
    @Column(name = "studSurname")
    private String studSurname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private String age;
    @Column(name = "allergies")
    private String allergies;
    @Column(name = "password")
    private String password;


    private Student(StudentBuilder builder){
        this.studentID = builder.studentID;
        this.studFirstName = builder.studFirstName;
        this.studSurname = builder.studSurname;
        this.gender = builder.gender;
        this.age = builder.age;
        this.allergies = builder.allergies;
    }

    public Student() {
    }

    public long getStudentID() {
        return studentID;
    }

    public String getStudFirstName() {
        return studFirstName;
    }

    public String getStudSurname() {
        return studSurname;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public String getAllergies() {
        return allergies;
    }

    public String getPassword() {
        return password;
    }
    @Override
    public String toString() {
        return "Student{" + "StudentID='" + studentID + '\'' + ", StudFirstName='" + studFirstName + '\'' + ", StudSurname='" + studSurname + '\'' + ", Gender='" + gender + '\'' + ", Age=" + age + ", Allergies='" + allergies + '\'' + '}';
    }


    public static class StudentBuilder{

        private long studentID;
        private String studFirstName;
        private String studSurname;
        private String gender;
        private String age;
        private String allergies;

//        public StudentBuilder() {
//            this.studentID = studentID;
//            this.studFirstName = studFirstName;
//            this.studSurname = studSurname;
//            this.gender = gender;
//            this.age = age;
//            this.allergies = allergies;
//        }

        public StudentBuilder createStudentID(long studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder createStudFirstName(String studFirstName) {
            this.studFirstName = studFirstName;
            return this;
        }

        public StudentBuilder createStudSurname(String studSurname) {
            this.studSurname = studSurname;
            return this;
        }

        public StudentBuilder createGender(String gender) {
            this.gender = gender;
            return this;
        }

        public StudentBuilder createAge(String age) {
            this.age = age;
            return this;
        }

        public StudentBuilder createAllergies(String allergies) {
            this.allergies = allergies;
            return this;
        }

        public Student copy(Student student)
        {
            this.studentID = student.studentID;
            this.studFirstName = student.studFirstName;
            this.gender = student.gender;
            this.age = student.age;
            this.allergies = student.allergies;
            return student;
        }

        public Student builder() {

            return new Student(this);
        }


    }
}
