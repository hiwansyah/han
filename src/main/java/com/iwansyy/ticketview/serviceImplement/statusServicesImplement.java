package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Status;
import com.iwansyy.ticketview.repository.statusRepository;
import com.iwansyy.ticketview.serviceService.statusServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class statusServicesImplement implements statusServiceInterface {

    @Autowired
    private statusRepository repo;

    @Override
    public void save(Status status) {
        repo.save(status);
    }

    @Override
    public List<Status> getAllStatus() {
        return (List<Status>) repo.findAll();
    }

    @Override
    public Status getEmployeById(String id) {
        Optional<Status> optional = repo.findById(id);
        Status status = null;
        if (optional.isPresent()) {
            status = optional.get();
        } else {
            throw new RuntimeException("Employee not foun in id : " + id);
        }
        return status;
    }

    @Override
    public void update(Status status) {
        repo.save(status);
    }

    @Override
    public void delete(Status status) {
        repo.delete(status);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
