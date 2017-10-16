package modeling101;

import java.util.Set;

public class Course implements CourseInfo {
    Set<StudentInfo> students;
    Set<TeacherInfo> teachers;
    FeeInfo fee;
    Set<ClassRoomInfo> classRooms;
    Set<TimeInfo> times;
    Set<BookInfo> books;
}
