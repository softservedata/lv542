package com.acit.andriichornyi.javaautomation;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ResultTable extends HashSet {
    //private String methodName = null;
    //private Collection ResultData;
    private Map executionParameters;

//    public ResultTable(Collection Data) {
//        this.ResultData = Data;
//        this.executionParameters = new HashMap();
//    }

//    public ResultTable(String methodName, Collection resultData) {
//        this.methodName = methodName;
//        ResultData = resultData;
//    }

//    public ResultTable(String methodName, Collection resultData, Map executionParameters) {
//        this.methodName = methodName;
//        ResultData = resultData;
//        this.executionParameters = executionParameters;
//    }

//    public String getMethodName() {
//        return methodName;
//    }
//
//    public void setMethodName(String methodName) {
//        this.methodName = methodName;
//    }

//    public Collection getResultData() {
//        return ResultData;
//    }

//    public void setResultData(Collection resultData) {
//        ResultData = resultData;
//    }

//    public Map getExecutionParameters() {
//        return executionParameters;
//    }
//
//    public void setExecutionParameters(Map executionParameters) {
//        this.executionParameters = executionParameters;
//    }
//
//    public void setExecutionParameters(Object key, Object value) {
//        this.executionParameters.put(key, value);
//    }
//
//    public void printExecutionParameters() {
//        for (Object parameter:this.executionParameters.keySet()
//        ) {
//            System.out.println(this.executionParameters.get(parameter));
//        }
//    }
    public void setSysTimeToExecParam(String description) {
        executionParameters.put(System.currentTimeMillis(), description);
    }
}