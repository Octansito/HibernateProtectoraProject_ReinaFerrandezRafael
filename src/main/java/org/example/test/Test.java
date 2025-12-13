package org.example.test;

import jakarta.persistence.PersistenceException;
import org.example.entity.Adopcion;
import org.example.entity.Animal;
import org.example.entity.Voluntario;
import org.example.service.GeneralService;
import org.example.util.HibernateUtil;
import org.example.entity.AnimalEstado;
import org.example.entity.AnimalTipo;
import org.example.entity.VoluntarioRol;


import java.time.LocalDate;
/**
 * Clase de pruebas que ejecuta todos los casos de uso del proyecto.
 * Inserta datos de ejemplo y llama a los servicios para verificar consultas y operaciones CRUD.
 */

public class Test {
    public static void main(String[] args) {
        try{
            GeneralService service=new GeneralService();

            //Creación VOLUNTARIOS
            Voluntario v1 = new Voluntario();
            v1.setDni("11111111A");
            v1.setNombre("María López");
            v1.setTelefono("600111222");
            v1.setRol(VoluntarioRol.Voluntario);
            v1.setAntiguedad(3);

            Voluntario v2 = new Voluntario();
            v2.setDni("22222222B");
            v2.setNombre("Carlos Pérez");
            v2.setTelefono("600333444");
            v2.setRol(VoluntarioRol.Responsable);
            v2.setAntiguedad(5);

            service.crearVoluntario(v1);
            service.crearVoluntario(v2);


            //Creación ADOPCIONES
            Adopcion ad1 = new Adopcion();
            ad1.setNombreAdoptante("Laura Ruiz");
            ad1.setTelefono("611223344");
            ad1.setDireccion("Calle Mayor 15");
            ad1.setFechaAdopcion(LocalDate.of(2024, 1, 10));
            service.crearAdopcion(ad1);

            Adopcion ad2 = new Adopcion();
            ad2.setNombreAdoptante("Pedro Martínez");
            ad2.setTelefono("688112233");
            ad2.setDireccion("Av. Libertad 22");
            ad2.setFechaAdopcion(LocalDate.of(2023, 8, 5));
            service.crearAdopcion(ad2);


            //Creación ANIMALES
            Animal a1 = new Animal();
            a1.setNombre("Toby");
            a1.setTipo(AnimalTipo.Perro);
            a1.setEdad(5);
            a1.setEstado(AnimalEstado.Adoptado);
            a1.setFechaIngreso(LocalDate.of(2023, 1, 1));
            a1.setAdopcion(ad1);

            Animal a2 = new Animal();
            a2.setNombre("Misu");
            a2.setTipo(AnimalTipo.Gato);
            a2.setEdad(2);
            a2.setEstado(AnimalEstado.Refugio);
            a2.setFechaIngreso(LocalDate.of(2022, 3, 15));

            Animal a3 = new Animal();
            a3.setNombre("Rex");
            a3.setTipo(AnimalTipo.Perro);
            a3.setEdad(7);
            a3.setEstado(AnimalEstado.Adoptado);
            a3.setFechaIngreso(LocalDate.of(2021, 6, 8));
            a3.setAdopcion(ad2);

            service.crearAnimal(a1);
            service.crearAnimal(a2);
            service.crearAnimal(a3);


            //Relación VOLUNTARIOS <---> ANIMALES (ManyToMany)
            v1.getAnimales().add(a1);
            v1.getAnimales().add(a2);

            v2.getAnimales().add(a3);

            service.actualizarVoluntario(v1);
            service.actualizarVoluntario(v2);


            //CONSULTA JPQL 1 (DTO)
            System.out.println("Animales adoptados por Laura Ruiz");
            service.animalesPorAdoptante("Laura")
                    .forEach(System.out::println);


            //CONSULTA JPQL 2
            System.out.println("Animales atendidos por el voluntario 11111111A");
            service.animalesPorVoluntario("11111111A")
                    .forEach(System.out::println);


            //CONSULTA JPQL 3
            System.out.println("Adopciones con más de 1 animal");
            service.adopcionesConMasDe(1)
                    .forEach(System.out::println);


            //CRITERIA 1 --> ordenar por edad
            System.out.println("Animales ordenados por edad");
            service.animalesOrdenadosPorEdad()
                    .forEach(System.out::println);


            //CRITERIA 2 --> ordenar adopciones por fecha
            System.out.println("Adopciones ordenadas por fecha");
            service.adopcionesOrdenadasPorFecha()
                    .forEach(System.out::println);


            // 10.PRUEBAS GENERIC DAO (EXTRA)
            System.out.println("Total animales en BD: " + service.countAnimales());
            System.out.println("¿Existe animal con ID 1? " + service.existeAnimal(1L));

        }catch(PersistenceException e) {
            System.err.println(e);
        } finally {
            HibernateUtil.getSessionFactory().close();
        }

    }
}
