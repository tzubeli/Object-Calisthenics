package main.java.JobApplication;

import main.java.Jobs.Job;
import main.java.User.Employer;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by atzubeli on 6/23/14.
 */
public class SuccessAndFailure {

    private HashMap<Job, Employer> success = new HashMap<>();

    private HashMap<Job, Employer> failure = new HashMap<>();

    public void addSuccess(Job job, Employer employer){

        success.put(job, employer);

    }

    public void addFailure(Job job, Employer employer){

        failure.put(job, employer);

    }

    public Collection viewSuccess(){

        return success.values();
    }

    public Collection viewFailure(){

        return failure.values();

    }

}
