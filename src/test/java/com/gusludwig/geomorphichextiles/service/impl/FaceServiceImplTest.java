package com.gusludwig.geomorphichextiles.service.impl;

import com.gusludwig.geomorphichextiles.SpringTestConfiguration;
import com.gusludwig.geomorphichextiles.persistence.dao.FaceRepository;
import com.gusludwig.geomorphichextiles.persistence.model.ContactPointType;
import com.gusludwig.geomorphichextiles.persistence.model.Face;
import com.gusludwig.geomorphichextiles.service.FaceService;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Random;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { SpringTestConfiguration.class })
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FaceServiceImplTest {

//    @Mock
//    private FaceRepository faceRepository;

//    @InjectMocks
//    private FaceService faceService;

    private Face face;

    private Random random;

    @BeforeAll
    void setUp() {
        MockitoAnnotations.initMocks(this);
        random = new Random();

        buildRandomFace();
    }

    private Face buildRandomFace() {
//        random = new Random();

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

    private ContactPointType getRandomContactPointType() {
        return ContactPointType.values()[random.nextInt(ContactPointType.values().length)];
    }

//    @Test
//    void create() {
//    }

    @Test
    void assertBlahTrue() {
        Assert.assertTrue(true);
    }

//    @Test
//    void validateFace() {
//        face = buildRandomFace();
//        Mockito.when(faceService.validateFace(face)).thenReturn(true);
//        Assert.assertTrue(faceService.validateFace(face));
//    }

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