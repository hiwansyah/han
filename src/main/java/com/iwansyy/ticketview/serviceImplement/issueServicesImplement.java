package com.iwansyy.ticketview.serviceImplement;

import com.iwansyy.ticketview.entity.Employee;
import com.iwansyy.ticketview.entity.Issue;
import com.iwansyy.ticketview.repository.issueRepository;
import com.iwansyy.ticketview.serviceService.issueServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
public class issueServicesImplement implements issueServiceInterface {

    @Autowired
    private issueRepository repo;

    @Override
    public void save(Issue issue) {
        repo.save(issue);
    }

    @Override
    public List<Issue> getAllIssue() {
        return (List<Issue>) repo.findAll();
    }

    @Override
    public Issue getIssueById(String id) {
        Optional<Issue> optional = repo.findById(id);
        Issue issue = null;
        if(optional.isPresent()){
            issue = optional.get();
        }else{
            throw new RuntimeException("Employee not foun in id : "+id);
        }
        return issue;
    }

    @Override
    public void update(Issue issue) {
        repo.save(issue);
    }

    @Override
    public void delete(Issue issue) {
        repo.delete(issue);
    }

    @Override
    public void deleteById(String id) {
        repo.deleteById(id);
    }
}
