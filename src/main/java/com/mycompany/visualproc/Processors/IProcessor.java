package com.mycompany.visualproc.Processors;

import com.mycompany.visualproc.Task;

public interface IProcessor {
    public void Run(Task t) throws Exception;
}
