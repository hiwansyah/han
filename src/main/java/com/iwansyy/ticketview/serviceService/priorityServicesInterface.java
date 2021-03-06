package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Priority;

import java.util.List;

public interface priorityServicesInterface {
    void save(Priority priority);
    List<Priority> getAllPriority();
    Priority getPriorityById(String id);
    void update(Priority priority);
    void delete(Priority priority);
    void deleteById(String id);
}
