package com.gusludwig.geomorphichextiles.service.impl;

import com.gusludwig.geomorphichextiles.persistence.dao.FaceRepository;
import com.gusludwig.geomorphichextiles.persistence.model.ContactPoint;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.FaceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service(value = "faceService")
public class FaceServiceImpl implements FaceService {

    private FaceRepository faceRepository;

    @Autowired
    public FaceServiceImpl(FaceRepository faceRepository) {
        this.faceRepository = faceRepository;
    }

    @Override
    public Optional<Face> create(ContactPoint[] contactPoints) {
        if(!validateFace(contactPoints)) {
            throw new IllegalArgumentException("Number of contact points MUST be 13.");
        }
        return this.save(this.updateFace(new Face(), contactPoints));
    }

    @Override
    @SuppressWarnings("Duplicates")
    public boolean validateFace(Face face) {
        ContactPoint[] contactPoints = new ContactPoint[13];
        contactPoints[0] = face.getPointZero();
        contactPoints[1] = face.getPointOne();
        contactPoints[2] = face.getPointTwo();
        contactPoints[3] = face.getPointThree();
        contactPoints[4] = face.getPointFour();
        contactPoints[5] = face.getPointFive();
        contactPoints[6] = face.getPointSix();
        contactPoints[7] = face.getPointSeven();
        contactPoints[8] = face.getPointEight();
        contactPoints[9] = face.getPointNine();
        contactPoints[10] = face.getPointTen();
        contactPoints[11] = face.getPointEleven();
        contactPoints[11] = face.getPointTwelve();

        return validateFace(contactPoints);
    }

    private boolean validateFace(ContactPoint[] contactPoints) {
        return contactPoints.length == 13;
    }

    @Override
    public Optional<Face> update(String id, ContactPoint[] contactPoints) {
        Optional<Face> faceOptional = this.save(this.updateFace((Face) this.findById(id).get(), contactPoints));
        log.info(String.format("Successfully updated entity with id ' %s ' ", faceOptional.get().getId()));
        return faceOptional;
    }

    @Override
    public Optional<Face> createOneRandomFace() {

        ContactPoint[] contactPoints = new ContactPoint[13];

        for (int i = 0; i < contactPoints.length; i++) {
            contactPoints[i] = ContactPoint.getRandom();
        }

        return this.save(this.updateFace(new Face(), contactPoints));
    }

    private Face updateFace(Face face, ContactPoint[] contactPoints) {
        face.setPointZero(contactPoints[0]);
        face.setPointOne(contactPoints[1]);
        face.setPointTwo(contactPoints[2]);
        face.setPointThree(contactPoints[3]);
        face.setPointFour(contactPoints[4]);
        face.setPointFive(contactPoints[5]);
        face.setPointSix(contactPoints[6]);
        face.setPointSeven(contactPoints[7]);
        face.setPointEight(contactPoints[8]);
        face.setPointNine(contactPoints[9]);
        face.setPointTen(contactPoints[10]);
        face.setPointEleven(contactPoints[11]);
        face.setPointTwelve(contactPoints[12]);

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
        if (pojo.getId() == null || pojo.getId().isEmpty()) {
            Face face = this.faceRepository.save(pojo);
            log.info(String.format("Successfully created entity with id ' %s ' ", face.getId()));
        } else {
            log.info(String.format("Successfully updated entity with id ' %s ' ", pojo.getId()));
        }
        Optional<Face> face = Optional.of(this.faceRepository.save(pojo));
        return face;
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