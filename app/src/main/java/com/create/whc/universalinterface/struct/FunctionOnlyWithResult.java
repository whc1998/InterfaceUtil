package com.create.whc.universalinterface.struct;

public abstract class FunctionOnlyWithResult<Result> extends Function {

    public FunctionOnlyWithResult(String name) {
        super(name);
    }

    protected abstract Result function();

}
