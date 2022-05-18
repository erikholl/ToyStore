package be.intecbrussels.services.interfaces;

import be.intecbrussels.data.Animal;

import java.util.List;

public interface AnimalService {

    public List<Animal> getAllAnimals();
    public Animal getAnimalById(int id);
    public void createAnimal(Animal animal);
    // .... etc


}
