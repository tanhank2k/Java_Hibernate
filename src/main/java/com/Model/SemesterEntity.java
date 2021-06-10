package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "semester")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SemesterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    
      
    @Column(name = "semesterName", nullable = false, length = 255)
    private String semesterName;
    
      
    @Column(name = "year", nullable = false)
    private Integer year;
    
      
    @Column(name = "dateStart", nullable = false)
    private Date dateStart;
    
      
    @Column(name = "dateEnd", nullable = false)
    private Date dateEnd;
    
    @OneToMany(mappedBy = "semesterByIdSemester")
    private Collection<CourseEntity> coursesById;
    
    @OneToMany(mappedBy = "semesterByIdSemester")
    private Collection<CourseregistrationsessionEntity> courseregistrationsessionsById;

}
