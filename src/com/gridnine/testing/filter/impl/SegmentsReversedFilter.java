package com.gridnine.testing.filter.impl;

import com.gridnine.testing.filter.Filter;
import com.gridnine.testing.model.Flight;

import java.util.List;
import java.util.stream.Collectors;

public class SegmentsReversedFilter implements Filter {
    @Override
    public List<Flight> checkFilter(List<Flight> flightList) {
        //Сегменты с датой прилёта раньше даты вылета.
        return flightList.stream().
                filter(flight -> flight.getSegments().stream().
                        allMatch(segment -> segment.getArrivalDate().isAfter(segment.getDepartureDate())))
                .collect(Collectors.toList());
    }
}