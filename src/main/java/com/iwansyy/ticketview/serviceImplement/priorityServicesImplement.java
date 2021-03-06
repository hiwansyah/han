package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Priority;
import com.iwansyy.ticketview.repository.priorityRepository;
import com.iwansyy.ticketview.serviceService.priorityServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class priorityServicesImplement implements priorityServicesInterface {

    @Autowired
    private priorityRepository repo;

    @Override
    public void save(Priority priority) {
        repo.save(priority);
    }

    @Override
    public List<Priority> getAllPriority() {
        return (List<Priority>) repo.findAll();
    }

    @Override
    public Priority getPriorityById(String id) {
        Optional<Priority> optional = repo.findById(id);
        Priority priority = null;
        if(optional.isPresent()){
            priority = optional.get();
        }else{
            throw new RuntimeException("Employee not foun in id : "+id);
        }
        return priority;
    }

    @Override
    public void update(Priority priority) {
        repo.save(priority);
    }

    @Override
    public void delete(Priority priority) {
        repo.delete(priority);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
