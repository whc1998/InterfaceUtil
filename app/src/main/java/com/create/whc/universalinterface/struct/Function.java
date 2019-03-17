package com.create.whc.universalinterface.struct;

public abstract class Function {

    private String functionName;

    public Function(String name){
        this.functionName=name;
    }

    public String getFunctionName(){
        return functionName;
    }

}
