package com.fouriApps.model.AM.client;

import com.fouriApps.model.AM.common.DynamicReports_AM;

import java.util.ArrayList;
import java.util.Map;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 21 14:30:34 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DynamicReports_AMClient extends ApplicationModuleImpl implements DynamicReports_AM {
    /**
     * This is the default constructor (do not remove).
     */
    public DynamicReports_AMClient() {
    }

    public ArrayList getLOVValues(String tableName, String value,
                                  String displayValue, String lookupType) {
        Object _ret =
            this.riInvokeExportedMethod(this,"getLOVValues",new String [] {"java.lang.String","java.lang.String","java.lang.String","java.lang.String"},new Object[] {tableName, value, displayValue, lookupType});
        return (ArrayList)_ret;
    }

    public Map applicationSessionSetup() {
        Object _ret =
            this.riInvokeExportedMethod(this,"applicationSessionSetup",null,null);
        return (Map)_ret;
    }
}
