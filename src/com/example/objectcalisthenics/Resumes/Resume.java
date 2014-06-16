package com.example.objectcalisthenics.Resumes;

import com.example.objectcalisthenics.User.Jobseeker;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Resume {

    Jobseeker jobseeker;

    int id;


    public boolean hasId(int resumeId){

        return (this.id==resumeId);

    }
}

