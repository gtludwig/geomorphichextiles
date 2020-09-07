package com.gusludwig.geomorphichextiles.service.impl;

import com.gusludwig.geomorphichextiles.persistence.dao.FaceRepository;
import com.gusludwig.geomorphichextiles.persistence.model.ContactPointType;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.FaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Slf4j
@Service(value = "faceService")
public class FaceServiceImpl implements FaceService {

    private FaceRepository faceRepository;

    @Autowired
    public FaceServiceImpl(FaceRepository faceRepository) {
        this.faceRepository = faceRepository;
    }

    @Override
    public Optional<Face> create(ContactPointType[] contactPointTypes) {
        if(!validateFace(contactPointTypes)) {
            throw new IllegalArgumentException("Number of contact points MUST be 13.");
        }
        return this.save(this.updateFace(new Face(), contactPointTypes));
    }

    @Override
    @SuppressWarnings("Duplicates")
    public boolean validateFace(Face face) {
        ContactPointType[] contactPointTypes = new ContactPointType[13];
        contactPointTypes[0] = face.getPointZero();
        contactPointTypes[1] = face.getPointOne();
        contactPointTypes[2] = face.getPointTwo();
        contactPointTypes[3] = face.getPointThree();
        contactPointTypes[4] = face.getPointFour();
        contactPointTypes[5] = face.getPointFive();
        contactPointTypes[6] = face.getPointSix();
        contactPointTypes[7] = face.getPointSeven();
        contactPointTypes[8] = face.getPointEight();
        contactPointTypes[9] = face.getPointNine();
        contactPointTypes[10] = face.getPointTen();
        contactPointTypes[11] = face.getPointEleven();
        contactPointTypes[11] = face.getPointTwelve();

        return validateFace(contactPointTypes);
    }

    private boolean validateFace(ContactPointType[] contactPointTypes) {
        return contactPointTypes.length == 13;
    }

    @Override
    public Optional<Face> update(String id, ContactPointType[] contactPointTypes) {
        Optional<Face> faceOptional = this.save(this.updateFace((Face) this.findById(id).get(), contactPointTypes));
        log.info(String.format("Successfully updated entity with id ' %s ' ", faceOptional.get().getId()));
        return faceOptional;
    }

    @Override
    public Optional<Face> createOneRandomFace() {

        ContactPointType[] contactPointTypes = new ContactPointType[13];
        Random random = new Random();

        for (int i = 0; i < contactPointTypes.length; i++) {
            contactPointTypes[i] = getRandomContactPointType(random);
        }

        return this.save(this.updateFace(new Face(), contactPointTypes));
    }

    private ContactPointType getRandomContactPointType(Random random) {
        return ContactPointType.values()[random.nextInt(ContactPointType.values().length)];
    }

    @Override
    public Optional<List<Face>> createRandomFaces(int numberOfFaces) {

        List<Face> faceList = new ArrayList<>();

        for (int i = 0; i < numberOfFaces; i++) {
            faceList.add(createOneRandomFace().get());
        }

        return Optional.of(faceList);
    }

    @Override
    @SuppressWarnings("Duplicates")
    public Face reverseFace(Face face) {
        ContactPointType[] contactPointTypes = new ContactPointType[13];
        contactPointTypes[0] = face.getPointZero();
        contactPointTypes[1] = face.getPointOne();
        contactPointTypes[2] = face.getPointTwo();
        contactPointTypes[3] = face.getPointThree();
        contactPointTypes[4] = face.getPointFour();
        contactPointTypes[5] = face.getPointFive();
        contactPointTypes[6] = face.getPointSix();
        contactPointTypes[7] = face.getPointSeven();
        contactPointTypes[8] = face.getPointEight();
        contactPointTypes[9] = face.getPointNine();
        contactPointTypes[10] = face.getPointTen();
        contactPointTypes[11] = face.getPointEleven();
        contactPointTypes[12] = face.getPointTwelve();
        Collections.reverse(Arrays.asList(contactPointTypes));
        return updateFace(new Face(), contactPointTypes);
    }

    private Face updateFace(Face face, ContactPointType[] contactPointTypes) {
        face.setPointZero(contactPointTypes[0]);
        face.setPointOne(contactPointTypes[1]);
        face.setPointTwo(contactPointTypes[2]);
        face.setPointThree(contactPointTypes[3]);
        face.setPointFour(contactPointTypes[4]);
        face.setPointFive(contactPointTypes[5]);
        face.setPointSix(contactPointTypes[6]);
        face.setPointSeven(contactPointTypes[7]);
        face.setPointEight(contactPointTypes[8]);
        face.setPointNine(contactPointTypes[9]);
        face.setPointTen(contactPointTypes[10]);
        face.setPointEleven(contactPointTypes[11]);
        face.setPointTwelve(contactPointTypes[12]);

        return face;
    }

    @Override
    @Transactional
    public Optional<Face> findById(String id) {
        return this.faceRepository.findById(id);
    }

    @Override
    @Transactional
    public Optional<Face> save(Face pojo) {
        Face face = this.faceRepository.save(pojo);
        if (pojo.getId() == null || pojo.getId().isEmpty()) {
            log.info(String.format("Successfully created entity with id ' %s ' ", face.getId()));
        } else {
            log.info(String.format("Successfully updated entity with id ' %s ' ", pojo.getId()));
        }
        return Optional.of(face);
    }

    @Override
    @Transactional
    public void remove(String id) {
        Face face = this.faceRepository.getOne(id);
        this.faceRepository.delete(face);
        log.info(String.format("Successfully removed entity with id ' %s ' ", face.getId()));
    }

    @Override
    @Transactional
    public List<Face> findAll() {
        return this.faceRepository.findAll();
    }
}