package com.gusludwig.geomorphichextiles.controller.api;

import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.FaceService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping(value = "/api/faces")
public class FaceRestController {

    private FaceService faceService;

    @Autowired
    public FaceRestController(FaceService faceService) {
        this.faceService = faceService;
    }

    @GetMapping(value = "/")
    @ApiOperation(value = "Pageable return of existing faces.")
    public ResponseEntity<List<Face>> getAllFaces() {
        List<Face> faceList = this.faceService.findAll();

        if(faceList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.ok(faceList);
    }

    @GetMapping(value = "/{faceId}")
    @ApiOperation(value = "Returns a detailed response of the face.")
    public ResponseEntity<Face> getOneFace(
            @PathVariable(name = "faceId") String faceId) {
        Optional<Face> faceOptional = this.faceService.findById(faceId);
        if (!faceOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(faceOptional.get());
    }

    @GetMapping(value = "/createOneRandomFace")
    @ApiOperation(value = "Creates a new face with random types of contact points")
    public ResponseEntity<Optional<Face>> createRandomFace() {
        return ResponseEntity.ok(this.faceService.createOneRandomFace());
    }

    @GetMapping(value = "/createRandomFaces/{numberOfFaces}")
    @ApiOperation(value = "Creates a new face with random types of contact points")
    public ResponseEntity<Optional<List<Face>>> createRandomFaces(
            @PathVariable(value = "numberOfFaces") int numberOfFaces) {
        return ResponseEntity.ok(this.faceService.createRandomFaces(numberOfFaces));
    }

    @DeleteMapping(value = "/delete/{faceId}")
    @ApiOperation(value = "Removes a single entity from the database.")
    public ResponseEntity deleteOneFace(
            @PathVariable(name = "faceId") String faceId) {
        this.faceService.remove(faceId);
        return ResponseEntity.ok(faceId);
    }
}
