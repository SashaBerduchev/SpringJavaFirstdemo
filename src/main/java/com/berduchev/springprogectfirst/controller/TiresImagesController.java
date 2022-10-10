package com.berduchev.springprogectfirst.controller;


import com.berduchev.springprogectfirst.model.CarImage;
import com.berduchev.springprogectfirst.model.TiresImages;
import com.berduchev.springprogectfirst.services.TireImageService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("tireimg")
public class TiresImagesController {

    private final TireImageService imageService;

    private String post;
    // Получить локальный IP
    private String host;
    // Корневой путь к хранилищу изображений
    private String rootPath = "D:";
    // Картинка хранится в подкаталоге в корневом каталоге
    private String sonPath = "/img/";
    // Получить ссылку на изображение
    private String imgPath;

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    public TiresImagesController(TireImageService imageService) {
        this.imageService = imageService;
    }


    @GetMapping("/getimg")
    public byte[] getImg(@RequestParam("name") String brend, Model model) throws UnsupportedEncodingException {
        List<TiresImages> images = imageService.getAllTireImages();
        TiresImages image = new TiresImages();
        for (int i=0; i< images.size(); i++){
            if(Objects.equals(images.get(i).getName(), brend)){
                image = images.get(i);
            }
        }
        System.out.println(image);
        Base64 item  = new Base64();
        byte[] encodeBase64 = item.encode(image.getImage());
        return encodeBase64;
    }
}
