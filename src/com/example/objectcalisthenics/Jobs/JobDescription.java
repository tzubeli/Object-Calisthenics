package com.example.objectcalisthenics.Jobs;

import com.example.objectcalisthenics.User.Name;

/**
 * Created by atzubeli on 6/13/14.
 */
public class JobDescription {

    Name name;
    boolean requiresResume;

    public JobDescription(Name name, boolean requiresResume){

        this.name = name;
        this.requiresResume = requiresResume;

    }

    public String toString(){

        String jobType = (requiresResume)? "(JReq)" : "(ATS)";

        return name.toString()+" "+ jobType;
    }

    public boolean requiresResume(){

        return requiresResume;
    }


}
