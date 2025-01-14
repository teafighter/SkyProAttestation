package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class DepartureBeforeCurrentTimeFilter implements Filter {
    @Override
    public List<Flight> checkFilter(List<Flight> flightList) {
        //Вылет до текущего момента времени.
        LocalDateTime currentTime = LocalDateTime.now();
        return flightList.stream()
                .filter(flight -> flight.getSegments().stream()
                        .allMatch(segment -> segment.getDepartureDate().isAfter(currentTime)))
                .collect(Collectors.toList());
    }
}
