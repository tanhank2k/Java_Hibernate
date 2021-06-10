package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "studentregistercourse"  )
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentregistercourseEntity {
    @EmbeddedId
    private StudentregistercourseID id;
    
      
    @Column(name = "MSSV", nullable = true)
    private Integer mssv;
    
      
    @Column(name = "studentName", nullable = true, length = 255)
    private String studentName;
    
      
    @Column(name = "subjectCode", nullable = true, length = 255)
    private String subjectCode;
    
      
    @Column(name = "subjectName", nullable = true, length = 255)
    private String subjectName;
    
      
    @Column(name = "teacherName", nullable = true, length = 255)
    private String teacherName;
    
      
    @Column(name = "timeOnSchool", nullable = true, length = 128)
    private String timeOnSchool;
    
      
    @Column(name = "timeRegister", nullable = true)
    private Timestamp timeRegister;
}
