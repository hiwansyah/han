package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Role;

import java.util.List;

public interface roleServiceInterface {
    void save(Role role);
    List<Role> getAllRole();
    Role getRoleById(String id);
    void update(Role role);
    void delete(Role role);
    void deleteById(String id);
}
