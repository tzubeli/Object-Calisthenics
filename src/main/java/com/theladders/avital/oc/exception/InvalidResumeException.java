package com.theladders.avital.oc.exception;

import com.theladders.avital.oc.resumes.NoResume;

/**
 * Created by atzubeli on 7/1/14.
 */
public class InvalidResumeException extends RuntimeException {

   public InvalidResumeException(){

       super("Invalid resume");
   }
}
