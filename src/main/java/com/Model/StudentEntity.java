package com.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "student", schema = "qlkh", catalog = "")
public class StudentEntity {
    private Integer id;
    private String username;
    private String password;
    private String studentName;
    private String mssv;
    private Timestamp dateOfBitrh;
    private Integer clazz;
    private String phone;
    private String address;
    private ClazzEntity clazzByClazz;
    private Collection<StudentregistercourseEntity> studentregistercoursesById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 255)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "studentName", nullable = false, length = 255)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "MSSV", nullable = false, length = 255)
    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    @Basic
    @Column(name = "dateOfBitrh", nullable = true)
    public Timestamp getDateOfBitrh() {
        return dateOfBitrh;
    }

    public void setDateOfBitrh(Timestamp dateOfBitrh) {
        this.dateOfBitrh = dateOfBitrh;
    }

    @Basic
    @Column(name = "class", nullable = true)
    public Integer getClazz() {
        return clazz;
    }

    public void setClazz(Integer clazz) {
        this.clazz = clazz;
    }

    @Basic
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 255)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(studentName, that.studentName) && Objects.equals(mssv, that.mssv) && Objects.equals(dateOfBitrh, that.dateOfBitrh) && Objects.equals(clazz, that.clazz) && Objects.equals(phone, that.phone) && Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, studentName, mssv, dateOfBitrh, clazz, phone, address);
    }

    @ManyToOne
    @JoinColumn(name = "class", referencedColumnName = "id")
    public ClazzEntity getClazzByClazz() {
        return clazzByClazz;
    }

    public void setClazzByClazz(ClazzEntity clazzByClazz) {
        this.clazzByClazz = clazzByClazz;
    }

    @OneToMany(mappedBy = "studentByIdStudent")
    public Collection<StudentregistercourseEntity> getStudentregistercoursesById() {
        return studentregistercoursesById;
    }

    public void setStudentregistercoursesById(Collection<StudentregistercourseEntity> studentregistercoursesById) {
        this.studentregistercoursesById = studentregistercoursesById;
    }
}
