package modeling101;

import java.time.LocalDateTime;

public class Examination implements ExaminationInfo {
    LocalDateTime starting;
    LocalDateTime ending;
    String subject;
    CourseInfo course;
}
