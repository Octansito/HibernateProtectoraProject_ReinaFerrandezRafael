package org.example;


import jakarta.persistence.PersistenceException;
import org.example.entity.*;
import org.example.service.GeneralService;
import org.example.util.HibernateUtil;

import java.time.LocalDate;

/**
 *Clase principal que ejecuta varios casos de prueba del sistema
 */

public class Main {
    public static void main(String[] args) {
        try{
            GeneralService service=new GeneralService();
            System.out.println("INSERTANDO VOLUNTARIOS");
            Voluntario v1 = new Voluntario("12345678A", "Sofía Martín", "655112233", VoluntarioRol.Voluntario, 2, null);
            Voluntario v2 = new Voluntario("87654321B", "Diego Ramírez", "677889900", VoluntarioRol.Responsable, 4, null);

            service.crearVoluntario(v1);
            service.crearVoluntario(v2);

            System.out.println("INSERTANDO ADOPCIONES");
            Adopcion ad1 = new Adopcion();
            ad1.setNombreAdoptante("Carolina Torres");
            ad1.setTelefono("699001122");
            ad1.setDireccion("C/ Libertad 42, Valencia");
            ad1.setFechaAdopcion(LocalDate.of(2023, 7, 14));
            service.crearAdopcion(ad1);

            Adopcion ad2 = new Adopcion();
            ad2.setNombreAdoptante("Javier Montoya");
            ad2.setTelefono("622445566");
            ad2.setDireccion("Av. Europa 19, Alicante");
            ad2.setFechaAdopcion(LocalDate.of(2024, 2, 3));
            service.crearAdopcion(ad2);

            System.out.println("INSERTANDO ANIMALES");

            Animal a1 = new Animal(null, "Luna", AnimalTipo.Perro, 3, AnimalEstado.Adoptado,
                    LocalDate.of(2023, 3, 21), ad1, null);

            Animal a2 = new Animal(null, "Doki", AnimalTipo.Gato, 2, AnimalEstado.Refugio,
                    LocalDate.of(2022, 11, 8), ad1, null);

            Animal a3 = new Animal(null, "Pezcuezo", AnimalTipo.Perro, 6, AnimalEstado.Adoptado,
                    LocalDate.of(2020, 5, 18), ad2, null);

            Animal a4 = new Animal(null, "Gato", AnimalTipo.Gato, 1, AnimalEstado.Refugio,
                    LocalDate.of(2024, 1, 5), null, null);

            service.crearAnimal(a1);
            service.crearAnimal(a2);
            service.crearAnimal(a3);
            service.crearAnimal(a4);

            System.out.println("ASIGNANDO VOLUNTARIOS A ANIMALES");

            v1.getAnimales().add(a1);
            v1.getAnimales().add(a4);

            v2.getAnimales().add(a2);
            v2.getAnimales().add(a3);

            service.actualizarVoluntario(v1);
            service.actualizarVoluntario(v2);


            //CONSULTAS JPQL y CRITERIA
            System.out.println("JPQL 1: Animales por nombre adoptante");
            service.animalesPorAdoptante("Carolina").forEach(System.out::println);

            System.out.println("JPQL 2: Animales atendidos por un voluntario");
            service.animalesPorVoluntario("12345678A").forEach(System.out::println);

            System.out.println("JPQL 3: Adopciones con más de 1 animal");
            service.adopcionesConMasDe(1).forEach(System.out::println);

            System.out.println("CRITERIA 1: Animales ordenados por edad");
            service.animalesOrdenadosPorEdad().forEach(System.out::println);

            System.out.println("CRITERIA 2: Adopciones ordenadas por fecha");
            service.adopcionesOrdenadasPorFecha().forEach(System.out::println);

            System.out.println("EXTRAS DEL GENERIC DAO");
            System.out.println("Total animales: " + service.countAnimales());
            System.out.println("¿Existe animal con ID 3? " + service.existeAnimal(3L));

        }catch(PersistenceException e) {
            System.err.println(e);
        } finally {
            HibernateUtil.getSessionFactory().close();
        }
    }
}