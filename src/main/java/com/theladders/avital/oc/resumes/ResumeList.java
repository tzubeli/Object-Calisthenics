package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.collections.CollectionWrapper;


/**
 * Created by atzubeli on 6/12/14.
 */
public interface ResumeList extends CollectionWrapper<Resume> {


    public boolean create(Resume resume);
    

    public Resume read(int id);


    public CollectionWrapper readAll();


    public void update(Resume oldResume, Resume newResume);


    public boolean delete(Resume resume);
}
