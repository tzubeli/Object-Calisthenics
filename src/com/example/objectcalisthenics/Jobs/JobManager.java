package com.example.objectcalisthenics.Jobs;


import com.example.objectcalisthenics.Collections.RecordedMap;
import com.example.objectcalisthenics.JobApplication.JobApplications;
import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdFactory;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    JobApplications applications = new JobApplications();



    public void createJob(Employer employer, JobDescription description){


        Job job = new Job(employer, description);  //creates a new job object

        ID id = IdFactory.createId(job);  //creates new ID and puts it in the map

        //TODO create key for employer ID

        applications.createKey(id);  //adds this id to the applications map (????)

        postJob(job);  //posts job --> sends to list of posted jobs


    }

    private void postJob(Job job){


        RecordedMap jobs = new Jobs();

        //jobs.add();


    }
}
