package com.example.objectcalisthenics.Jobs;

import com.example.objectcalisthenics.User.Employer;

/**
 * Created by atzubeli on 5/21/14.
 */
public abstract class Job {

    private String name;

    private int JobId;

    private Employer employer;


    public String toString(){

        return (name+" - "+employer.toString());



    }

}
