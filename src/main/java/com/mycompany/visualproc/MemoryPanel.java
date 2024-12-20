/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.mycompany.visualproc;

import javax.swing.JLabel;

/**
 *
 * @author danil
 */
public class MemoryPanel extends javax.swing.JPanel implements IObserver{

    /**
     * Creates new form MemoryPanel
     */
    VisualExecuter exec;
    public MemoryPanel() {
        initComponents();
        exec = BVisualExecuter.Build();
        exec.addObs(this);
        try{event(exec);}
        catch(Exception e){}
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Grid = new javax.swing.JPanel();

        Grid.setLayout(new java.awt.GridLayout(8, 4));
        jScrollPane1.setViewportView(Grid);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Grid;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void event(VisualExecuter ve) throws Exception {
        Grid.removeAll();
        for (int i = 0; i < 32; i++){
            Grid.add(new JLabel(i+": " + ve.getMemory(i)));
        }
        this.revalidate();
    }
}
