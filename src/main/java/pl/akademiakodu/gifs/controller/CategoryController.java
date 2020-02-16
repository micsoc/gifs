package pl.akademiakodu.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.akademiakodu.gifs.model.Category;
import pl.akademiakodu.gifs.model.Gif;
import pl.akademiakodu.gifs.repository.CategoryRepository;
import pl.akademiakodu.gifs.repository.GifRepository;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    GifRepository gifRepository;

    @GetMapping("/categories")
    public String categories(ModelMap modelMap) {

        modelMap.put("categories", categoryRepository.getCategories());
        return "categories";
    }

    @GetMapping("/category/{id}")
    public String gifsCategory(@PathVariable int id, ModelMap modelMap) {

        Category picked = categoryRepository.findById(id);

        modelMap.put("category", picked);

        List<Gif> gifsInCategory = gifRepository.findByCategoryId(id);
        modelMap.put("gifs", gifsInCategory);

        return "category";

    }
}
