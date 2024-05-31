package org.example.presentacion;

import org.example.entidades.EstudianteEntity;
import org.example.entidades.MatriculaEntity;
import org.example.entidades.*;
import org.hibernate.EntityMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.example.entidadesPersistencia.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )   {





        try (EntityManagerFactory entityManagerFactory =
                     Persistence.createEntityManagerFactory("default")){
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();

            EstudianteEntity estudiante = new EstudianteEntity();
            estudiante.setCedula("1103689491");
            estudiante.setNombres("VERÓNICA SOFÍA");
            estudiante.setApellidos("LUNA ERAS");
            entityManager.persist(estudiante);

            transaction.commit();
        } finally {
            if(transaction.isActive()) {
                transaction.rollback();
            }

            entityManager.close();
            entityManagerFactory.close();
        }
    }
}

/**
 * SessionFactory sessionFactory =
 *         new Configuration().configure().buildSessionFactory();
 *
 *         Session session = sessionFactory.openSession();
 *         if(session != null) {
 *         System.out.println("Se inició sesión");
 *         } else {
 *         System.out.println("Error al abrir la sesión");
 *         }
 *
 *         EstudianteEntity estudianteEntity = new EstudianteEntity();
 *         MatriculaEntity matriculaEntity;
 *         estudianteEntity.setNombres("VERÓNICA SOFÍA");
 *         estudianteEntity.setApellidos("LUNA ERAS");
 *         estudianteEntity.setCedula("1103689491");
 *
 *
 * Modelo.Clientes objCliente = new Modelo.Clientes();
 *
 *         Modelo.Direcciones objDireccion = new Modelo.Direcciones();
 *
 *         Controlador.ClientesJpaController JPACliente = new Controlador.ClientesJpaController();
 *
 *         Controlador.DireccionesJpaController JPADirecciones = new Controlador.DireccionesJpaController();
 *
 *         objCliente.setIdClie(1);
 *         objCliente.setCedula("JPA");
 *         objCliente.setNombres("JPAN");
 *         objCliente.setApellidos("JPA A");
 *
 *         JPACliente.create(objCliente);
 *
 *         objDireccion.setIdDir(0);
 *         objDireccion.setCalle1("Sucre");
 *         objDireccion.setCalle2("Bolivar");
 *         //objDireccion.setIdClie();
 *
 *         JPADirecciones.create(objDireccion);
 */