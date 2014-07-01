package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.user.Jobseeker;

import java.util.HashMap;
import java.util.Map;

/**
* Created by atzubeli on 6/12/14.
*/
public class Resumes{

    Map<Jobseeker, ResumeList> resumes = new HashMap<Jobseeker, ResumeList>();


    public void createKey(Jobseeker jobseeker) {

        if (!resumes.containsKey(jobseeker))

            resumes.put(jobseeker, new ResumeList());
    }


    public void add(Jobseeker jobseeker, RealResume resume){

        createKey(jobseeker);

        ResumeList list = resumes.get(jobseeker);

        list.create(resume);

    }

    public ResumeList readAll(Jobseeker jobseeker){

        ResumeList list = resumes.get(jobseeker);

        return list.readAll();

    }







}
