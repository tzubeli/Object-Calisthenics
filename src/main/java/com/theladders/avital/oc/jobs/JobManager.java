package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.print.AggregateCount;
import com.theladders.avital.oc.print.AggregateCountPrinter;
import com.theladders.avital.oc.print.ApplicationsPrinter;
import com.theladders.avital.oc.print.ListPrinter;
import com.theladders.avital.oc.user.Employer;
import com.theladders.avital.oc.user.Name;
import org.joda.time.LocalDate;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    private Jobs jobs;


    public JobManager(Jobs jobsToApplications){

        this.jobs = jobsToApplications;

    }

    public void createEmployerKey(Employer employer){

        jobs.createEmployer(employer);
    }

    public Job postATSJob(Employer employer, Name name){

        Job job = new ATSJob(employer, name);

        jobs.addJob(employer, job);

        return job;

    }

    public Job postJReqJob(Employer employer, Name name){

        Job job = new JReqJob(employer, name);

        jobs.addJob(employer, job);

        return job;

    }

    public void addApplication(Job job, JobApplication application){

        jobs.addApplication(job, application);

    }

    public void  getPostedJobs(Employer employer, ListPrinter printer){

         jobs.getAllJobsByEmployer(employer, printer);
    }

    public void getAllApplications(ApplicationsPrinter printer){

        jobs.getAllApplications(printer);
    }

    public void getByDate(LocalDate date, ApplicationsPrinter printer){

        jobs.getByDate(date, printer);
    }

    public void getApplicationsByEmployer(Employer employer, ApplicationsPrinter printer){

       jobs.getAllApplicationsByEmployer(employer, printer);

    }

    public void getApplicationsByJob(Employer employer, Job job, ApplicationsPrinter printer){

        jobs.getByJob(employer, job, printer);

    }

    public void getApplicationsByJobAndDate(Employer employer, Job job, LocalDate date, ApplicationsPrinter printer){

        jobs.getByJobAndDate(employer, job, date, printer);

    }

    public void getApplicationsByDate(Employer employer, LocalDate date, ApplicationsPrinter printer){

        jobs.getByDateAndEmployer(employer, date, printer);

    }

    public void getApplicationCountByEmployerAndJob(AggregateCountPrinter printer){

        jobs.getApplicationCountByEmployerAndJob(printer);
    }

    public int getNumberOfApplications(){

        return jobs.numberOfApplications();
    }


}
