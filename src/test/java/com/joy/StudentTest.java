package com.joy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testAverageCalculation() {
        Student student = new Student("Joy");

        student.addGrade(60);
        student.addGrade(80);

        assertEquals(70, student.calculateAverage());
    }

    @Test
    void testPassingStudent() {
        Student student = new Student("Joy");

        student.addGrade(60);
        student.addGrade(70);

        assertTrue(student.isPassing());
    }

    @Test
    void testInvalidGrade() {
        Student student = new Student("Joy");

        assertThrows(
            IllegalArgumentException.class,
            () -> student.addGrade(120)
        );
    }
}