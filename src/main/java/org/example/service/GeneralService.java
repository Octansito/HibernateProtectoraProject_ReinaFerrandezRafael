package org.example.service;

import org.example.dto.AnimalAdopcionDTO;
import org.example.entity.Adopcion;
import org.example.entity.Animal;
import org.example.entity.Voluntario;

import java.util.List;
import java.util.Optional;

public class GeneralService {
    private final AnimalService animalService;
    private final AdopcionService adopcionService;
    private final VoluntarioService voluntarioService;

    public GeneralService() {
        this.animalService = new AnimalService();
        this.adopcionService = new AdopcionService();
        this.voluntarioService = new VoluntarioService();
    }


    //ANIMAL SERVICE


    public void crearAnimal(Animal a) {
        animalService.save(a);
    }

    public Optional<Animal> buscarAnimal(Long id) {
        return animalService.findById(id);
    }

    public List<Animal> listarAnimales() {
        return animalService.findAll();
    }

    public void actualizarAnimal(Animal a) {
        animalService.update(a);
    }

    public void borrarAnimal(Long id) {
        animalService.deleteById(id);
    }

    public long countAnimales() {
        return animalService.count();
    }

    public boolean existeAnimal(Long id) {
        return animalService.findById(id).isPresent();
    }

    // JPQL 1 (DTO)
    public List<AnimalAdopcionDTO> animalesPorAdoptante(String nombre) {
        return animalService.buscarPorAdoptante(nombre);
    }

    // JPQL 2
    public List<Animal> animalesPorVoluntario(String dni) {
        return animalService.animalesPorVoluntario(dni);
    }

    // CRITERIA 1
    public List<Animal> animalesOrdenadosPorEdad() {
        return animalService.ordenarPorEdad();
    }


    //ADOPCION SERVICE


    public void crearAdopcion(Adopcion a) {
        adopcionService.save(a);
    }

    public Optional<Adopcion> buscarAdopcion(Long id) {
        return adopcionService.findById(id);
    }

    public List<Adopcion> listarAdopciones() {
        return adopcionService.findAll();
    }

    public void actualizarAdopcion(Adopcion a) {
        adopcionService.update(a);
    }

    public void borrarAdopcion(Long id) {
        adopcionService.deleteById(id);
    }

    public long countAdopciones() {
        return adopcionService.count();
    }

    // JPQL 3
    public List<Adopcion> adopcionesConMasDe(int cantidad) {
        return adopcionService.adopcionesConMasDe(cantidad);
    }

    // CRITERIA 2
    public List<Adopcion> adopcionesOrdenadasPorFecha() {
        return adopcionService.ordenarPorFecha();
    }


    // VOLUNTARIO SERVICE

    public void crearVoluntario(Voluntario v) {
        voluntarioService.save(v);
    }

    public Optional<Voluntario> buscarVoluntario(String dni) {
        return voluntarioService.findById(dni);
    }

    public List<Voluntario> listarVoluntarios() {
        return voluntarioService.findAll();
    }

    public void actualizarVoluntario(Voluntario v) {
        voluntarioService.update(v);
    }

    public void borrarVoluntario(String dni) {
        voluntarioService.deleteById(dni);
    }

    public long countVoluntarios() {
        return voluntarioService.count();
    }
}
