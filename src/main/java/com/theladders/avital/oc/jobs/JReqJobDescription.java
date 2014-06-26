package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.resumes.RealResume;
import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 6/25/14.
 */
public class JReqJobDescription implements JobDescription {

    private Name name;
    private RealResume resume;

    public JReqJobDescription(Name name, RealResume resume) {

        this.name = name;
        this.resume = resume;
    }

    public JReqJobDescription(Name name){

        //error call???
    }

    public String toString(){

        return name.toString()+" (JReq Job)";
    }
}
