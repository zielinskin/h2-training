package zielinskin.h2example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Student extends AttendingStudent {
    private final List<StudentEnrolledClass> enrolledClasses;

    public Student(@JsonProperty("id") Integer id,
                   @JsonProperty("name") String name,
                   @JsonProperty("enrolledClasses") List<StudentEnrolledClass> enrolledClasses) {
        super(id, name);
        this.enrolledClasses = enrolledClasses;
    }

    public List<StudentEnrolledClass> getEnrolledClasses() {
        return enrolledClasses;
    }
}
