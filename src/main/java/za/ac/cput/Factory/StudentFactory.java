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
            (long studentID, String studFirstName, String studSurname, String gender, String age, String allergies) {

        if(allergies == null)
            return null;

        return new Student.StudentBuilder()
                .createStudentID(studentID)
                .createStudFirstName(studFirstName)
                .createStudSurname(studSurname)
                .createGender(gender)
                .createAge(age)
                .createAllergies(allergies)
                .builder();
    }
}
