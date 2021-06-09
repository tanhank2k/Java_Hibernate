package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subject", schema = "qlkh", catalog = "")
public class SubjectEntity {
    private Integer id;
    private String subjectCode;
    private String subjectName;
    private Integer numberOfCredits;
    private Collection<CourseEntity> coursesById;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "subjectCode")
    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    @Basic
    @Column(name = "subjectName")
    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Basic
    @Column(name = "numberOfCredits")
    public Integer getNumberOfCredits() {
        return numberOfCredits;
    }

    public void setNumberOfCredits(Integer numberOfCredits) {
        this.numberOfCredits = numberOfCredits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectEntity that = (SubjectEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(subjectCode, that.subjectCode) && Objects.equals(subjectName, that.subjectName) && Objects.equals(numberOfCredits, that.numberOfCredits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, subjectCode, subjectName, numberOfCredits);
    }

    @OneToMany(mappedBy = "subjectByIdSubject")
    public Collection<CourseEntity> getCoursesById() {
        return coursesById;
    }

    public void setCoursesById(Collection<CourseEntity> coursesById) {
        this.coursesById = coursesById;
    }
}
