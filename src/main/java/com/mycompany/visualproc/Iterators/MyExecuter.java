package com.mycompany.visualproc.Iterators;

import com.mycompany.visualproc.Processors.IProcessor;
import com.mycompany.visualproc.Task;

public class MyExecuter {

    protected IProcessor p;
    
    void setP(IProcessor _p){
        p = _p;
    }
    public void Run(MyProgram pr) throws Exception{
        for(Task t: pr){
            p.Run(t);
        }
    }
}
