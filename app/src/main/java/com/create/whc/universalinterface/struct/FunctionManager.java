package com.create.whc.universalinterface.struct;

import android.text.TextUtils;

import java.util.HashMap;

public class FunctionManager {

    private static FunctionManager functionManager;
    private HashMap<String,FunctionNoParamNoResult> mFunctionNoParamNoResult;
    private HashMap<String,FunctionOnlyWithParam> mFunctionOnlyWithParam;
    private HashMap<String,FunctionOnlyWithResult> mFunctionOnlyWithResult;
    private HashMap<String,FunctionWithParamAndResult> mFunctionWithParamAndResult;

    private FunctionManager(){
        mFunctionNoParamNoResult=new HashMap<>();
        mFunctionOnlyWithParam=new HashMap<>();
        mFunctionOnlyWithResult=new HashMap<>();
        mFunctionWithParamAndResult=new HashMap<>();
    }

    public static FunctionManager getInstance(){
        if (functionManager==null){
            functionManager=new FunctionManager();
        }
        return functionManager;
    }

    //第一个
    public FunctionManager addFunction(FunctionNoParamNoResult function){
        mFunctionNoParamNoResult.put(function.getFunctionName(),function);
        return this;
    }

    public void invokeFunction(String functionName){
        if (TextUtils.isEmpty(functionName)){
            return;
        }
        if (mFunctionNoParamNoResult!=null){
            FunctionNoParamNoResult f = mFunctionNoParamNoResult.get(functionName);
            if (f!=null){
                f.function();
            }
            if (f==null){
                try {
                    throw new FunctionException("this function is not exist!");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //第二个
    public FunctionManager addFunction(FunctionOnlyWithParam function){
        mFunctionOnlyWithParam.put(function.getFunctionName(),function);
        return this;
    }

    public <Param> void invokeFunction(String functionName,Param param){
        if (TextUtils.isEmpty(functionName)){
            return;
        }
        if (mFunctionOnlyWithParam!=null){
            FunctionOnlyWithParam f = mFunctionOnlyWithParam.get(functionName);
            if (f!=null){
                f.function(param);
            }else {
                try {
                    throw new FunctionException("this function is not exist!");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //第三个
    public FunctionManager addFunction(FunctionOnlyWithResult function){
        mFunctionOnlyWithResult.put(function.getFunctionName(),function);
        return this;
    }

    public <Result> Result  invokeFunction(String functionName,Class<Result> c){
        if (TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionOnlyWithResult!=null){
            FunctionOnlyWithResult f = mFunctionOnlyWithResult.get(functionName);
            if (f!=null){
                if (c!=null){
                    return c.cast(f.function());
                }else{
                    return (Result) f.function();
                }
            }else {
                try {
                    throw new FunctionException("this function is not exist!");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //第四个
    public FunctionManager addFunction(FunctionWithParamAndResult function){
        mFunctionWithParamAndResult.put(function.getFunctionName(),function);
        return this;
    }

    public <Result,Param> Result  invokeFunction(String functionName,Class<Result> c,Param param){
        if (TextUtils.isEmpty(functionName)){
            return null;
        }
        if (mFunctionWithParamAndResult!=null){
            FunctionWithParamAndResult f = mFunctionWithParamAndResult.get(functionName);
            if (f!=null){
                if (c!=null){
                    return c.cast(f.function(param));
                }else{
                    return (Result) f.function(param);
                }
            }else {
                try {
                    throw new FunctionException("this function is not exist!");
                } catch (FunctionException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
