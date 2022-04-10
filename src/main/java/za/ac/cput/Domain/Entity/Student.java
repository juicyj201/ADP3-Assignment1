package za.ac.cput.Domain.Entity;
/**
 *
 * Keziah Robinson
 * 219113149
 * Student Entity
 * 05 April 2021
 *
 */

public class Student
{
    private String StudentID;
    private String StudFirstName;
    private String StudSurname;
    private String Gender;
    private String Age;
    private String Allergies;


    private Student(StudentBuilder builder){
        this.StudentID = builder.StudentID;
        this.StudFirstName = builder.StudFirstName;
        this.StudSurname = builder.StudSurname;
        this.Gender = builder.Gender;
        this.Age = builder.Age;
        this.Allergies = builder.Allergies;
    }

    public String setStudentID(String studentID) {
        this.StudentID = studentID;
        return studentID;
    }

    public String setStudFirstName(String studFirstName) {
        this.StudFirstName = studFirstName;
        return studFirstName;
    }

    public String setStudSurname(String studSurname) {
        this.StudSurname = studSurname;
        return studSurname;
    }

    public String setGender(String gender) {
        this.Gender = gender;
        return gender;
    }

    public String setAge(String age) {
        this.Age = age;
        return age;
    }

    public String setAllergies(String allergies) {
        this.Allergies = allergies;
        return allergies;
    }

    public String getStudentID() {
        return StudentID;
    }

    public String getStudFirstName() {
        return StudFirstName;
    }

    public String getStudSurname() {
        return StudSurname;
    }

    public String getGender() {
        return Gender;
    }

    public String getAge() {
        return Age;
    }

    public String getAllergies() {
        return Allergies;
    }

    @Override
    public String toString() {
        return "Student{" + "StudentID='" + StudentID + '\'' + ", StudFirstName='" + StudFirstName + '\'' + ", StudSurname='" + StudSurname + '\'' + ", Gender='" + Gender + '\'' + ", Age=" + Age + ", Allergies='" + Allergies + '\'' + '}';
    }


    public static class StudentBuilder{

        private String StudentID;
        private String StudFirstName;
        private String StudSurname;
        private String Gender;
        private String Age;
        private String Allergies;

        public StudentBuilder setStudentID(String studentID) {
            StudentID = studentID;
            return this;
        }

        public StudentBuilder setStudFirstName(String studFirstName) {
            StudFirstName = studFirstName;
            return this;
        }

        public StudentBuilder setStudSurname(String studSurname) {
            StudSurname = studSurname;
            return this;
        }

        public StudentBuilder setGender(String gender) {
            Gender = gender;
            return this;
        }

        public StudentBuilder setAge(String age) {
            Age = age;
            return this;
        }

        public StudentBuilder setAllergies(String allergies) {
            Allergies = allergies;
            return this;
        }

        public Student copy(Student student)
        {

            this.StudentID = student.StudentID;
            this.StudFirstName = student.StudFirstName;
            this.Gender = student.Gender;
            this.Age = student.Age;
            this.Allergies = student.Allergies;
            return student;
        }

        public Student builder() {
            return new Student(this);
        }


    }
}
