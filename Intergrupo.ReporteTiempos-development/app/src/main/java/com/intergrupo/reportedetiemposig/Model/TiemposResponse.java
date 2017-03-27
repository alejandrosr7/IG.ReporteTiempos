package com.intergrupo.reportedetiemposig.Model;

/**
 * Created by mauricio on 18/11/15.
 */
public class TiemposResponse<T> {

    private T data;

    private Error error;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
