package com.Model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "studentregistercourse", schema = "qlkh", catalog = "")
public class StudentregistercourseEntity {
    private Integer idStudent;
    private Integer mssv;
    private String studentName;
    private Integer idCourse;
    private String subjectCode;
    private String subjectName;
    private String teacherName;
    private String timeOnSchool;
    private Timestamp timeRegister;
    private StudentEntity studentByIdStudent;
    private CourseEntity courseByIdCourse;

    @Basic
    @Column(name = "idStudent", nullable = true)
    public Integer getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(Integer idStudent) {
        this.idStudent = idStudent;
    }

    @Basic
    @Column(name = "MSSV", nullable = true)
    public Integer getMssv() {
        return mssv;
    }

    public void setMssv(Integer mssv) {
        this.mssv = mssv;
    }

    @Basic
    @Column(name = "studentName", nullable = true, length = 255)
    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    @Basic
    @Column(name = "idCourse", nullable = true)
    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
    }

    @Basic
    @Column(name = "subjectCode", nullable = true, length = 255)
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Basic
    @Column(name = "subjectName", nullable = true, length = 255)
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Basic
    @Column(name = "teacherName", nullable = true, length = 255)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "timeOnSchool", nullable = true, length = 128)
    public String getTimeOnSchool() {
        return timeOnSchool;
    }

    public void setTimeOnSchool(String timeOnSchool) {
        this.timeOnSchool = timeOnSchool;
    }

    @Basic
    @Column(name = "timeRegister", nullable = true)
    public Timestamp getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(Timestamp timeRegister) {
        this.timeRegister = timeRegister;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentregistercourseEntity that = (StudentregistercourseEntity) o;
        return Objects.equals(idStudent, that.idStudent) && Objects.equals(mssv, that.mssv) && Objects.equals(studentName, that.studentName) && Objects.equals(idCourse, that.idCourse) && Objects.equals(subjectCode, that.subjectCode) && Objects.equals(subjectName, that.subjectName) && Objects.equals(teacherName, that.teacherName) && Objects.equals(timeOnSchool, that.timeOnSchool) && Objects.equals(timeRegister, that.timeRegister);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, mssv, studentName, idCourse, subjectCode, subjectName, teacherName, timeOnSchool, timeRegister);
    }

    @ManyToOne
    @JoinColumn(name = "idStudent", referencedColumnName = "id")
    public StudentEntity getStudentByIdStudent() {
        return studentByIdStudent;
    }

    public void setStudentByIdStudent(StudentEntity studentByIdStudent) {
        this.studentByIdStudent = studentByIdStudent;
    }

    @ManyToOne
    @JoinColumn(name = "idCourse", referencedColumnName = "id")
    public CourseEntity getCourseByIdCourse() {
        return courseByIdCourse;
    }

    public void setCourseByIdCourse(CourseEntity courseByIdCourse) {
        this.courseByIdCourse = courseByIdCourse;
    }
}
