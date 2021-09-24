/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author admin
 */
@Embeddable
public class CursoStudentPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "STUDENTID")
    private int studentid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO_CURSO")
    private int codigoCurso;

    public CursoStudentPK() {
    }

    public CursoStudentPK(int studentid, int codigoCurso) {
        this.studentid = studentid;
        this.codigoCurso = codigoCurso;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) studentid;
        hash += (int) codigoCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CursoStudentPK)) {
            return false;
        }
        CursoStudentPK other = (CursoStudentPK) object;
        if (this.studentid != other.studentid) {
            return false;
        }
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "co.edu.unipiloto.student.entity.CursoStudentPK[ studentid=" + studentid + ", codigoCurso=" + codigoCurso + " ]";
    }
    
}
