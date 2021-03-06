package com.iwansyy.ticketview.repository;

import com.iwansyy.ticketview.entity.Issue;
import org.springframework.data.repository.CrudRepository;

public interface issueRepository extends CrudRepository<Issue, String> {

}
