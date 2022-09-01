package com.legendaryadmin;

import com.legendaryadmin.Empleado;
import com.legendaryadmin.Empresa;
/**
 * Hello world!
 *
 */
// import com.legendaryadmin.Empleado;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "EMPLEADO!" );
       
        Empleado emple = new Empleado("breyner ocampo","breyner.95@gmail.com","ropas","operario");
        

        System.out.println(emple.getEmail());


        System.out.println( "EMPRESA!" );
       
        Empresa empre = new Empresa("Tu ropa","Colombia","3059033024",12345);
        

        System.out.println(empre.getNombre());
        System.out.println(empre.getDireccion());



    }

 
}
