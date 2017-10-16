package draft;

import java.time.LocalDateTime;
import java.util.Set;

class Student {
    Set<Course> courses;
    Set<Teacher> teachers;
    Department department;
}

class Course {
    Set<Student> students;
    Set<Teacher> teachers;
    Set<TimeSchedule> times;
    Department department;
}

class Teacher {
    Set<Student> students;
    Set<Course> courses;
    Set<TimeSchedule> times;
    Department department;
}

class TimeSchedule {
    LocalDateTime starting;
    LocalDateTime ending;
}

class Department
{
    Set<Student> students;
    Set<Teacher> teachers;
    Set<Course> courses;
}

class Semester {
    Set<Student> students;
    Set<Teacher> teachers;
    Set<Course> courses;
}

class CourseEnrollment {
    Set<Teacher> teachers;
    Set<Student> students;
    Course course;
}

