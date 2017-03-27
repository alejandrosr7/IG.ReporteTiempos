package com.intergrupo.reportedetiemposig.CallBack;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public interface Callback<T> {

    void complete(T data);

    /**
     * Unsuccessful.
     */
    void failure(com.intergrupo.reportedetiemposig.Model.Error error);/** Successful . */
}
