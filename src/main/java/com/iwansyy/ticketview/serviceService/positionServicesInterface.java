package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Positions;

import java.util.List;

public interface positionServicesInterface {
    void save(Positions positions);
    List<Positions> getAllPosition();
    Positions getPositionsById(String id);
    void update(Positions positions);
    void delete(Positions positions);
    void deleteById(String id);
}
