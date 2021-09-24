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
import javax.ejb.Local;

/**
 *
 * @author admin
 */
@Local
public interface CursoStudentFacadeLocal {

    void create(CursoStudent cursoStudent);

    void edit(CursoStudent cursoStudent);

    void remove(CursoStudent cursoStudent);

    CursoStudent find(Object id);

    List<CursoStudent> findAll();

    List<CursoStudent> findRange(int[] range);

    int count();
   
    boolean insertarEstudianteCurso(int studentid, int codCurso);
    
    CursoStudent consultar(CursoStudentPK pk);
    List<CursoStudent> getAllCurso();
    

    void editStudent(CursoStudent cs);

    void deleteStudent(int studentId);

CursoStudent getStudent(int studentId);
}

