package com.joy;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private List<Integer> grades;

    public Student(String name) {
        this.grades = new ArrayList<>();
    }

    public void addGrade(int grade) {
        if (grade < 0 || grade > 100) {
            throw new IllegalArgumentException("Invalid grade");
        }
        grades.add(grade);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;

        int sum = 0;
        for (int g : grades) {
            sum += g;
        }
        return (double) sum / grades.size();
    }

    public boolean isPassing() {
        return calculateAverage() >= 50;
    }
}