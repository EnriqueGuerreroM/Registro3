/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uees.registro3;

import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Enrique
 */
public class MainTestBcrypt {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombre,apellidos,departamento,email,id_usuario,password;
        Float edad;
        
        //objeto para leer teclado
        Scanner teclado = new Scanner (System.in);
        //valores de variables
        
        System.out.println("Ingresa el nombre del usuario: ");
        nombre = teclado.nextLine();
        System.out.println("Ingresa el apellido del usuario: ");
        apellidos = teclado.nextLine();
        System.out.println("Ingresa la edad: ");
        edad = Float.parseFloat(teclado.nextLine());
        System.out.println("Ingresa el departamento: ");
        departamento = teclado.nextLine();
        System.out.println("Ingresa el email: ");
        email = teclado.nextLine();
        System.out.println("Ingresa el id: ");
        id_usuario = teclado.nextLine();
        System.out.println("Ingresa el password: ");
        password = teclado.nextLine();
        
        //variable para encriptado de pass
        String pass_hash;
        
        //metodo de encriptacion 
        pass_hash = encriptar(password);
        
        // creacion de objeto login
        Login registro;
        registro = new Login(nombre, apellidos, edad, departamento, email, id_usuario, pass_hash);
        
        
        
        System.out.println("Los datos de registro son:");
        System.out.println("Nombre: " + registro.getNombre());
        System.out.println("Apellidos: " + registro.getApellidos());
        System.out.println("Edad: " + registro.getEdad());
        System.out.println("Departamento:" + registro.getDepartamento());
        System.out.println("Email: "+registro.getEmail());
        System.out.println("Id:" + registro.getId_usuario());
        System.out.println("Password:" + registro.getPassword());
        
        String password_check;
        System.out.println("Ingresa el password a verificar: ");
        password_check = teclado.nextLine();
        if (BCrypt.checkpw(password_check, registro.getPassword())) {
            System.out.println("El password es correcto");
            
        }else{
            System.out.println("el password es incorrecto");
        }

        
    }
    public static String encriptar(String pass){

    return BCrypt.hashpw(pass , BCrypt.gensalt());
    }
}
