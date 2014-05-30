package com.example.objectcalisthenics.Collections;

import com.example.objectcalisthenics.User.Jobseeker;

/**
 * Created by atzubeli on 5/28/14.
 */
public interface JobLists {

    public void addJobSeekerKey(Jobseeker jobseeker);

    public void addJob(Jobseeker jobseeker, int jobId);

    public void removeJob(Jobseeker jobseeker, int jobId);

}
