package org.example.presentacion;

import org.example.persistencia.ClientesEntity;
import org.example.persistencia.DireccionesEntity;
import org.example.persistencia.EsposasEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        SessionFactory sessionFactory =
                new Configuration().configure().buildSessionFactory();

        Session session = sessionFactory.openSession();
        if(session != null) {
            System.out.println("Se inició sesión");

            // System.out.println( "Hello World!" );

            ClientesEntity cliente = new ClientesEntity(2, "1430058267","Julían","Marquez");
            EsposasEntity esposa = new EsposasEntity(02, "1153604475", "Ana", "Suarez", cliente);
            DireccionesEntity direccion = new DireccionesEntity(2,"Sucre","Mercadillo");
            // cliente.getDireccionesByIdCliente().add(direccion);

            System.out.println(esposa);
            System.out.println(direccion);

        } else {
            System.out.println("Error al abrir la sesión");
        }

    }
}
