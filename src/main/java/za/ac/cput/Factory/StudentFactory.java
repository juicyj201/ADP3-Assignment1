package za.ac.cput.Factory;
/**
 *
 * Keziah Robinson
 * 219113149
 * Student Factory
 * 05 April 2021
 *
 */

import za.ac.cput.Domain.Entity.Student;

public class StudentFactory {

    public static Student createStudent
            (String StudentID, String StudFirstName, String StudSurname, String Gender, String Age, String Allergies) {

        if(Allergies == null)
            return null;

        return new Student.StudentBuilder()
                .setStudentID(StudentID)
                .setStudFirstName(StudFirstName)
                .setStudSurname(StudSurname)
                .setGender(Gender)
                .setAge(Age)
                .setAllergies(Allergies)
                .builder();
    }
}
