package com.github.ravisankarchinnam.tours.graphql.schema;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.github.ravisankarchinnam.tours.exception.AgencyNotFoundException;
import com.github.ravisankarchinnam.tours.exception.TourNotFoundException;
import com.github.ravisankarchinnam.tours.model.Agency;
import com.github.ravisankarchinnam.tours.model.Tour;
import com.github.ravisankarchinnam.tours.repository.AgencyRepository;
import com.github.ravisankarchinnam.tours.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryResolver implements GraphQLQueryResolver {

    @Autowired
    private TourRepository tourRepository;

    @Autowired
    private AgencyRepository agencyRepository;



    // allTours: [Tour]
    public List<Tour> getAllTours() {
        return tourRepository.findAll();
    }



    //tour(id: Long!): Tour
    public Tour getTour(Long id) {
        Tour tour = tourRepository.findOne(id);
        if (tour == null) {
            throw new TourNotFoundException(id);
        }
        return tour;
    }



    //allAgencies: [Agency]
    public List<Agency> getAllAgencies() {
        return agencyRepository.findAll();
    }



    //agency(id: Long!): Agency
    public Agency getAgency(Long id) {
        Agency agency = agencyRepository.findOne(id);
        if (agency == null) {
            throw new AgencyNotFoundException(id);
        }
        return agency;
    }
}
