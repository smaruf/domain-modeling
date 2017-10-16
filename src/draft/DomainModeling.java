package draft;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

//student*<----->*course
//teacher*<----->*course
//course<------>fee
//course----->*classroom
//course----->*time
//course----->*exam
//student----->*exam
//teacher------>*exam
//course------->*books
//student------->*books
//teacher------->*books
//student------->*grade
//grade------->exam


class Student {
    Set<Course> courses;
    Set<Teacher> teachers;
    Set<Examination> exams;
    Set<Book> books;
    Set<Grade> grades;
}

class Course {
    Set<Student> students;
    Set<Teacher> teachers;
    Fee fee;
    Set<ClassRoom> classRooms;
    Set<TimeSchedule> times;
    Set<Book> books;
    Set<Examination> exams;
}

class Teacher {
    Set<Student> students;
    Set<Course> courses;
    Set<TimeSchedule> times;
    Set<Examination> exams;
    Set<Book> books;
}

class TimeSchedule {
    LocalDateTime starting;
    LocalDateTime ending;
}

class ClassRoom {
    Integer roomNumber;
    Integer buildingNumber;
    Integer availableFrom;
    Integer availableTo;
}

class Book {
    String subject;
    String title;
    String writer;
    String briefContents;
}

class Examination {
    LocalDateTime starting;
    LocalDateTime ending;
    String subject;
    Course course;
}

class Grade {
    Student student;
    Double gradePoint;
    Examination exam;
    String subject;
}

class Fee {
    LocalDate staring;
    LocalDate ending;
    String currency;
    Double amount;
    Course course;
}

