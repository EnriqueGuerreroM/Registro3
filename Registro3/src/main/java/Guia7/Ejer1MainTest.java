/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Guia7;

import java.util.Scanner;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author Enrique
 */
public class Ejer1MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String nombre,id_banco,password;
        String passEncript;
        
        Scanner input = new Scanner(System.in);
        
        System.out.println("Ingrese su nombre:");
        nombre = input.nextLine();
        System.out.println("Ingrese su Id:");
        id_banco = input.nextLine();
        System.out.println("Ingrese su password:");
        password = input.nextLine();
        
        passEncript = encript(password);
        
        Ejer1 cuentaBanco = new Ejer1(nombre,id_banco,passEncript);
        
        System.out.println("los Datos son:");
        System.out.println("nombre: " + cuentaBanco.getNombre());
        System.out.println("id_banco:" + cuentaBanco.getId_banco());
        System.out.println("pssword:" + cuentaBanco.getPassword());
        
        String password_check;
        System.out.println("Ingresa el password a verificar: ");
        password_check = input.nextLine();
        if (BCrypt.checkpw(password_check, cuentaBanco.getPassword())) {
            System.out.println("El password es correcto");
            
        }else{
            System.out.println("el password es incorrecto");
        }

        
    }
    public static String encript(String pass){
        return BCrypt.hashpw(pass, BCrypt.gensalt());
    }
}
