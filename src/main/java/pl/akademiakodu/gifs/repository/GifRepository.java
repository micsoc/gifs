package pl.akademiakodu.gifs.repository;

import lombok.Data;
import org.springframework.stereotype.Repository;
import pl.akademiakodu.gifs.model.Category;
import pl.akademiakodu.gifs.model.Gif;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Data
public class GifRepository {

    private static List<Gif> ALL_GIFS = Arrays.asList(
            new Gif("android-explosion", "mols", true, 1),
            new Gif("ben-and-mike", "mika", true, 2),
            new Gif("book-dominos", "mem", true, 0),
            new Gif("compiler-bot", "bot", true, 1),
            new Gif("cowboy-coder", "code", true, 1),
            new Gif("infinite-andrew", "andrew", false, 2)
    );

    public String getGifNames() {
        String result = "";

        for (Gif gif : ALL_GIFS) {
            result += gif.getName()+" ";
        }
        return result;
    }

    public List<Gif> getGifs() {
        return ALL_GIFS;
    }

    public  List<Gif> getFavoriteGifs() {
        return ALL_GIFS
                .stream()
                .filter(x -> x.getFavorite())
                .collect(Collectors.toList());
    }

    public Gif getGifByName(String name) {
        Gif gifReturn = new Gif();

        for (Gif gif : ALL_GIFS) {
            if (gif.getName().equals(name)) {
                gifReturn = gif;
            }

        }
        return gifReturn;
    }


    public List<Gif> findByCategoryId(int id) {
        return ALL_GIFS.stream().filter(x -> x.getCategoryId() == id).collect(Collectors.toList());
    }
}
