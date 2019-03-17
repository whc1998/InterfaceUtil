package com.create.whc.universalinterface.struct;

public abstract class FunctionOnlyWithParam <Param> extends Function {
    public FunctionOnlyWithParam(String name) {
        super(name);
    }

    protected abstract void function(Param param);

}
