package be.intecbrussels.repository;

import be.intecbrussels.data.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Integer> {

}
