package com.mycompany.visualproc.Handlers;

import com.mycompany.visualproc.Instructions;
import com.mycompany.visualproc.Processors.MyProcessor;
import com.mycompany.visualproc.Task;

public class MyALU extends MyModule{
    public void Calculate(Task t, MyProcessor p) throws Exception{
        if (t.instruction == Instructions.tripleAdd){
            p.SetRegister(p.GetRegister(0) + p.GetRegister(1),2);
        }
        else if (t.instruction == Instructions.add){
            p.SetRegister(p.GetRegister(t.address1) + p.GetRegister(t.address2), t.address3);
        }
        else if (t.instruction == Instructions.sub){
            p.SetRegister(p.GetRegister(t.address1) - p.GetRegister(t.address2), t.address3);
        }
        else if (t.instruction == Instructions.mult){
            p.SetRegister(p.GetRegister(t.address1) * p.GetRegister(t.address2), t.address3);
        }
        else{
            super.Calculate(t, p);
        }
    }
}
