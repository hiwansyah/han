package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Positions;
import com.iwansyy.ticketview.repository.positionRepository;
import com.iwansyy.ticketview.serviceService.positionServicesInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class positionServicesImplement implements positionServicesInterface {

    @Autowired
    positionRepository repo;

    @Override
    public void save(Positions positions) {
        repo.save(positions);
    }

    @Override
    public List<Positions> getAllPosition() {
        return (List<Positions>) repo.findAll();
    }

    @Override
    public Positions getPositionsById(String id) {
        Optional<Positions> optional = repo.findById(id);
        Positions positions = null;
        if(optional.isPresent()){
            positions = optional.get();
        }else{
            throw new RuntimeException("Employee not foun in id : "+id);
        }
        return positions;
    }

    @Override
    public void update(Positions positions) {
        repo.save(positions);
    }

    @Override
    public void delete(Positions positions) {
        repo.delete(positions);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
