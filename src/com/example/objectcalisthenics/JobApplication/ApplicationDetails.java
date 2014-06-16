package com.example.objectcalisthenics.JobApplication;

import com.example.objectcalisthenics.User.Jobseeker;

import java.util.Date;

/**
 * Created by atzubeli on 6/13/14.
 */
public class ApplicationDetails {

    Jobseeker jobseeker;
    Date date;


    public boolean isDate(Date date){

        return (this.date == date);


    }
}
