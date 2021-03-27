package zielinskin.h2example.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AttendedClass extends StudentEnrolledClass {
    private final List<AttendingStudent> attendees;

    public AttendedClass(@JsonProperty("id") Integer id,
                         @JsonProperty("name") String name,
                         @JsonProperty("attendees") List<AttendingStudent> attendees) {
        super(id, name);
        this.attendees = attendees;
    }

    public List<AttendingStudent> getAttendees() {
        return attendees;
    }
}
