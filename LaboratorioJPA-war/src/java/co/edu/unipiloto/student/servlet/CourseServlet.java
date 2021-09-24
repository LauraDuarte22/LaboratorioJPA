/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.student.entity.Curso;
import co.edu.unipiloto.student.session.CursoFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
@WebServlet(name = "CourseServlet", urlPatterns = {"/CourseServlet"})
public class CourseServlet extends HttpServlet {

    @EJB
    private CursoFacadeLocal cursoFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String actionC = request.getParameter("action");
        int codigoCurso = Integer.valueOf(request.getParameter("codigoCurso"));
        String nombreCurso = request.getParameter("nombreCurso");
        int creditos = Integer.valueOf(request.getParameter("creditos"));
        int semestre = Integer.valueOf(request.getParameter("semestre"));
        int numeroEstudiantes = Integer.valueOf(request.getParameter("numeroEstudiantes"));
        Curso course = new Curso(codigoCurso, nombreCurso, creditos, semestre, numeroEstudiantes);
        
        if ("Add".equalsIgnoreCase(actionC)) {
            cursoFacade.addCurso(course);
        } else if ("Edit".equalsIgnoreCase(actionC)) {
            cursoFacade.editCurso(course);
        } else if ("Delete".equalsIgnoreCase(actionC)) {
            cursoFacade.deleteCurso(codigoCurso);
        } else if ("Search".equalsIgnoreCase(actionC)) {
            cursoFacade.getCurso(codigoCurso);
        }
        request.setAttribute("Course", course);
         request.setAttribute("allCourses", cursoFacade.getAllCurso());
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
