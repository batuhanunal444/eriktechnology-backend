package com.batuhan.stationer.rest;

import com.batuhan.stationer.entities.Category;
import com.batuhan.stationer.entities.SubCategory;
import com.batuhan.stationer.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SubCategoryController {
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    public SubCategoryController(SubCategoryRepository subCategoryRepository){
        this.subCategoryRepository = subCategoryRepository;
    }
    @GetMapping("/subcategories")
    public List<SubCategory> getSubCategories(){
        return subCategoryRepository.findAll();
    }
    @GetMapping("/subcategories/{id}")
    public ResponseEntity<SubCategory> getSubCategory(@PathVariable int id){
        Optional<SubCategory> result = subCategoryRepository.findById(id);
        if (result.isPresent()){
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @PostMapping("/subcategories")
    public SubCategory addCategory(@RequestBody SubCategory subCategory){
        return subCategoryRepository.save(subCategory);
    }

    @PutMapping("/subcategories/{id}")
    public ResponseEntity<SubCategory> updateCategory (@PathVariable int id, @RequestBody SubCategory subCategory){
        Optional<SubCategory> categoryData = subCategoryRepository.findById(id);
        if(categoryData.isPresent()) {
            return new ResponseEntity<>(subCategoryRepository.save(subCategory),HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/subcategories/{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable int id){
        subCategoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
