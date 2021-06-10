package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Getter
@Setter
public class CourseEntity {
    @EqualsAndHashCode.Include
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
   
    @Column(name = "semesterName", nullable = true, length = 255)
    private String semesterName;
    
    
    @Column(name = "subjectCode", nullable = false, length = 255)
    private String subjectCode;
    
   
    @Column(name = "subjectName", nullable = false, length = 255)
    private String subjectName;
    
     
    @Column(name = "numberOfCredits", nullable = false)
    private Integer numberOfCredits;
    
     
    @Column(name = "teacherName", nullable = false, length = 255)
    private String teacherName;
    
     
    @Column(name = "roomName", nullable = true, length = 255)
    private String roomName;
    
     
    @Column(name = "dateOnSchool", nullable = true, length = 255)
    private String dateOnSchool;
    
     
    @Column(name = "period", nullable = true)
    private Integer period;
    
    @ManyToOne
    @JoinColumn(name = "idSemester", referencedColumnName = "id")
    private SemesterEntity semesterByIdSemester;
    
    @ManyToOne
    @JoinColumn(name = "idSubject", referencedColumnName = "id")
    private SubjectEntity subjectByIdSubject;
    
    @OneToMany(mappedBy = "idCourse")
    private Collection<StudentregistercourseEntity> studentregistercoursesById;

}
