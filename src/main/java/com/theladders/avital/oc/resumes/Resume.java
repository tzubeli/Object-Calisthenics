package com.theladders.avital.oc.resumes;

import com.theladders.avital.oc.user.Jobseeker;

/**
 * Created by atzubeli on 6/26/14.
 */
public interface Resume {

    String toString();

     boolean isOwnedBy(Jobseeker thatJobseeker);

}
