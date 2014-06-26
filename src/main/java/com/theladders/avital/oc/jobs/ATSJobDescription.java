package com.theladders.avital.oc.jobs;

import com.theladders.avital.oc.user.Name;

/**
 * Created by atzubeli on 6/25/14.
 */
public class ATSJobDescription {

    private Name name;

    public ATSJobDescription(Name name){

        this.name = name;
    }

    public String toString(){

        return name.toString()+" (ATS Job)";
    }
}
