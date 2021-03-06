package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Status;

import java.util.List;

public interface statusServiceInterface {
    void save(Status status);
    List<Status> getAllStatus();
    Status getEmployeById(String id);
    void update(Status status);
    void delete(Status status);
    void deleteById(String id);
}
