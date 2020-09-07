package com.gusludwig.geomorphichextiles.service.impl;

import com.gusludwig.geomorphichextiles.persistence.dao.FaceRepository;
import com.gusludwig.geomorphichextiles.persistence.model.ContactPointType;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FaceServiceImplTest {

    @Mock
    private FaceRepository faceRepository;

    @InjectMocks
    private FaceServiceImpl faceService;

    private Face face;

    private Random random;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
        random = new Random();

        buildRandomFace();
    }

    private Face buildRandomFace() {

        face = new Face();

        face.setPointZero(getRandomContactPointType());
        face.setPointOne(getRandomContactPointType());
        face.setPointTwo(getRandomContactPointType());
        face.setPointThree(getRandomContactPointType());
        face.setPointFour(getRandomContactPointType());
        face.setPointFive(getRandomContactPointType());
        face.setPointSix(getRandomContactPointType());
        face.setPointSeven(getRandomContactPointType());
        face.setPointEight(getRandomContactPointType());
        face.setPointNine(getRandomContactPointType());
        face.setPointTen(getRandomContactPointType());
        face.setPointEleven(getRandomContactPointType());
        face.setPointTwelve(getRandomContactPointType());

        return face;
    }

    private ContactPointType[] getContactPointTypeArray(Face face) {
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

        return  contactPointTypes;
    }

    private ContactPointType getRandomContactPointType() {
        return ContactPointType.values()[random.nextInt(ContactPointType.values().length)];
    }

    @Test
    void create() {
        Mockito.when(this.faceRepository.save(any())).thenReturn(face);
        Assert.assertNotNull(Optional.of(this.faceService.create(getContactPointTypeArray(face))));
    }

    @Test
    void validateFace() {
        Assert.assertTrue(this.faceService.validateFace(face));
    }

    @Test
    void createRandomFace() {
        Mockito.when(this.faceRepository.save(any())).thenReturn(face);
        Assert.assertNotNull(Optional.of(this.faceService.createOneRandomFace()));
    }

//    @Test
//    void update() {
//    }
//
//    @Test
//    void findById() {
//    }
//
//    @Test
//    void save() {
//    }
//
//    @Test
//    void remove() {
//    }
//
//    @Test
//    void findAll() {
//    }
}