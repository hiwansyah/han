package com.iwansyy.ticketview.serviceService;


import com.iwansyy.ticketview.entity.Division;

import java.util.List;

public interface divisionServiceInterface {
    void save(Division division);
    List<Division> getAllDivision();
    Division getDivisionById(String id);
    void update(Division division);
    void delete(Division division);
    void deleteById(String id);
}
