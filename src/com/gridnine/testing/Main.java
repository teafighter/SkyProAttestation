package com.gridnine.testing;

import com.gridnine.testing.filter.impl.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.filter.impl.GroundTimeMoreTwoHoursFilter;
import com.gridnine.testing.filter.impl.SegmentsReversedFilter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.FlightBuilder;
import com.gridnine.testing.model.Segment;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Full flight list:");
        List<Flight> testFlights = FlightBuilder.createFlights();
        System.out.println(testFlights);
        System.out.println("Departures before current time filtered:" + new DepartureBeforeCurrentTimeFilter().checkFilter(testFlights));
        System.out.println("Reversed flight segments filtered: " + new GroundTimeMoreTwoHoursFilter().checkFilter(testFlights));
        System.out.println("Ground time more than two hours filtered: " + new SegmentsReversedFilter().checkFilter(testFlights));
    }
}