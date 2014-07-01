package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.jobApplications.ApplicationsList;
import com.theladders.avital.oc.jobApplications.JobApplication;
import com.theladders.avital.oc.jobApplications.JobApplications;
import com.theladders.avital.oc.jobLists.JobList;
import com.theladders.avital.oc.user.Employer;
import org.joda.time.LocalDate;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by atzubeli on 6/26/14.
 */
public class Jobs {

private Map<Employer, JobApplications> postedJobs = new HashMap<>();


    public void createEmployerKey(Employer employer) {

        if (! postedJobs.containsKey(employer))

            postedJobs.put(employer, new JobApplications());
    }

    public void createJobKey(Employer employer, Job job){

        JobApplications applications = postedJobs.get(employer);

        applications.createJobKey(job);

    }

    public void addJob(Employer employer, Job job){

       JobApplications applications = postedJobs.get(employer);

       applications.createJobKey(job);
    }


    public void addApplication(Job job, JobApplication application){

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            if (applications.contains(job)){

                applications.addApplication(job, application);

                break;
            }
        }
    }

    public JobList getAllJobsByEmployer(Employer employer){

        JobApplications applications = postedJobs.get(employer);

        return applications.getAllJobsByEmployer();

    }

    public ApplicationsList getAllApplications(){

        ApplicationsList resultList = new ApplicationsList();

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            ApplicationsList list = applications.getAllApplications();

            resultList = resultList.combinedWith(list);

            }
        return resultList;

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

    public int numberOfApplications(){

        return getAllApplications().getSize();
    }

    public int numberOfJobs(){

        int numberOfJobs =0;

        for (Employer employer : postedJobs.keySet()){

            JobApplications applications = postedJobs.get(employer);

            numberOfJobs += applications.numberOfJobs();

        }
        return numberOfJobs;
    }



}

