/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Conexion.Conexion;
import Modelo.Alumno;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
//import java.sql.Statement;

/**
 *
 * @author camer
 */
public class AccionesAlumno{
    
    public AccionesAlumno(){
    
    }
        
    public static int AccionesAlumno(Alumno alu){
    
        int estatus = 0;
            
            
            try {
                Connection con = Conexion.getConnection();
                String q = "update alumno set nom_alu = ?, appat_alu = ?, apmat_alu = ?, edad_alu = ? "
                        + "where idAlumno = ?";
                PreparedStatement ps = con.prepareStatement(q);
                ps.setString(1, alu.getNom_alu());
                ps.setString(2, alu.getAppat_alu());
                ps.setString(3, alu.getApmat_alu());
                ps.setInt(4, alu.getEdad_alu());
                ps.setInt(5, alu.getIdAlumno());

                estatus = ps.executeUpdate();
                System.out.println("Se actualizo el alumno");
                con.close();
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
                System.out.println("No se pudo actualizar el alumno");
            }
            return estatus;
            
        }
    
    public static List<Alumno> getAllAlumnos(){
        //genero mi objeto de lista de un arrayList
        List<Alumno> lista = new ArrayList<Alumno>();
        
        try {
            //primero la conexion 
            Connection con = Conexion.getConnection();
            String q = "select * from alumno";
            //preparo la sentencia 
            PreparedStatement ps = con.prepareStatement(q);
            //voy a utilizar el objeto para la consulta de los datos
            ResultSet rs = ps.executeQuery();
            
            //como no se utlizar datos ya exite en la tabla debo de obtenerlos
            while(rs.next()){
                //genero objeto tipo alumno
                Alumno alu = new Alumno();
                alu.setIdAlumno(rs.getInt(1));
                alu.setNom_alu(rs.getString(2));
                alu.setAppat_alu(rs.getString(3));
                alu.setApmat_alu(rs.getString(4));
                alu.setEdad_alu(rs.getInt(5));
                //los agrego a mi lista
                lista.add(alu);
            }
            System.out.println("Se hizo la consulta de alumno");
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se encontra la tabla");
        }
        return lista;
    }
    
    public static Alumno buscarAlumnoById(int id){
        //necesito crear una instancia del alumno
        Alumno alu = new Alumno();
        try {
            Connection con = Conexion.getConnection();
            String q = "select * from alumno where idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setInt(1, id);
            //para la consults
            ResultSet rs = ps.executeQuery();
            //tengo que buscar dentro de la tabla 
            if(rs.next()){
                //get y set
                alu.setIdAlumno(rs.getInt(1));
                alu.setNom_alu(rs.getString(2));
                alu.setAppat_alu(rs.getString(3));
                alu.setApmat_alu(rs.getString(4));
                alu.setEdad_alu(rs.getInt(5));
            }
            System.out.println("Se encontro alumno");
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se encontro al alumno");
        }
        return alu; //porque ya no quiero a todos solo a uno
    }
    
    
    public static int actualizarAlumno(Alumno alu){
        int estatus = 0;
        
        try {
            
            Connection con = Conexion.getConnection();
            String q = "update alumno set nom_alu = ?, appat_alu = ?, apmat_alu = ?, edad_alu = ? "
                    + "where idAlumno = ?";
            PreparedStatement ps = con.prepareStatement(q);
            ps.setString(1, alu.getNom_alu());
            ps.setString(2, alu.getAppat_alu());
            ps.setString(3, alu.getApmat_alu());
            ps.setInt(4, alu.getEdad_alu());
            ps.setInt(5, alu.getIdAlumno());
            
            estatus = ps.executeUpdate();
            System.out.println("Se actualizo el alumno");
            con.close();
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
            System.out.println("No se pudo actualizar el alumno");
        }
        return estatus;
    
    }
        
}
