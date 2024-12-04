package com.mycompany.visualproc.Handlers;

import com.mycompany.visualproc.Instructions;
import com.mycompany.visualproc.Processors.MyProcessor;
import com.mycompany.visualproc.Task;

public class MyVisualModule extends MyModule{
    public void Calculate(Task t, MyProcessor p) throws Exception{
        if (t.instruction == Instructions.show){
            for (int i = 0; i < 4; i++){
                System.out.println(p.GetRegister(i));
            }
        }
        else{
            super.Calculate(t, p);
        }
    }
}
