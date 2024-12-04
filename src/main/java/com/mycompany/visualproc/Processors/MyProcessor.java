package com.mycompany.visualproc.Processors;

import com.mycompany.visualproc.Handlers.MyALU;
import com.mycompany.visualproc.Handlers.MyModule;
import com.mycompany.visualproc.Handlers.MyTracker;
import com.mycompany.visualproc.Handlers.MyVisualModule;
import com.mycompany.visualproc.Task;

public class MyProcessor implements IProcessor{
    int[] memory = new int[32];
    int[] registers = new int[4];
    MyModule modules;
    public MyProcessor(){
        modules = new MyALU();
        modules.Add(new MyTracker()).Add(new MyVisualModule());
    }
    @Override
    public void Run(Task t) throws Exception{
          modules.Calculate(t, this);
    }
    public void SetRegister(int value, int number) throws Exception{
        if ((number < 0) || (number > 3)) throw new Exception("Index error");
        registers[number] = value;
    }
    public int GetRegister(int number) throws Exception{
        if ((number < 0) || (number > 3)) throw new Exception("Index error");
        return registers[number];
    }
    public void SetMemory(int value, int number) throws Exception{
        if ((number < 0) || (number > 1023)) throw new Exception("Index error");
        memory[number] = value;
    }
    public int GetMemory(int number) throws Exception{
        if ((number < 0) || (number > 1023)) throw new Exception("Index error");
        return memory[number];
    }

    public void clear() {
        for (int i = 0; i < 4; i++){
            registers[i] = 0;
        }
        for (int i = 0; i < 32; i++){
            memory[i] = 0;
        }
    }
}
