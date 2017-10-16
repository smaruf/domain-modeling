package modeling101;

import java.time.LocalDate;

public class Fee implements FeeInfo {
    LocalDate staring;
    LocalDate ending;
    String currency;
    Double amount;
    CourseInfo course;
}
