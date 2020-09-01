package com.gusludwig.geomorphichextiles.controller.app;

import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.persistence.model.Tile;
import com.gusludwig.geomorphichextiles.service.generic.TileService;
import com.gusludwig.geomorphichextiles.service.impl.FaceServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@ApiIgnore
@Controller
@RequestMapping(value = "/tiles")
public class TileController {

    private ApplicationContext applicationContext;

    private TileService tileService;

    private String lastAction;

    private String buildLastAction(String message, Object[] params) {
        return applicationContext.getMessage(message, params, new Locale("en", "IE"));
    }

    @Autowired
    public TileController(ApplicationContext applicationContext, TileService tileService) {
        this.applicationContext = applicationContext;
        this.tileService = tileService;
    }

    @GetMapping(value = "/list")
    public String listTiles(ModelMap modelMap) {
        List<Tile> pojoList = this.tileService.findAll();

        if(pojoList.isEmpty()) {
            pojoList = new ArrayList<>();
        }

        modelMap.addAttribute("pojoList", pojoList);
        modelMap.addAttribute("tile", new Tile());
        return "tiles";
    }

}
