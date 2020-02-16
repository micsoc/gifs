package pl.akademiakodu.gifs.repository;

import org.springframework.stereotype.Repository;
import pl.akademiakodu.gifs.model.Category;

import java.util.Arrays;
import java.util.List;

@Repository
public class CategoryRepository {

    private final List<Category> ALL_CATEGORY =Arrays.asList(

            new Category(0, "funny"),
            new Category(1, "sport"),
            new Category(2, "it")
    );


    public List<Category> getCategories() {
        return ALL_CATEGORY;
    }
}
