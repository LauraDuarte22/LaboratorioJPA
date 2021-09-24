
package co.edu.unipiloto.student.servlet;

import co.edu.unipiloto.student.entity.*;
import co.edu.unipiloto.student.servlet.*;
import co.edu.unipiloto.student.session.StudentFacadeLocal;
import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "StudentServlet", urlPatterns = {"/StudentServlet"})
public class StudentServlet extends HttpServlet {

    @EJB
    private StudentFacadeLocal studentFacade;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        String studentIdStr = request.getParameter("studentId");
        int studentId = 0;
        if (studentIdStr != null && !studentIdStr.equals("")) {
            studentId = Integer.valueOf(studentIdStr);
        }
        String firstname = request.getParameter("firstName");
        String lastname = request.getParameter("lastName");
        String yearLevelStr = request.getParameter("yearLevel");
        int yearLevel = 0;
        if (yearLevelStr != null && !yearLevelStr.equals("")) {
            yearLevel = Integer.valueOf(yearLevelStr);
        }
        Student student = new Student(lastname, firstname, studentId, yearLevel);

        if ("Add".equalsIgnoreCase(action)) {
            studentFacade.addStudent(student);
        } else if ("Edit".equalsIgnoreCase(action)) {
            studentFacade.editStudent(student);
        } else if ("Delete".equalsIgnoreCase(action)) {
            studentFacade.deleteStudent(studentId);
        } else if ("Search".equalsIgnoreCase(action)) {
            studentFacade.getStudent(studentId);
        }
        request.setAttribute("Student", student);
        request.setAttribute("allStudents", studentFacade.getAllStudents());
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
