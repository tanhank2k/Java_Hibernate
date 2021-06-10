package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "class")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ClazzEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "className", nullable = false, length = 255)
    private String className;

    @Column(name = "totalStudent", nullable = false)
    private Integer totalStudent;


    @Column(name = "totalMale", nullable = false)
    private Integer totalMale;


    @Column(name = "totalFeMale", nullable = false)
    private Integer totalFeMale;

    @OneToMany(mappedBy = "clazzByClazz")
    private Collection<StudentEntity> studentsById;



}
