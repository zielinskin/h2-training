package zielinskin.h2example.data;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class StudentClassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "classId")
    private ClassEntity classEntity;
    @ManyToOne
    @JoinColumn(name = "studentId")
    private StudentEntity studentEntity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ClassEntity getClassEntity() {
        return classEntity;
    }

    public void setClassEntity(ClassEntity classEntity) {
        this.classEntity = classEntity;
    }

    public StudentEntity getStudentEntity() {
        return studentEntity;
    }

    public void setStudentEntity(StudentEntity studentEntity) {
        this.studentEntity = studentEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentClassEntity that = (StudentClassEntity) o;
        return classEntity.equals(that.classEntity) &&
                studentEntity.equals(that.studentEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classEntity, studentEntity);
    }
}
