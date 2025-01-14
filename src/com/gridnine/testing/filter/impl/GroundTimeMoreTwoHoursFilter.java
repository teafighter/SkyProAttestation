package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;
import com.gridnine.testing.model.Segment;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class GroundTimeMoreTwoHoursFilter implements Filter {
    @Override
    public List<Flight> checkFilter(List<Flight> flightList) {
        //Перелеты, где общее время, проведённое на земле, превышает два часа
        return flightList.stream().
                filter(flight -> {
                    List<Segment> segments = flight.getSegments();
                    if (segments.size() < 2) {
                        return true;
                    }
                    long groundTime = 0;
                    for (int i = 0; i < segments.size() - 1; i++) {
                        LocalDateTime arrival = segments.get(i).getArrivalDate();
                        LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
                        groundTime += Duration.between(arrival, nextDeparture).toHours();
                    }
                    return groundTime <= 2;
                })
                .collect(Collectors.toList());
    }
}
