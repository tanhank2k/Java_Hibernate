package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subject"  )
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SubjectEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

      
    @Column(name = "subjectCode", nullable = false, length = 255)
    private String subjectCode;

      
    @Column(name = "subjectName", nullable = false, length = 255)
    private String subjectName;

      
    @Column(name = "numberOfCredits", nullable = false)
    private Integer numberOfCredits;

    @OneToMany(mappedBy = "subjectByIdSubject")
    private Collection<CourseEntity> coursesById;
}