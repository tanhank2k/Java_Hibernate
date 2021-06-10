package com.Model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "courseregistrationsession", schema = "qlkh", catalog = "")
public class CourseregistrationsessionEntity {
    private Integer id;
    private Integer idSemester;
    private Date dateStart;
    private Date dateEnd;
    private SemesterEntity semesterByIdSemester;

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
    @Column(name = "dateStart", nullable = false)
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "dateEnd", nullable = false)
    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseregistrationsessionEntity that = (CourseregistrationsessionEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(idSemester, that.idSemester) && Objects.equals(dateStart, that.dateStart) && Objects.equals(dateEnd, that.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idSemester, dateStart, dateEnd);
    }

    @ManyToOne
    @JoinColumn(name = "idSemester", referencedColumnName = "id")
    public SemesterEntity getSemesterByIdSemester() {
        return semesterByIdSemester;
    }

    public void setSemesterByIdSemester(SemesterEntity semesterByIdSemester) {
        this.semesterByIdSemester = semesterByIdSemester;
    }
}
