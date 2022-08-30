package com.legendaryadmin;

import com.legendaryadmin.Empleado;
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


    }

 
}
