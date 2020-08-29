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

@Service
@Slf4j
public class FaceServiceImpl implements FaceService {

    private FaceRepository faceRepository;

    @Autowired
    public FaceServiceImpl(FaceRepository faceRepository) {
        this.faceRepository = faceRepository;
    }

    @Override
    public Face create(ContactPoint[] contactPoints) {
        if(validateFace(contactPoints)) {
            throw new IllegalArgumentException("Number of contact points MUST be 13.");
        }
        return this.save(this.updateFace(new Face(), contactPoints));
    }

    @Override
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
        if (contactPoints.length == 13) {
            for (int i =0; i < contactPoints.length; i++) {
                if (ContactPoint.fromString(contactPoints[i].value()).equals(ContactPoint.UNSUPPORTED)) {
                    break;
                }
            }
            return true;
        }
        return false;
    }


    @Override
    public Face update(String id, ContactPoint[] contactPoints) {
        Face face = this.save(this.updateFace(this.findById(id), contactPoints));
        log.info(String.format("Successfully updated entity with id ' %s ' ", face.getId()));
        return face;
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
    public Face findById(String id) {
        return this.faceRepository.getOne(id);
    }

    @Override
    @Transactional
    public Face save(Face pojo) {
        if (pojo.getId() == null || pojo.getId().isEmpty()) {
            Face face = this.faceRepository.save(pojo);
            log.info(String.format("Successfully created entity with id ' %s ' ", face.getId()));
        } else {
            log.info(String.format("Successfully updated entity with id ' %s ' ", pojo.getId()));
        }
        Face face = this.faceRepository.save(pojo);
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
