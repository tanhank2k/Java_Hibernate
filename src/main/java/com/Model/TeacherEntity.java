package com.Model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "teacher")
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class TeacherEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

      
    @Column(name = "username", nullable = false, length = 255)
    private String username;


      
    @Column(name = "password", nullable = false, length = 255)
    private String password;

      
    @Column(name = "teacherName", nullable = false, length = 255)
    private String teacherName;

      
    @Column(name = "dateOfBitrh", nullable = true)
    private Timestamp dateOfBitrh;

      
    @Column(name = "position", nullable = true, length = 255)
    private String position;

      
    @Column(name = "phone", nullable = true, length = 25)
    private String phone;

      
    @Column(name = "address", nullable = true, length = 255)
    private String address;

}
