package com.theladders.avital.oc.jobApplications;

import com.theladders.avital.oc.print.ApplicationsPrinter;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by atzubeli on 6/16/14.
 */
public class ApplicationsList {

    private List<JobApplication> applications = new ArrayList<>();

    public ApplicationsList(){

    }

    private ApplicationsList(List<JobApplication> applications){

        this.applications = applications;

    }

    public void addApplication(JobApplication jobApplication){

        applications.add(jobApplication);

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


    public void printAppList(ApplicationsPrinter printer){

        printer.createHeader();

        for (JobApplication application : applications){

            application.print(printer);
            printer.clear();
        }

        printer.close();

    }

    public int size() {

        return applications.size();
    }
}
