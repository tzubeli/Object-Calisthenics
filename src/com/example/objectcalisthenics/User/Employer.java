package com.example.objectcalisthenics.User;

import com.example.objectcalisthenics.Jobs.JobDescription;
import com.example.objectcalisthenics.Posts.JobManager;

import java.util.List;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Employer {

    private String name;
    private int id;

    public String toString(){

        return name;
    }

    public void createJob(){

    }


    public void postJob(JobDescription description){

        JobManager.createJob(this, description);



    }

    public List viewPostedJobs(){

        return null;
    }





}
