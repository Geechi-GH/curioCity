package com.techelevator.dao;

import com.techelevator.model.Itinerary;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcItineraryDaoTests extends BaseDaoTests{


    // Test Data Set 1
    private static final Itinerary TEST_ITINERARY_1 = new Itinerary(1, "Test 1", 1, 1, Date.valueOf(LocalDate.of(2024, 5, 15)), Date.valueOf(LocalDate.of(2024, 4, 10)));
    private static final Itinerary TEST_ITINERARY_2 = new Itinerary(2, "Test 2", 1, 1, Date.valueOf(LocalDate.of(2024, 6, 20)), Date.valueOf(LocalDate.of(2024, 4, 10)) );
    private static final Itinerary TEST_ITINERARY_3 = new Itinerary(3, "Test 3", 1, 1, Date.valueOf(LocalDate.of(2024, 5, 15)), Date.valueOf(LocalDate.of(2024, 4, 10)));


    private JdbcItineraryDao sut;
    @Before
    public void setup() {
        sut = new JdbcItineraryDao(dataSource);
    }

    @Test
    public void get_all_itineraries_from_user1() {
        // arrange
        List<Itinerary> myList = new ArrayList<>();
        // act
        myList = sut.getAllItineraries(TEST_ITINERARY_1.getUserId());
        // assert
        Assert.assertEquals(2, myList.size());
        assertItinerariesEqual(TEST_ITINERARY_1, myList.get(0));
        assertItinerariesEqual(TEST_ITINERARY_2, myList.get(1));

    }

    public void assertItinerariesEqual(Itinerary expected, Itinerary actual) {
        Assert.assertEquals(expected.getItineraryId(), actual.getItineraryId());
        Assert.assertEquals(expected.getTitle(), actual.getTitle());
        Assert.assertEquals(expected.getCityId(), actual.getCityId());
        Assert.assertEquals(expected.getUserId(), actual.getUserId());
        Assert.assertEquals(expected.getDateOfTravel(), actual.getDateOfTravel());
        Assert.assertEquals(expected.getDateCreated(), actual.getDateCreated());
    }
}
