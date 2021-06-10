package com.Model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class StudentregistercourseID implements Serializable {
    @ManyToOne
    @JoinColumn(name = "idStudent")
    private StudentEntity student;

    @ManyToOne
   @JoinColumn(name = "idCourse")
    private CourseEntity course;

}
