package test;

import datos.UsuarioJDBC;
import domain.Usuario;
import java.util.List;

public class ManejoUsuarios {
    public static void main(String[] args) {
        UsuarioJDBC usuarioJDBC = new UsuarioJDBC();
               
        //Ejecutando el listado de usuarios
        List<Usuario> usuarios = usuarioJDBC.select();
        for(Usuario usuario: usuarios){
            System.out.println("Usuario:" + usuario);
        }
        
        //Insertamos un nuevo usuario
//        Usuario usuario = new Usuario("carlos.juarez", "123");
//        usuarioJDBC.insert(usuario);
        
        //Modificando un usuario existente
//        Usuario usuario = new Usuario(3, "carlos.juarez", "456");
//        usuarioJDBC.update(usuario);

        //Eliminando un usuario existente
        usuarioJDBC.delete(new Usuario(3));
    }
}
