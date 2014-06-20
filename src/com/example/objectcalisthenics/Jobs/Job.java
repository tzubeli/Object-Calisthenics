package com.example.objectcalisthenics.Jobs;

import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdFactory;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Job {

    Employer employer;

    JobDescription description;



    public Job(Employer employer, JobDescription description){

        this.employer = employer;
        this.description = description;

        IdFactory.createId(this);
    }


    public boolean requiresResume(){

        return description.requiresResume();
    }


    public String toString(){

        return employer.toString()+ ": " + description.toString();
    }

}
