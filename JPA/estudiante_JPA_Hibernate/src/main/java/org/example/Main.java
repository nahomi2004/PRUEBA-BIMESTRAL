package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.example.Entidades.Estudiante;

import javax.swing.text.html.parser.Entity;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {

        // este es necesario para que exista un EntityManager
        try (EntityManagerFactory entityManagerFactory =
                    Persistence.createEntityManagerFactory("persistenciaUWU")) {
            /* EntityManager -> Persistence Context*/
            EntityManager em =  entityManagerFactory.createEntityManager(); // Representa el conexto de persistencia, se utiliza para manejar las transacciones

            em.getTransaction().begin();

            // aquí se inician las ejecuciones

            // Estudiante est = new Estudiante();
            // est.setId(2L);
            // est.setCedula("1103689491");
            // est.setNombres("VERÓNICA VIRGINIA");
            // est.setApellidos("PICOITA GORDILLO");

            // em.persist(est);

            Estudiante est = em.find(Estudiante.class, 1L);
            System.out.println(est);

            // aquí terminan

            em.getTransaction().commit();

        }
    }

    public static void agregarCliente() {

        System.out.println("Ingrese el número de cédula");
        String cedula = entrada.nextLine();


    }

    public static void buscarCliente() {

    }
}

/*
* Map<String, String> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");

*
* */