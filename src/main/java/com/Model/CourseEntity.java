package com.Model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "course", schema = "qlkh", catalog = "")
public class CourseEntity {
    private Integer id;
    private Integer idSemester;
    private String semesterName;
    private Integer idSubject;
    private String subjectCode;
    private String subjectName;
    private Integer numberOfCredits;
    private String teacherName;
    private String roomName;
    private String dateOnSchool;
    private Integer period;
    private SemesterEntity semesterByIdSemester;
    private SubjectEntity subjectByIdSubject;
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
    @Column(name = "idSemester", nullable = true)
    public Integer getIdSemester() {
        return idSemester;
    }

    public void setIdSemester(Integer idSemester) {
        this.idSemester = idSemester;
    }

    @Basic
    @Column(name = "semesterName", nullable = true, length = 255)
    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Basic
    @Column(name = "idSubject", nullable = true)
    public Integer getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(Integer idSubject) {
        this.idSubject = idSubject;
    }

    @Basic
    @Column(name = "subjectCode", nullable = false, length = 255)
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Basic
    @Column(name = "subjectName", nullable = false, length = 255)
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Basic
    @Column(name = "numberOfCredits", nullable = false)
    public Integer getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(Integer numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Basic
    @Column(name = "teacherName", nullable = false, length = 255)
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Basic
    @Column(name = "roomName", nullable = true, length = 255)
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    @Basic
    @Column(name = "dateOnSchool", nullable = true, length = 255)
    public String getDateOnSchool() {
        return dateOnSchool;
    }

    public void setDateOnSchool(String dateOnSchool) {
        this.dateOnSchool = dateOnSchool;
    }

    @Basic
    @Column(name = "period", nullable = true)
    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(idSemester, that.idSemester) && Objects.equals(semesterName, that.semesterName) && Objects.equals(idSubject, that.idSubject) && Objects.equals(subjectCode, that.subjectCode) && Objects.equals(subjectName, that.subjectName) && Objects.equals(numberOfCredits, that.numberOfCredits) && Objects.equals(teacherName, that.teacherName) && Objects.equals(roomName, that.roomName) && Objects.equals(dateOnSchool, that.dateOnSchool) && Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSemester, semesterName, idSubject, subjectCode, subjectName, numberOfCredits, teacherName, roomName, dateOnSchool, period);
    }

    @ManyToOne
    @JoinColumn(name = "idSemester", referencedColumnName = "id")
    public SemesterEntity getSemesterByIdSemester() {
        return semesterByIdSemester;
    }

    public void setSemesterByIdSemester(SemesterEntity semesterByIdSemester) {
        this.semesterByIdSemester = semesterByIdSemester;
    }

    @ManyToOne
    @JoinColumn(name = "idSubject", referencedColumnName = "id")
    public SubjectEntity getSubjectByIdSubject() {
        return subjectByIdSubject;
    }

    public void setSubjectByIdSubject(SubjectEntity subjectByIdSubject) {
        this.subjectByIdSubject = subjectByIdSubject;
    }

    @OneToMany(mappedBy = "courseByIdCourse")
    public Collection<StudentregistercourseEntity> getStudentregistercoursesById() {
        return studentregistercoursesById;
    }

    public void setStudentregistercoursesById(Collection<StudentregistercourseEntity> studentregistercoursesById) {
        this.studentregistercoursesById = studentregistercoursesById;
    }
}
