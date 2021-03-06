package com.iwansyy.ticketview.serviceService;

import com.iwansyy.ticketview.entity.Issue;

import java.util.List;

public interface issueServiceInterface {
    void save(Issue issue);
    List<Issue> getAllIssue();
    Issue getIssueById(String id);
    void update(Issue issue);
    void delete(Issue issue);
    void deleteById(String id);
}
