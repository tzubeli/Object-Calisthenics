package com.example.objectcalisthenics.JobApplication;

import com.example.objectcalisthenics.JobApplication.ApplicationDetails;
import javafx.application.Application;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 * Created by atzubeli on 6/16/14.
 */
public class ApplicationsList {

    ArrayList<ApplicationDetails> detailsList = new ArrayList<ApplicationDetails>();


    public void addApplication(ApplicationDetails details){

        detailsList.add(details);

    }

    public void removeApplication(ApplicationDetails details){

        detailsList.remove(details);
    }

    public Collection<ApplicationDetails> readAll(){

        return detailsList;
    }

    public Collection<ApplicationDetails> getByDate(Date date){

        Collection<ApplicationDetails> listByDate = new ArrayList<ApplicationDetails>();

        for (ApplicationDetails details : detailsList)

            if (details.isDate(date)) listByDate.add(details);

        return listByDate;
    }


}
