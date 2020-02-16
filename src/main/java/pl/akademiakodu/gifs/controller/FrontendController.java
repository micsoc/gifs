package pl.akademiakodu.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.akademiakodu.gifs.model.Gif;
import pl.akademiakodu.gifs.repository.GifRepository;

import java.awt.image.RGBImageFilter;
import java.util.ArrayList;
import java.util.List;

@Controller
public class FrontendController {


    @Autowired
        GifRepository gifRepository;

    @GetMapping("/")
    private String cheer(ModelMap modelMap) {
        List<Gif> gifList = gifRepository.getGifs();
        modelMap.put("gifs", gifList);
        return "home";
    }


    @GetMapping("/favorites")
    public String favoriteGifs(ModelMap modelMap) {
        modelMap.put("gifs", gifRepository.getFavoriteGifs());
        return "favorites";
    }

    @ResponseBody
    @GetMapping("/getnames")
    private String gifNames() {

        return gifRepository.getGifNames();
    }

    @GetMapping("/gif/{name}")
    public String getGifByName(ModelMap modelMap, @PathVariable String name) {
        modelMap.put("gif", gifRepository.getGifByName(name));
        return "gif-details";
    }
}
