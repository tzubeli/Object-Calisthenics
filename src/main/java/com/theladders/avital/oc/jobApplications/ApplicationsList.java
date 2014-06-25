package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.collections.CollectionPrinter;
import com.theladders.avital.oc.collections.CollectionWrapper;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by atzubeli on 6/16/14.
 */
public class ApplicationsList implements CollectionWrapper<JobApplication> {

    List<JobApplication> applications = new ArrayList<>();  // TODO list

    public ApplicationsList(){

    }

    public ApplicationsList(List<JobApplication> applications){

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

    public ArrayList<JobApplication> addApplicationsHavingDateOf(LocalDate date, ArrayList<JobApplication> resultList){

        for (JobApplication application : applications)

            if (application.hasDateOf(date)) resultList.add(application);

        return resultList;

    }

    public ApplicationsList filteredByDate(LocalDate date) {

        List<JobApplication> filteredApplications = new ArrayList<>();

        for (JobApplication application : applications)

            if (application.hasDateOf(date)) filteredApplications.add(application);

        return new ApplicationsList(filteredApplications);

    }

    public ApplicationsList combinedWith(ApplicationsList filteredApplications){

        List<JobApplication> combined = new ArrayList<>(applications);

        combined.addAll(filteredApplications.applications);

        return new ApplicationsList(combined);
    }

    public void printCollection(CollectionPrinter printer){

        printer.print(applications);
    }


    public int getSize() {

        return applications.size();
    }
}
