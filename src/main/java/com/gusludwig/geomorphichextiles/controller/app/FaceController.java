package com.gusludwig.geomorphichextiles.controller.app;

import com.gusludwig.geomorphichextiles.persistence.model.ContactPoint;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.impl.FaceServiceImpl;
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

@Controller
@Slf4j
@RequestMapping(value = "/faces")
@ApiIgnore
public class FaceController {

    private ApplicationContext applicationContext;

    private FaceServiceImpl faceService;

    private String lastAction;

    private String buildLastAction(String message, Object[] params) {
        return applicationContext.getMessage(message, params, new Locale("en", "IE"));
    }

    @Autowired
    public FaceController(ApplicationContext applicationContext, FaceServiceImpl faceService) {
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
    private ContactPoint[] buildContactPointsFromUI(Face uiFace) {

        ContactPoint[] contactPoints = new ContactPoint[13];
        contactPoints[0] = uiFace.getPointZero();
        contactPoints[1] = uiFace.getPointOne();
        contactPoints[2] = uiFace.getPointTwo();
        contactPoints[3] = uiFace.getPointThree();
        contactPoints[4] = uiFace.getPointFour();
        contactPoints[5] = uiFace.getPointFive();
        contactPoints[6] = uiFace.getPointSix();
        contactPoints[7] = uiFace.getPointSeven();
        contactPoints[8] = uiFace.getPointEight();
        contactPoints[9] = uiFace.getPointNine();
        contactPoints[10] = uiFace.getPointTen();
        contactPoints[11] = uiFace.getPointEleven();
        contactPoints[12] = uiFace.getPointTwelve();

        return contactPoints;

    }
}
