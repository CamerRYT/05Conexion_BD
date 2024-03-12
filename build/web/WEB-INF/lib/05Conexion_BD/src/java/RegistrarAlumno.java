/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletConfig;
/**
 *
 * @author camer
 */
public class RegistrarAlumno extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * 
     * Vamos a conectar una vase de datos, es necesario contar con 3 tipos de objetos 
     */
    private Connection con; //esto es para conectar con la base de datos de una libreria viene 
    //con: es para establecer el objeto de connection
    private Statement set;
    //a donde me conecto?, el objeto set: es para poder defenir las sentencias de sql
    //por ejemplo una tabla registrar dato actualizar un dato, modificar la estrutura de un atributo
    private ResultSet rs;
    //rs:  es un objeto exclusivo de consultar (mostrar datos)
    //tiene un processaRequest lo que no tiene es un constructor
    
    //crear un tipo de constructor, sirve para inicializar el servicio
    //servletConfi: sirve para configurar el servicio
    public void init(ServletConfig scg) throws ServletException{
        //sirve para configurar el servicio, en la conexion con la base de datos
        //servlet te a devolver codigo de html mediante java
        String url = "jdbc:mysql:3306//localhost/registroalumnos"; //yo me pueda conectar
            //controlador:motor:puertoComunicacion//direccionIP/nombreBD
        String username = "root";}
        String password = "35182045";
        
        try{
            url = "jdbc:mysql://localhost/registroalumnos";
        try {
            //vamos a internar conectarnos a la BD
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RegistrarAlumno.class.getName()).log(Level.SEVERE, null, ex);
        }
            //despues debo de obtener el objeto de conexion
            con = DriverManager.getConnection(url, username, password);
            set = con.createStatement();
            
            System.out.println("Si conecto a la bd");
        }
        catch(Exception e){
            System.out.println("No se conecto a la bd");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
        
        
    
        

    }
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RegistrarAlumno</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RegistrarAlumno at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
