package com.iwansyy.ticketview.repository;

import com.iwansyy.ticketview.entity.Status;
import org.springframework.data.repository.CrudRepository;

public interface statusRepository extends CrudRepository<Status, String> {

}
