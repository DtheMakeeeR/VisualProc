package com.mycompany.visualproc.Processors;

import com.mycompany.visualproc.Task;

public class PBuilder {
    static public IProcessor Build(){
        return new MyProcessor();
    }
}
