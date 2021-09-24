/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Curso;
import co.edu.unipiloto.student.entity.CursoStudent;
import co.edu.unipiloto.student.entity.CursoStudentPK;
import co.edu.unipiloto.student.entity.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class CursoStudentFacade extends AbstractFacade<CursoStudent> implements CursoStudentFacadeLocal {

    @PersistenceContext(unitName = "LaboratorioJPA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoStudentFacade() {
        super(CursoStudent.class);
    }

    @Override
    public boolean insertarEstudianteCurso(int studentid, int codCurso) {
       CursoStudentPK pk=new CursoStudentPK(studentid, codCurso);
       if(consultar(pk)!=null){
           return false;
       }else{
           CursoStudent cs=new CursoStudent(pk); 
           em.persist(cs);
           return true;
       }
    }
    @Override
     public void editStudent(CursoStudent cs) {
        em.merge(cs);
    }

    @Override
    public void deleteStudent(int studentId) {
        em.remove(getStudent(studentId));
    }

    @Override
    public CursoStudent getStudent(int studentId) {
        return em.find(CursoStudent.class, studentId);
    }

    @Override
    public CursoStudent consultar(CursoStudentPK pk) {
        return em.find(CursoStudent.class, pk);
    }
@Override
    public List<CursoStudent> getAllCurso() {
        return em.createNamedQuery("Curso.findAll").getResultList();
    }
  
    
    
}
