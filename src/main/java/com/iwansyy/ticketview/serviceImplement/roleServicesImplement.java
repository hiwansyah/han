package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Role;
import com.iwansyy.ticketview.repository.roleRepository;
import com.iwansyy.ticketview.serviceService.roleServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class roleServicesImplement implements roleServiceInterface {

    @Autowired
    private roleRepository repo;

    @Override
    public void save(Role role) {
        repo.save(role);
    }

    @Override
    public List<Role> getAllRole() {
        return (List<Role>) repo.findAll();
    }

    @Override
    public Role getRoleById(String id) {
        Optional<Role> optional = repo.findById(id);
        Role role = null;
        if(optional.isPresent()){
            role = optional.get();
        }else{
            throw new RuntimeException("Employee not foun in id : "+id);
        }
        return role;
    }

    @Override
    public void update(Role role) {
        repo.save(role);
    }

    @Override
    public void delete(Role role) {
        repo.delete(role);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
