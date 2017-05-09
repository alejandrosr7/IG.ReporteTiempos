package com.intergrupo.reportedetiemposig.Repositories.Production;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;

import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/**
 * Created by mauricio on 1/11/15.
 */
public class ReporteDeTiemposApiClient {

    //Url de VPN
    private static final String API_BASE_PATH = "https://reportetiempos.intergrupo.com:444/api";

    private static ReporteDeTiemposApiClient INSTANCE = new ReporteDeTiemposApiClient();

    public static ReporteDeTiemposApiClient getInstance() {
        return INSTANCE;
    }

    private IRestClient apiClient;

    public IRestClient getClient() {
        return apiClient;
    }

    private Context context;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    private ReporteDeTiemposApiClient() {

        Gson gson = new GsonBuilder()
                .create();

        final OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(15, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(15, TimeUnit.SECONDS);

        RestAdapter restAdapter;
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(API_BASE_PATH)
                .setConverter(new GsonConverter(gson))
                .setClient(new OkClient(okHttpClient))
                .setLogLevel(RestAdapter.LogLevel.HEADERS_AND_ARGS)
                .build();

        apiClient = restAdapter.create(IRestClient.class);
    }
}