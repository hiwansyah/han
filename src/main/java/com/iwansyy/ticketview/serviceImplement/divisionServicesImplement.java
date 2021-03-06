package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Division;
import com.iwansyy.ticketview.repository.divisionRepository;
import com.iwansyy.ticketview.serviceService.divisionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class divisionServicesImplement implements divisionServiceInterface {

    @Autowired
    private divisionRepository repo;

    @Override
    public void save(Division division) {
        repo.save(division);
    }

    @Override
    public List<Division> getAllDivision() {
        return (List<Division>) repo.findAll();
    }

    @Override
    public Division getDivisionById(String id) {
        Optional<Division> optional = repo.findById(id);
        Division division = null;
        if (optional.isPresent()) {
            division = optional.get();
        } else {
            throw new RuntimeException("Employee not found in id : " + id);
        }
        return division;
    }

    @Override
    public void update(Division division) {
        repo.save(division);
    }

    @Override
    public void delete(Division division) {
        repo.delete(division);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
