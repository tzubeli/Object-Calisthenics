package com.example.objectcalisthenics.JobApplication;

import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.User.Jobseeker;
import com.example.objectcalisthenics.User.ID;

import java.util.Date;

/**
 * Created by atzubeli on 5/28/14.
 */
public class JobApplicationATS implements JobApplication {


    private Date date;
    private Jobseeker jobseeker;
    private Job job;

    public JobApplicationATS(ID jobId, Jobseeker jobseeker){


    }


    public void createApplicationReport(Job job, Jobseeker jobseeker) {

    }
}
