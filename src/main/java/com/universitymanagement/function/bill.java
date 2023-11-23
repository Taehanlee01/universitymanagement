/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.universitymanagement.function;

import com.universitymanagement.Tools.tool;
import com.universitymanagement.course;
import com.universitymanagement.login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jasuj
 */
public class bill {
    JFrame frame = new JFrame();
    JPanel userDataPanel= new JPanel();
    JPanel billPanel= new JPanel();
    private course c;
    
    ArrayList<String> bill = new ArrayList<>();
    
    GridBagConstraints gbc=new GridBagConstraints();
    
    JTable jtable = new JTable();
    JScrollPane billScrollPane;
    
     private DefaultTableModel billListModel;
     
     Vector v;
    
    
    public bill(course c){
           this.c=c;
        frame.setSize(600,600);
        
        frame.setLayout(new GridBagLayout());
        gbc.fill=GridBagConstraints.BOTH;
        
        
       // userDataPanel.setBackground(new java.awt.Color(102,204,255));    //패널색 지정
        billPanel.setBackground(Color.WHITE);
        
        
        gbc.weightx = 0.1;
        gbc.weighty = 0.15;
        gbc.gridx = 0;
        gbc.gridy = 0;
        
      
        frame.add(userDataPanel,gbc);
 
          billListModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "강좌번호", "강좌이름", "수강료"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
           jtable.setModel(billListModel);
           
           billScrollPane = new JScrollPane(jtable);
           
        billPanel.add(billScrollPane);
           
           
        gbc.weightx = 0.1;
        gbc.weighty = 0.45;
        gbc.gridx = 0;
        gbc.gridy = 150;
        frame.add(billPanel,gbc);
        
        
        frame.setVisible(true);
        updateBill();
        watchBill();
    }
    
    public void watchBill(){
         login login = new login();

        for(int i=0;i<bill.size();i++){
            
            String[] str = tool.getTextedData("./강의목록/"+bill.get(i)+".txt");
            for(int j=0;j<=str.length-4;j+=4){
                 if(str[j].equals(login.getCurrentLoginID())){
                
                     
                     int index=c.courseName.indexOf(bill.get(i));
                      v = new Vector();
                     

                      
                      v.add(c.courseNumber.get( index));
                    //  System.out.println(c.courseNumber.get( index));
                     v.add(c.courseName.get( index));
                    //  System.out.println(c.courseName.get( index));
                     v.add( c.courseMoney.get( index));
                    //  System.out.println(c.courseMoney.get( index));
                     billListModel.addRow(v);
                       
                   }   
                 }  
            }  
            

    }
        
    
    
    
    
     private void updateBill() {
        bill.clear();
        File directory = new File("./강의목록");

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        bill.add(file.getName().replace(".txt", ""));
                    }
                }
            }
        }
     }
    
    
    
}
