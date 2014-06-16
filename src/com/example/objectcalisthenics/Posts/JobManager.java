package com.example.objectcalisthenics.Posts;


import com.example.objectcalisthenics.JobApplication.JobApplications;
import com.example.objectcalisthenics.Jobs.ATSJob;
import com.example.objectcalisthenics.Jobs.Job;
import com.example.objectcalisthenics.Jobs.JobDescription;
import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdFactory;
import com.example.objectcalisthenics.User.IdMap;

/**
 * Created by atzubeli on 6/16/14.
 */
public class JobManager {

    public void postJob(){

    }

    public static void createJob(Employer employer, JobDescription description){

        JobApplications applications = new JobApplications(); //fix this

        Job job = new ATSJob(employer);

        ID id = IdFactory.createId(job);

        IdMap.put(id, job);

        applications.createKey(id);


        


    }
}
