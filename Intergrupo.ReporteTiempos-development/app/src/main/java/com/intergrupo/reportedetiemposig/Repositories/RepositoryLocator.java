package com.intergrupo.reportedetiemposig.Repositories;

import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IReportRepository;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.ISecurityRepository;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesMRepository;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesManagerDetail;
import com.intergrupo.reportedetiemposig.Repositories.Interfaces.IViewTimesRepository;
import com.intergrupo.reportedetiemposig.Repositories.Production.ReportRepository;
import com.intergrupo.reportedetiemposig.Repositories.Production.SecurityRepository;
import com.intergrupo.reportedetiemposig.Repositories.Production.ViewTimesManagerDetailRepository;
import com.intergrupo.reportedetiemposig.Repositories.Production.ViewTimesManagerRepository;
import com.intergrupo.reportedetiemposig.Repositories.Production.ViewTimesRepository;
import com.intergrupo.reportedetiemposig.Repositories.Test.TestExpandableListRepository;
import com.intergrupo.reportedetiemposig.Repositories.Test.TestReportRepository;
import com.intergrupo.reportedetiemposig.Repositories.Test.TestSecurityRepository;
import com.intergrupo.reportedetiemposig.Repositories.Test.TestViewTimesDetail;
import com.intergrupo.reportedetiemposig.Repositories.Test.TestViewTimesRepository;
import com.intergrupo.reportedetiemposig.Util.Constants;

/**
 * Created by mauriciocaro on 23/06/15.
 */
public class RepositoryLocator {

    private static RepositoryLocator INSTANCE = new RepositoryLocator();
    private Boolean useTestRepositories;

    private RepositoryLocator() {
        this.useTestRepositories = Constants.DEBUG;
    }

    public static RepositoryLocator getInstance() {
        return INSTANCE;
    }

    public ISecurityRepository getSecurityRepository() {
        if (this.useTestRepositories) {
            return new TestSecurityRepository();
        } else {
            return new SecurityRepository();
        }
    }

    public IReportRepository getReportRepository() {

        if (this.useTestRepositories) {
            return new TestReportRepository();
        } else {
            return new ReportRepository();
        }
    }

    public IViewTimesRepository getViewTimesRepository() {

        if (this.useTestRepositories) {
            return new TestViewTimesRepository();
        } else {
            return new ViewTimesRepository();
        }
    }

    public IViewTimesMRepository getTimesForManager() {

        if (this.useTestRepositories) {
            return new TestExpandableListRepository();
        } else {
            return new ViewTimesManagerRepository();
        }
    }

    public IViewTimesManagerDetail getTimesManagerDetail() {

        if (this.useTestRepositories) {
            return new TestViewTimesDetail();
        } else {
            return new ViewTimesManagerDetailRepository();
        }
    }
}

