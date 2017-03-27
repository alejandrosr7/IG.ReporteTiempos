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

    public boolean theStringIsEmpty(String text) {
        return text!=null && !text.trim().isEmpty() && !text.equals("");
    }

    public boolean validateEditext(EditText text) {
        return text != null && text.getText() != null && !text.getText().toString().equals("");
    }


    public <T> boolean theListContainData(List<T> list) {
        return list != null && list.size() > 0;
    }

    public boolean isNotCorrectPassword(String password) {
        return !password.matches(Constants.REGULAR_EXPRESSION_CORRECT_PASSWORD);
    }

    public boolean validateHoursReport(Double hours) {
        return hours > 0.0 && hours<=24;
    }



}
