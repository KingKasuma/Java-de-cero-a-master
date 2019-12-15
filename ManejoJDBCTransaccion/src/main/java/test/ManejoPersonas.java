package test;

import datos.Conexion;
import datos.PersonaJDBC;
import domain.Persona;
import java.sql.Connection;
import java.sql.*;
import java.util.List;

public class ManejoPersonas {
    
    public static void main(String[] args) {        
        Connection conexion = null;
        try{
            conexion = Conexion.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            PersonaJDBC personaJDBC = new PersonaJDBC(conexion);
            
            Persona cambioPersona = new Persona();
            cambioPersona.setId_persona(2);
            cambioPersona.setNombre("Karla Ivonne");
            cambioPersona.setApellido("Gomez");
            cambioPersona.setEmail("kgomez@mail.com");
            cambioPersona.setTelefono("123456");
            personaJDBC.update(cambioPersona);
            
            Persona nuevaPersona = new Persona();
            nuevaPersona.setNombre("Carlos");
            //nuevaPersona.setApellido("Ramirez11111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111");            
            nuevaPersona.setApellido("Ramirez");
            personaJDBC.insert(nuevaPersona);
            
            conexion.commit();      
            System.out.println("Se ha hecho commit de la transaccion");
            
        }catch(SQLException ex){
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
            try{
                conexion.rollback();
            }catch(SQLException ex1){
                ex1.printStackTrace(System.out);
            }
        }
        
    }
    
}
