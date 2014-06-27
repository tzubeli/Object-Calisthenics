package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.user.Employer;
import org.joda.time.LocalDate;


import java.util.HashMap;
/**
 * Created by atzubeli on 6/26/14.
 */
public class Jobs {

private HashMap<Employer, JobApplications> postedJobs = new HashMap<>();


    public void createEmployerKey(Employer employer) {

        if (! postedJobs.containsKey(employer))

            postedJobs.put(employer, new JobApplications());
    }


    public void addJob(Employer employer, Job job){

       JobApplications applications = postedJobs.get(employer);

       applications.createKey(job);
    }

    public void addApplication(Employer employer, Job job, JobApplication application){

        JobApplications applications = postedJobs.get(employer);

        applications.add(job, application);
    }

    public void addApplication(Job job, JobApplication application){

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            if (applications.containsKey(job)){

                addApplication(employer, job, application);

                break;
            }
        }
    }

    public JobList getAllJobsByEmployer(Employer employer){

        JobApplications applications = postedJobs.get(employer);

        return applications.getAllJobsByEmployer();

    }



    public ApplicationsList getAllApplicationsByEmployer(Employer employer){

        JobApplications applications = postedJobs.get(employer);

        return applications.getAllApplications();

    }

    public ApplicationsList getByJob(Employer employer, Job job){

        JobApplications applications = postedJobs.get(employer);

        return applications.getByJob(job);

    }

    public ApplicationsList getByJobAndDate(Employer employer, Job job, LocalDate date){

        JobApplications applications = postedJobs.get(employer);

        return applications.getByJobAndDate(job, date);

    }

    public ApplicationsList getByDate(Employer employer, LocalDate date){

        JobApplications applications = postedJobs.get(employer);

        return applications.getByDate(date);

    }



}

