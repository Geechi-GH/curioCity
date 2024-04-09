package com.techelevator.dao;

import com.techelevator.model.Landmark;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class JdbcLandmarkDaoTests extends BaseDaoTests{

    private static final Landmark TEST_LANDMARK_1 = new Landmark(1,"Test Landmark 1", "Test Description 1", new Time(9,0,0), new Time(17,0,0), new Time(10,0,0), new Time(16,0,0), "Test Category 1", 1, 0, 0, "../assets/CurioCity.png");
    private static final Landmark TEST_LANDMARK_2 = new Landmark(2,"Test Landmark 2", "Test Description 2", new Time(9,0,0), new Time(17,0,0), new Time(10,0,0), new Time(16,0,0), "Test Category 1", 1, 0, 0, "../assets/CurioCity.png");
    private static final Landmark TEST_LANDMARK_3 = new Landmark(3,"Test Landmark 3", "Test Description 3", new Time(10,30,0), new Time(18,30,0), new Time(12,0,0), new Time(17,0,0), "Test Category 2", 1, 0, 0, "../assets/CurioCity.png");

    private JdbcLandmarkDao sut;
@Before
    public void setup() {
    sut = new JdbcLandmarkDao(dataSource);
}

@Test
    public void get_all_landmarks_works() {
    //arrange
    List <Landmark> testList = new ArrayList<>();
    //act
    testList = sut.getAllLandmarks();

    //assert
    Assert.assertEquals(3,testList.size());
    assertLandmarksEqual(testList.get(0),TEST_LANDMARK_1);
    assertLandmarksEqual(testList.get(1), TEST_LANDMARK_2);
}

public void assertLandmarksEqual(Landmark actual, Landmark expected) {
    Assert.assertEquals(expected.getId(), actual.getId());
    Assert.assertEquals(expected.getName(), actual.getName());
    Assert.assertEquals(expected.getDescription(), actual.getDescription());
    Assert.assertEquals(expected.getWeekdayOpen(), actual.getWeekdayOpen());
    Assert.assertEquals(expected.getWeekdayClose(), actual.getWeekdayClose());
    Assert.assertEquals(expected.getWeekendOpen(), actual.getWeekendOpen());
    Assert.assertEquals(expected.getWeekendClose(), actual.getWeekendClose());
    Assert.assertEquals(expected.getCategory(), actual.getCategory());
    Assert.assertEquals(expected.getCityID(), actual.getCityID());
    Assert.assertEquals(expected.getLikeCount(), actual.getLikeCount());
    Assert.assertEquals(expected.getDislikeCount(), actual.getDislikeCount());

}

}


