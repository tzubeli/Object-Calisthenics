package main.java.Resumes;

import main.java.User.Jobseeker;
import main.java.User.Name;

/**
 * Created by atzubeli on 5/21/14.
 */
public class Resume {

    Jobseeker jobseeker;

    Name name;

    public Resume(Jobseeker jobseeker, Name name) {
        this.jobseeker = jobseeker;
        this.name = name;
    }
}

