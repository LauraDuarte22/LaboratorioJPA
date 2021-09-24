/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "CURSO_STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CursoStudent.findAll", query = "SELECT c FROM CursoStudent c"),
    @NamedQuery(name = "CursoStudent.findByStudentid", query = "SELECT c FROM CursoStudent c WHERE c.cursoStudentPK.studentid = :studentid"),
    @NamedQuery(name = "CursoStudent.findByCodigoCurso", query = "SELECT c FROM CursoStudent c WHERE c.cursoStudentPK.codigoCurso = :codigoCurso"),
    @NamedQuery(name = "CursoStudent.findByCurso", query = "SELECT c FROM CursoStudent c WHERE c.curso = :curso")})
public class CursoStudent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CursoStudentPK cursoStudentPK;
    @Column(name = "CURSO")
    private Integer curso;
    @JoinColumn(name = "CODIGO_CURSO", referencedColumnName = "CODIGO_CURSO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso1;
    @JoinColumn(name = "STUDENTID", referencedColumnName = "STUDENTID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public CursoStudent() {
    }

    public CursoStudent(CursoStudentPK cursoStudentPK) {
        this.cursoStudentPK = cursoStudentPK;
    }

    public CursoStudent(int studentid, int codigoCurso) {
        this.cursoStudentPK = new CursoStudentPK(studentid, codigoCurso);
    }

    public CursoStudentPK getCursoStudentPK() {
        return cursoStudentPK;
    }

    public void setCursoStudentPK(CursoStudentPK cursoStudentPK) {
        this.cursoStudentPK = cursoStudentPK;
    }

    public Integer getCurso() {
        return curso;
    }

    public void setCurso(Integer curso) {
        this.curso = curso;
    }

    public Curso getCurso1() {
        return curso1;
    }

    public void setCurso1(Curso curso1) {
        this.curso1 = curso1;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cursoStudentPK != null ? cursoStudentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoStudent)) {
            return false;
        }
        CursoStudent other = (CursoStudent) object;
        if ((this.cursoStudentPK == null && other.cursoStudentPK != null) || (this.cursoStudentPK != null && !this.cursoStudentPK.equals(other.cursoStudentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.CursoStudent[ cursoStudentPK=" + cursoStudentPK + " ]";
    }
    
}
