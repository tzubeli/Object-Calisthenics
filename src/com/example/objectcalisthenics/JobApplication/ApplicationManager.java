package com.example.objectcalisthenics.JobApplication;


import java.util.Collection;

/**
 * Created by atzubeli on 5/28/14.
 */
public class ApplicationManager {


    Collection<JobApplication> applications;


    public ApplicationManager(Collection<JobApplication> applications) {

        this.applications = applications;
    }

    public void apply(JobApplication application){

        applications.add(application);

    }

}
