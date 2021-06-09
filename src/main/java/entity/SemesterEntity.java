package entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "semester", schema = "qlkh", catalog = "")
public class SemesterEntity {
    private Integer id;
    private String semesterName;
    private Object year;
    private Date dateStart;
    private Date dateEnd;
    private Collection<CourseEntity> coursesById;
    private Collection<CourseregistrationsessionEntity> courseregistrationsessionsById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "semesterName")
    public String getSemesterName() {
        return semesterName;
    }

    public void setSemesterName(String semesterName) {
        this.semesterName = semesterName;
    }

    @Basic
    @Column(name = "year")
    public Object getYear() {
        return year;
    }

    public void setYear(Object year) {
        this.year = year;
    }

    @Basic
    @Column(name = "dateStart")
    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "dateEnd")
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
        SemesterEntity that = (SemesterEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(semesterName, that.semesterName) && Objects.equals(year, that.year) && Objects.equals(dateStart, that.dateStart) && Objects.equals(dateEnd, that.dateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semesterName, year, dateStart, dateEnd);
    }

    @OneToMany(mappedBy = "semesterByIdSemester")
    public Collection<CourseEntity> getCoursesById() {
        return coursesById;
    }

    public void setCoursesById(Collection<CourseEntity> coursesById) {
        this.coursesById = coursesById;
    }

    @OneToMany(mappedBy = "semesterByIdSemester")
    public Collection<CourseregistrationsessionEntity> getCourseregistrationsessionsById() {
        return courseregistrationsessionsById;
    }

    public void setCourseregistrationsessionsById(Collection<CourseregistrationsessionEntity> courseregistrationsessionsById) {
        this.courseregistrationsessionsById = courseregistrationsessionsById;
    }
}
