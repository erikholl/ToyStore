package be.intecbrussels.controller;

import be.intecbrussels.data.Animal;
import be.intecbrussels.services.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("allAnimals") // this is the url, used in browser
    public String showAllAnimals(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animalPage"; // this refers to the html in
        // /webapp/WEB-INF/templates/<page.html>
    }

    // method for BootStrap TODO: implement bootstrap template
    @GetMapping("allAnimalsBS")
    public String showAllAnimalsBS(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "index";
    }

    @GetMapping("animal/{id}")
    public String showSingleProduct(@PathVariable String id, Model model) {
        Integer idInInt;

        try {
            idInInt = Integer.parseInt(id);
        } catch (NumberFormatException nfe) {
            System.out.println("give a proper number"); // TODO: to browser
            idInInt = 1;
        }

        Animal animal = animalService.getAnimalById(idInInt);
        model.addAttribute(animal);

        return "singleItem"; // reference to the html resource
    }

    @GetMapping("addAnimal")
    public String makeAnimal() {
        return "animaladd";
    }


    // we use PostMapping to avoid details become part of the url
    @PostMapping("createAnimal")
    public String createAnimal(@ModelAttribute("animal") Animal animal) {
        animalService.createAnimal(animal);
        return "redirect:allAnimalsBS";
    }

}
