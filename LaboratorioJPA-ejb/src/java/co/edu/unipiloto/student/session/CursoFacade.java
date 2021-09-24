/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.session;

import co.edu.unipiloto.student.entity.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author admin
 */
@Stateless
public class CursoFacade extends AbstractFacade<Curso> implements CursoFacadeLocal {

    @PersistenceContext(unitName = "LaboratorioJPA-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CursoFacade() {
        super(Curso.class);
    }
        @Override
    public void addCurso(Curso curso) {
        em.persist(curso);
    }

    @Override
    public void deleteCurso(int codigoCurso) {
        em.remove(getCurso(codigoCurso));
    }

   
    @Override
    public List<Curso> getAllCurso() {
        return em.createNamedQuery("Curso.findAll").getResultList();
    }

    @Override
    public void editCurso(Curso curso) {
       em.merge(curso);
    }

    @Override
    public Curso getCurso(int codigoCurso) {
       return em.find(Curso.class, codigoCurso);
    }
}
