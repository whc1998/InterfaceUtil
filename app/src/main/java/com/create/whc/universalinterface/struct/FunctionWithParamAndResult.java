package com.create.whc.universalinterface.struct;

public abstract class FunctionWithParamAndResult<Result,Param> extends Function {

    public FunctionWithParamAndResult(String name) {
        super(name);
    }

    protected abstract Result function(Param param);

}
