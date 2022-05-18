package be.intecbrussels.services.implementations;

import be.intecbrussels.data.Animal;
import be.intecbrussels.repository.AnimalRepo;
import be.intecbrussels.services.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImpl implements AnimalService {

    private AnimalRepo animalRepo;

    @Autowired // not required (Spring knows), but clear coding communication
    public AnimalServiceImpl(AnimalRepo animalRepo) {
        this.animalRepo = animalRepo;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalRepo.findAll(); // the JpaRepository class provides findAll
    }

    @Override
    public Animal getAnimalById(int id) {
        Animal animal = animalRepo.findById(id).get(); // the JpaRepository
        // class provides findById
        return animal;
    }

    @Override
    public void createAnimal(Animal animal) {
        animalRepo.save(animal); // JpaRepository provides save
    }

}
