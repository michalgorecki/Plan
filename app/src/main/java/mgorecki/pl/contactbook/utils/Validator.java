package mgorecki.pl.contactbook.utils;

import android.util.Patterns;

/**
 * Created by emigore on 2017-07-05.
 */

public  class Validator {

    public static boolean isEmailValid(String email){
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
