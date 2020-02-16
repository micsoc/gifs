package pl.akademiakodu.gifs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

    @ResponseBody
    @GetMapping("/")
    private String cheer() {
        return "hello";
    }
    @ResponseBody
    @GetMapping("/getnames")
    private String gifNames() {
        return gifRepository.getGifNames();
    }
}
