package com.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "class", schema = "qlkh", catalog = "")
public class ClazzEntity {
    private Integer id;
    private String className;
    private Integer totalStudent;
    private Integer totalMale;
    private Integer totalFeMale;
    private Collection<StudentEntity> studentsById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "className", nullable = false, length = 255)
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Basic
    @Column(name = "totalStudent", nullable = false)
    public Integer getTotalStudent() {
        return totalStudent;
    }

    public void setTotalStudent(Integer totalStudent) {
        this.totalStudent = totalStudent;
    }

    @Basic
    @Column(name = "totalMale", nullable = false)
    public Integer getTotalMale() {
        return totalMale;
    }

    public void setTotalMale(Integer totalMale) {
        this.totalMale = totalMale;
    }

    @Basic
    @Column(name = "totalFeMale", nullable = false)
    public Integer getTotalFeMale() {
        return totalFeMale;
    }

    public void setTotalFeMale(Integer totalFeMale) {
        this.totalFeMale = totalFeMale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClazzEntity that = (ClazzEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(className, that.className) && Objects.equals(totalStudent, that.totalStudent) && Objects.equals(totalMale, that.totalMale) && Objects.equals(totalFeMale, that.totalFeMale);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, className, totalStudent, totalMale, totalFeMale);
    }

    @OneToMany(mappedBy = "clazzByClazz")
    public Collection<StudentEntity> getStudentsById() {
        return studentsById;
    }

    public void setStudentsById(Collection<StudentEntity> studentsById) {
        this.studentsById = studentsById;
    }
}
