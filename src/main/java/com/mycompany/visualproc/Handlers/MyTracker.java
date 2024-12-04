package com.mycompany.visualproc.Handlers;

import com.mycompany.visualproc.Instructions;
import com.mycompany.visualproc.Processors.MyProcessor;
import com.mycompany.visualproc.Task;

public class MyTracker extends MyModule{
    public void Calculate(Task t, MyProcessor p) throws Exception{
        if (t.instruction == Instructions.saveTo) {
            p.SetMemory(p.GetRegister(t.address1), t.address2);
        }
        else if (t.instruction == Instructions.load) {
            p.SetRegister(p.GetMemory(t.address1), t.address2);
        }
        else if (t.instruction == Instructions.move){
            p.SetRegister(p.GetRegister(t.address1), t.address2);
        }
        else if (t.instruction == Instructions.init){
            p.SetMemory(t.address2, t.address1);
        }
        else{
            super.Calculate(t, p);
        }
    }
}
