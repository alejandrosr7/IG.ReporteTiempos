package com.intergrupo.reportedetiemposig.Model;

import com.intergrupo.reportedetiemposig.Repositories.RepositoryLocator;

/**
 * Created by sebastianarango on 16/02/16.
 */
public class mApp {

    private static mApp ourInstance = new mApp();
    private static RepositoryLocator locator;

    public static mApp getInstance() {
        return ourInstance;
    }

    private mApp() {
        locator = RepositoryLocator.getInstance();
    }

    public User SingInSincrono(Login login) {
        return locator.getSecurityRepository().SignInSincrono(login);
    }
}
