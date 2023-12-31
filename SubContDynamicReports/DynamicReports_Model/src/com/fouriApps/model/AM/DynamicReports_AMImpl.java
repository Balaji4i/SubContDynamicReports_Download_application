package com.fouriApps.model.AM;

import com.fouriApps.model.AM.common.DynamicReports_AM;
import com.fouriApps.model.ROVO.Dynamic_ROVOImpl;
import com.fouriApps.model.ROVO.Reports_ROVOImpl;
import com.fouriApps.model.VO.XxfndReportParamsVoImpl;

import java.sql.SQLSyntaxErrorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;

import javax.faces.model.SelectItem;

import oracle.jbo.server.ViewObjectImpl;


// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Nov 21 14:22:59 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class DynamicReports_AMImpl extends ApplicationModuleImpl implements DynamicReports_AM {
    /**
     * This is the default constructor (do not remove).
     */
    public DynamicReports_AMImpl() {
    }

    /**
     * Container's getter for Reports_ROVO1.
     * @return Reports_ROVO1
     */
    public ViewObjectImpl getReports_ROVO1() {
        return (ViewObjectImpl)findViewObject("Reports_ROVO1");
    }

    /**
     * Container's getter for Functions_VO1.
     * @return Functions_VO1
     */
    public ViewObjectImpl getFunctions_VO1() {
        return (ViewObjectImpl)findViewObject("Functions_VO1");
    }

    /**
     * Container's getter for XxfndReportParamsVo1.
     * @return XxfndReportParamsVo1
     */
    public XxfndReportParamsVoImpl getXxfndReportParamsVo1() {
        return (XxfndReportParamsVoImpl)findViewObject("XxfndReportParamsVo1");
    }
    
    public ArrayList getLOVValues(String tableName,String value,String displayValue,String lookupType) {
    //            System.out.println("called getLOVValues");
        String sqlStatement = null;
        if(lookupType==null){
           sqlStatement = "SELECT "+value+","+displayValue+" from "+tableName;
        }
        else{
           sqlStatement = "SELECT LOOKUP_VALUE_NAME,LOOKUP_VALUE_NAME_DISP FROM XXFND_LOOKUP_VALUES WHERE LOOKUP_TYPE_ID=(SELECT LOOKUP_TYPE_ID FROM XXFND_LOOKUP_TYPES WHERE LOOKUP_TYPE_NAME='"+lookupType+"')";
        }
             System.out.println("called getLOVValues:sqlStatement->"+sqlStatement);

        ArrayList selectItemList = new ArrayList();
        ViewObject dynamicVO = this.findViewObject("Dynamic_ROVO1"); 
         dynamicVO.remove();  
         dynamicVO = this.createViewObjectFromQueryStmt("Dynamic_ROVO1", sqlStatement);  
         dynamicVO.setRangeSize(-1);
         dynamicVO.executeQuery();
    //         System.out.println("called getLOVValues:get estimated row count->"+dynamicVO.getEstimatedRowCount());
         Row[] rows = dynamicVO.getAllRowsInRange();
         Row row;
         for(int i=0;i<rows.length;i++){
             SelectItem obj = new SelectItem();
             row = rows[i];
             obj.setValue(row.getAttribute(0)!=null ? row.getAttribute(0).toString() : null);
             obj.setLabel(row.getAttribute(1)!=null ? row.getAttribute(1).toString() : null);
             selectItemList.add(obj);
         }
    //         System.out.println("called getLOVValues return");
         return selectItemList;
       }

    public Map applicationSessionSetup(){
        Map sessionMap = new HashMap<String,String>();
        ViewObject vo = this.getLookUp_ROVO1();
        vo.applyViewCriteria(vo.getViewCriteriaManager().getViewCriteria("findByTransCategoryVC"));
        vo.setNamedWhereClauseParam("pLookupTypeName", "PROFILE_VALUES");
        vo.setRangeSize(-1);
        vo.executeQuery();
        Row[] rows = vo.getAllRowsInRange();
        Row row;
        for(int i=0;i<rows.length;i++){
            row=rows[i];
            sessionMap.put(row.getAttribute("LookupValueName"), row.getAttribute("LookupAddlValue"));
        }
        System.out.println("Session Map:"+sessionMap);
        return sessionMap;
    }

    /**
     * Container's getter for LookUp_ROVO1.
     * @return LookUp_ROVO1
     */
    public ViewObjectImpl getLookUp_ROVO1() {
        return (ViewObjectImpl)findViewObject("LookUp_ROVO1");
    }

    /**
     * Container's getter for Dynamic_ROVO1.
     * @return Dynamic_ROVO1
     */
    public Dynamic_ROVOImpl getDynamic_ROVO1() {
        return (Dynamic_ROVOImpl)findViewObject("Dynamic_ROVO1");
    }

    /**
     * Container's getter for FuncBasedOnRoleROVO1.
     * @return FuncBasedOnRoleROVO1
     */
    public ViewObjectImpl getFuncBasedOnRoleROVO1() {
        return (ViewObjectImpl)findViewObject("FuncBasedOnRoleROVO1");
    }


    /**
     * Container's getter for xxstg_Business_unit1.
     * @return xxstg_Business_unit1
     */
    public ViewObjectImpl getxxstg_Business_unit1() {
        return (ViewObjectImpl)findViewObject("xxstg_Business_unit1");
    }

    /**
     * Container's getter for Businessunit_In_Certification_headers1.
     * @return Businessunit_In_Certification_headers1
     */
    public ViewObjectImpl getBusinessunit_In_Certification_headers1() {
        return (ViewObjectImpl)findViewObject("Businessunit_In_Certification_headers1");
    }

    /**
     * Container's getter for ReportPath1.
     * @return ReportPath1
     */
    public ViewObjectImpl getReportPath1() {
        return (ViewObjectImpl)findViewObject("ReportPath1");
    }

}
