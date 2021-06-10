package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student"  )
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class StudentEntity {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
      
    @Column(name = "username", nullable = false, length = 255)
    private String username;
    
      
    @Column(name = "password", nullable = false, length = 255)
    private String password;
    
      
    @Column(name = "studentName", nullable = false, length = 255)
    private String studentName;
    
      
    @Column(name = "MSSV", nullable = false, length = 255)
    private String mssv;
    
      
    @Column(name = "dateOfBitrh", nullable = true)
    private Timestamp dateOfBitrh;
    
      
    @Column(name = "phone", nullable = true, length = 255)
    private String phone;
    
      
    @Column(name = "address", nullable = true, length = 255)
    private String address;
    
    @ManyToOne
    @JoinColumn(name = "class", referencedColumnName = "id")
    private ClazzEntity clazzByClazz;
    
    @OneToMany(mappedBy = "idStudent")
    private Collection<StudentregistercourseEntity> studentregistercoursesById;

}
