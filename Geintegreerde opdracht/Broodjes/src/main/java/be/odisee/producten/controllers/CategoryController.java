package be.odisee.producten.controllers;

import be.odisee.producten.DAO.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/categorieen", produces = "application/json")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    /**
     * Returned een lijst van alle categorieen
     */
    @GetMapping("/list")
    public Object getObjectives(){
        return categoryRepository.findAll();
    }
}
