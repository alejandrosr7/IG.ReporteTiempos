package com.intergrupo.reportedetiemposig.Helper;

import android.widget.EditText;

import com.intergrupo.reportedetiemposig.Util.Constants;

import java.util.List;

/**
 * Created by mauricio on 24/11/15.
 */
public class Validation {

    public boolean isNotCorrectEmail(String email) {
        return !email.matches(Constants.REGULAR_EXPRESSION_CORRECT_EMAIL);
    }

    public <T> boolean theDataIsNotNull(T data) {
        return data != null;
    }


    public boolean validateHoursReport(Double hours) {
        return hours > 0.0 && hours <= 24;
    }


}
