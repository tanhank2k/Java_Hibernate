package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "courseregistrationsession")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CourseregistrationsessionEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NameCRS", nullable = false)
    private String nameCRS;
      
    @Column(name = "dateStart", nullable = false)
    private Date dateStart;
    
      
    @Column(name = "dateEnd", nullable = false)
    private Date dateEnd;
    
    @ManyToOne
    @JoinColumn(name = "idSemester", referencedColumnName = "id")
    private SemesterEntity semesterByIdSemester;

}
