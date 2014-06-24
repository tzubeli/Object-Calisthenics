package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.collections.ListWrapper;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by atzubeli on 6/16/14.
 */
public class ApplicationsList implements ListWrapper<JobApplication> {

    ArrayList<JobApplication> applications = new ArrayList<>();

    public ApplicationsList(){

    }

    public ApplicationsList(ArrayList<JobApplication> applications){

        this.applications = applications;

    }


    public void addApplication(JobApplication jobApplication){

        applications.add(jobApplication);

    }

    public void removeApplication(JobApplication jobApplication){

        applications.remove(jobApplication);
    }

    public Collection<JobApplication> readAll(){

        return applications;
    }

    public ArrayList<JobApplication> getByDate(LocalDate date){

        ArrayList<JobApplication> listByDate = new ArrayList<>();

        for (JobApplication application : applications)

            if (application.isDate(date)) listByDate.add(application);

        return listByDate;
    }


    public ArrayList<JobApplication> getCollection() {

        return applications;
    }


    public int getSize() {

        return applications.size();
    }
}
