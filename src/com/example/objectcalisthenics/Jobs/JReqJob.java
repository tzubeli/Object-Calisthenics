package com.example.objectcalisthenics.Jobs;


import com.example.objectcalisthenics.User.Employer;
import com.example.objectcalisthenics.User.ID;
import com.example.objectcalisthenics.User.IdFactory;

/**
 * Created by atzubeli on 5/21/14.
 */
public class JReqJob implements Job {

    Employer employer;

    ID id;

    public JReqJob(Employer employer){

        this.employer = employer;
        this.id = IdFactory.createId(this);


    }

}
