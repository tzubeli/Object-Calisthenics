package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.collections.CollectionWrapper;


/**
 * Created by atzubeli on 6/12/14.
 */
public interface ResumeList extends CollectionWrapper<RealResume> {


    public boolean create(RealResume resume);
    

    public RealResume read(int id);


    public CollectionWrapper readAll();


    public void update(RealResume oldResume, RealResume newResume);


    public boolean delete(RealResume resume);
}
