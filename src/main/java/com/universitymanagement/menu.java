package com.universitymanagement;



import com.universitymanagement.function.courseRegistrationApp;
import com.universitymanagement.function.test;
import com.universitymanagement.function.bill;
import com.universitymanagement.User.professor;
import static com.universitymanagement.main.c;
import static com.universitymanagement.main.courseRegister;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class menu{
    static JFrame f = new JFrame();
    static JPanel p1= new JPanel();
    
    static JButton btn1 = new JButton();
    static JButton btn2 = new JButton();
    static JButton btn3 = new JButton();
    static JButton btn4 = new JButton();
    static JButton btn5 = new JButton();
    
    static JOptionPane popup=new JOptionPane();
    
    public test t;
    public professor p;
    
    
    public menu(){ 
        f.setLayout(new GridLayout(1,1));
        f.setTitle("대학정보시스템-매인");
        f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        f.setSize(400,600);
      
        p1.setBackground(new java.awt.Color(102,204,255));
        p1.setLayout(new GridLayout(5,1,0,30)); 
        p1.setBorder(BorderFactory.createEmptyBorder(30 , 10 , 30 , 10));
        
        btn1.setText("수강신청");
        btn2.setText("청구서 조회");
       // btn3.setText("교수매뉴");
      //  btn4.setText("학사담당자매뉴");
      //  btn5.setText("수업담당자매뉴");
        
        p1.add(btn1,BorderLayout.NORTH);
        p1.add(btn2,BorderLayout.NORTH);
        p1.add(btn3,BorderLayout.NORTH);
        p1.add(btn4,BorderLayout.NORTH);
        p1.add(btn5,BorderLayout.NORTH);
        
        f.add(p1);
        
        btn1.setVisible(true);
        btn2.setVisible(true);
        btn3.setVisible(true);
        p1.setVisible(true);
        f.setVisible(true);
        
        
        

          btn1.addActionListener(new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                 try {
                         courseRegister = new courseRegistrationApp(c);
                     } catch (IOException ex) {
                         Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                     }
                
                
                        courseRegister.setVisible(true);
                        courseRegister.stdList();
                        courseRegister = null;
            
           }});
       
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
             bill b = new bill(c);
             b = null;
      
           }}); 
    }
 
    
    
}
