package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.collections.CRUDInterface;
import com.theladders.avital.oc.collections.ListWrapper;

import java.util.Collection;


/**
 * Created by atzubeli on 6/12/14.
 */
public interface ResumeList extends ListWrapper<Resume>{


    public boolean create(Resume resume);
    

    public Resume read(int id);


    public ListWrapper readAll();


    public void update(Resume oldResume, Resume newResume);


    public boolean delete(Resume resume);
}
