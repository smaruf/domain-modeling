package draft;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

//student*-----*course
//teacher*-----*course
//course------fee
//course-----*classroom
//course-----*time
//course-----*exam
//student-----*exam
//teacher------*exam
//course-------*books
//student-------*books
//teacher-------*books
//student-------*grade
//grade-------exam

interface StudentInfo {
}

interface CourseInfo {
}

interface TeacherInfo {
}

interface FeeInfo {
}

interface ClassRoomInfo {
}

interface TimeInfo {
}

interface ExaminationInfo {
}

interface BookInfo {
}

interface GradeInfo {
}

class Student implements StudentInfo {
    Set<CourseInfo> courses;
    Set<TeacherInfo> teachers;
    Set<ExaminationInfo> exams;
    Set<BookInfo> books;
    Set<GradeInfo> grades;
}

class Course implements CourseInfo {
    Set<StudentInfo> students;
    Set<TeacherInfo> teachers;
    FeeInfo fee;
    Set<ClassRoomInfo> classRooms;
    Set<TimeInfo> times;
    Set<BookInfo> books;
}

class Teacher implements TeacherInfo {
    Set<StudentInfo> students;
    Set<CourseInfo> courses;
    Set<TimeInfo> times;
    Set<ExaminationInfo> exams;
    Set<BookInfo> books;
}

class TimeSchedule implements TimeInfo {
    LocalDateTime starting;
    LocalDateTime ending;
}

class ClassRoom implements ClassRoomInfo {
    Integer roomNumber;
    Integer buildingNumber;
    Integer availableFrom;
    Integer availableTo;
}

class Book implements BookInfo {
    String subject;
    String title;
    String writer;
    String briefContents;
}

class Examination implements ExaminationInfo {
    LocalDateTime starting;
    LocalDateTime ending;
    String subject;
    CourseInfo course;
}

class Grade implements GradeInfo {
    StudentInfo student;
    Double gradePoint;
    ExaminationInfo exam;
    String subject;
}

class Fee implements FeeInfo {
    LocalDate staring;
    LocalDate ending;
    String currency;
    Double amount;
    CourseInfo course;
}

