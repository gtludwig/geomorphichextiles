package com.gusludwig.geomorphichextiles.controller.app;

import com.gusludwig.geomorphichextiles.persistence.model.ContactPointType;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.FaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import springfox.documentation.annotations.ApiIgnore;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@ApiIgnore
@Controller
@RequestMapping(value = "/faces")
public class FaceController {

    private ApplicationContext applicationContext;

    private FaceService faceService;

    private String lastAction;

    private String buildLastAction(String message, Object[] params) {
        return applicationContext.getMessage(message, params, new Locale("en", "IE"));
    }

    @Autowired
    public FaceController(ApplicationContext applicationContext, FaceService faceService) {
        this.applicationContext = applicationContext;
        this.faceService = faceService;
    }

    @GetMapping(value = "/list")
    public String listFaces(ModelMap modelMap) {
        List<Face> pojoList = this.faceService.findAll();

        if (pojoList.isEmpty()) {
            pojoList = new ArrayList<>();
        }

        modelMap.addAttribute("pojoList", pojoList);
        modelMap.addAttribute("face", new Face());
        return "faces";
    }

    @PostMapping(value = "/create")
    public String createFace(ModelMap modelMap,
                             @ModelAttribute(value = "face") Face uiFace,
                             Errors errors,
                             final RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                log.error("error" + error.getObjectName());
            }
            return "redirect:list";
        }
        lastAction = buildLastAction("createFail", new Object[]{"face", uiFace.toString()});
        try {

            Face face = faceService.create(buildContactPointsFromUI(uiFace)).get();

            lastAction = buildLastAction("createSuccess", new Object[]{"face", face.getId()});

        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            log.error(e.toString());
        }
        log.info(lastAction);
        redirectAttributes.addFlashAttribute("lastAction", lastAction);
        return "redirect:list";
    }

    @SuppressWarnings("Duplicates")
    @PostMapping(value = "/edit")
    public String editCharacter(ModelMap modelMap,
                                @ModelAttribute(value = "face") Face uiFace,
                                Errors errors,
                                final RedirectAttributes redirectAttributes) {
        if (errors.hasErrors()) {
            for (ObjectError error : errors.getAllErrors()) {
                log.error(error.getObjectName());
            }
            return "redirect:list";
        }
        Object[] params = new Object[] {"face", uiFace.getId()};
        lastAction = buildLastAction("editFail", params);
        try {
            faceService.update(uiFace.getId(), buildContactPointsFromUI(uiFace));
            lastAction = buildLastAction("editSuccess", params);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            log.error(e.toString());
        }
        log.info(lastAction);
        redirectAttributes.addFlashAttribute("lastAction", lastAction);
        return "redirect:list";
    }

    @GetMapping(value = "/delete")
    public String deleteFace(ModelMap modelMap,
                             @RequestParam(value = "faceId") String faceId,
                             final RedirectAttributes redirectAttributes) {
        Object[] params = new Object[] {"faceId", faceId};
        lastAction = buildLastAction("removeFail", params);
        try {
            faceService.remove(faceId);
            lastAction = buildLastAction("removeSuccess", params);
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
            log.error(e.toString());
        }
        log.info(lastAction);
        redirectAttributes.addFlashAttribute("lastAction", lastAction);
        return "redirect:list";
    }

    @SuppressWarnings("Duplicates")
    private ContactPointType[] buildContactPointsFromUI(Face uiFace) {

        ContactPointType[] contactPointTypes = new ContactPointType[13];
        contactPointTypes[0] = uiFace.getPointZero();
        contactPointTypes[1] = uiFace.getPointOne();
        contactPointTypes[2] = uiFace.getPointTwo();
        contactPointTypes[3] = uiFace.getPointThree();
        contactPointTypes[4] = uiFace.getPointFour();
        contactPointTypes[5] = uiFace.getPointFive();
        contactPointTypes[6] = uiFace.getPointSix();
        contactPointTypes[7] = uiFace.getPointSeven();
        contactPointTypes[8] = uiFace.getPointEight();
        contactPointTypes[9] = uiFace.getPointNine();
        contactPointTypes[10] = uiFace.getPointTen();
        contactPointTypes[11] = uiFace.getPointEleven();
        contactPointTypes[12] = uiFace.getPointTwelve();

        return contactPointTypes;

    }
}
