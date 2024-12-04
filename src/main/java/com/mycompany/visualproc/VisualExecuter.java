/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.visualproc;

import com.mycompany.visualproc.Iterators.MyProgram;
import com.mycompany.visualproc.Processors.MyProcessor;
import com.mycompany.visualproc.Processors.PBuilder;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author danil
 */
public class VisualExecuter implements Iterable<Task>{
    MyProgram prog = new MyProgram();
    MyProcessor proc = new MyProcessor();
    Iterator<Task> progIter = prog.iterator();
    ArrayList<IObserver> obs = new ArrayList<IObserver>();
    Task current;
    Boolean started = false;
    
    @Override
    public Iterator<Task> iterator() {
        return prog.iterator();
    }
    public void reset(){
        progIter = prog.iterator();
        if (progIter.hasNext()) current = progIter.next();
        else current = null;
    }
    void addTask(Task t) throws Exception{
        prog.Add(t);
        //progIter = prog.iterator();
        if (current == null) current = prog.first();
        callEvents();
    }
    void removeTask(Task t) throws Exception{
        prog.Remove(t);
        //progIter = prog.iterator();
        if ((!progIter.hasNext())) current = null;
        callEvents();
    }
    void swap(int i1, int i2) throws Exception{
        prog.swap(i1, i2);
        reset();
        callEvents();
    }
    void stop() throws Exception{
        started = false;
        reset();
        proc.clear();
        callEvents();
    }
    int getMemory(int index) throws Exception {return proc.GetMemory(index);}
    int getRegister(int index) throws Exception {return proc.GetRegister(index);}
    ArrayList<Instructions> getCommon(){
        return prog.SortedIns();
    }
    void doNext()throws Exception{ //ТУТ ЕСТЬ ПРОВЕРКА??
        if (!started) {
            reset();
            started = true;
        }
        proc.Run(current);
        if (progIter.hasNext()) current = progIter.next();
        callEvents();
    }
    
    void addObs(IObserver o){
        obs.add(o);
    }
    void callEvents() throws Exception{
        for(IObserver o: obs){
            o.event(this);
        }
    }
}
