<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.studentid}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstName" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastName" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearlevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentid}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearlevel}</td>
                </tr>
            </c:forEach> 
        </table>
        

        <h1>Course Information</h1>

        <form action="./CourseServlet" method="POST">
            <table>
                <tr>
                    <td>Course cod</td>
                    <td><input type="text" name="codigoCurso" value="${Course.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Name course</td>
                    <td><input type="text" name="nombreCurso" value="${Course.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td>Credits</td>
                    <td><input type="text" name="creditos" value="${Course.creditos}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="semestre" value="${Course.semestre}" /></td>
                </tr>
                <tr>
                    <td># Students</td>
                    <td><input type="text" name="numeroEstudiantes" value="${Course.numeroEstudiantes}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>Course cod</th>
            <th>Name course</th>
            <th>Credits</th>
            <th>Semestre</th>
            <th># Students</th>
                <c:forEach items="${allCourses}" var="course">
                <tr>
                    <td>${course.codigoCurso}</td>
                    <td>${course.nombreCurso}</td>
                    <td>${course.creditos}</td>
                    <td>${course.semestre}</td>
                    <td>${course.numeroEstudiantes}</td> 
                </tr>
            </c:forEach> 
        </table>
        <h1>Course register</h1>

        <form action="./registerServlet" method="POST">
            <table>
                
                <tr>
                    <td>Course cod</td>
                    <td><input type="text" name="codigoCurso" value="${st.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Studen ID</td>
                    <td><input type="text" name="studentid" value="${st.studentid}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                     
                    </td>
                </tr>
            </table>
        </form>
        <br>
     
        
    </body>
</html>
