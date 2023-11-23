package com.universitymanagement;

import com.universitymanagement.function.courseRegistrationApp;
import com.universitymanagement.function.test;
import com.universitymanagement.User.hManager;
import com.universitymanagement.User.professor;
import com.universitymanagement.function.courseRegister;
import com.universitymanagement.function.bill;
import com.universitymanagement.User.gManager;
import com.universitymanagement.User.hManager;
import com.universitymanagement.User.professor;
import com.universitymanagement.User.student;
import java.awt.BorderLayout;
import java.awt.Color;
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

public class main  
{
    static student s = new student();
    static professor p = new professor();
    static gManager g = new gManager();
    static hManager h = new hManager(s,p,g);
    
    static JFrame f = new JFrame();
    static JPanel p1= new JPanel();
    
    static JButton btn1 = new JButton();
    static JButton btn2 = new JButton();
    static JButton btn3 = new JButton();
    static JButton btn4 = new JButton();
    static JButton btn5 = new JButton();
    
    static JOptionPane popup=new JOptionPane();
    
    static menu menu = new menu();;
    
    static course c;
    static courseRegistrationApp courseRegister;
    
    public static void main( String[] args ) throws IOException
    {

        c = new course();
        

        
        f.setLayout(new GridLayout(1,1));
        f.setTitle("대학정보시스템-매인");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,600);
      
        p1.setBackground(new java.awt.Color(102,204,255));
        p1.setLayout(new GridLayout(5,1,0,30)); 
        p1.setBorder(BorderFactory.createEmptyBorder(30 , 10 , 30 , 10));
        
        btn1.setText("로그인");
        btn2.setText("학생매뉴");
        btn3.setText("교수매뉴");
        btn4.setText("학사담당자매뉴");
        btn5.setText("수업담당자매뉴");
        
        p1.add(btn1,BorderLayout.NORTH);
        p1.add(btn2,BorderLayout.NORTH);
        p1.add(btn3,BorderLayout.NORTH);
        p1.add(btn4,BorderLayout.NORTH);
        p1.add(btn5,BorderLayout.NORTH);
        
        btn1.addActionListener(new ActionListener(){   
            public void actionPerformed(ActionEvent e){
                 if(login.login_state==false){
                     login.f.setVisible(true);
                 }else if(login.login_state==true){
                    login.logout();
                }
           }});
       
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                 if(login.userType=='S'){
                     menu.f.setVisible(true);
                     
                        
                    }else{
                    popup.showMessageDialog(null, "권한이 없습니다. 로그인 상태 혹은 사용자 권한을 확인해주싶시오.");
                }
                 
           }});
         
        btn3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 if(login.userType=='P'){
                        //menu = new menu();
                       // menu = null;
                       new test().setVisible(true);
                    }else{
                    popup.showMessageDialog(null, "권한이 없습니다. 로그인 상태 혹은 사용자 권한을 확인해주싶시오.");
                }
                 
           }});
          
        btn4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                 if(login.userType=='H'){
                     new hManager(s,p,g).setVisible(true);
                    }else{
                    popup.showMessageDialog(null, "권한이 없습니다. 로그인 상태 혹은 사용자 권한을 확인해주싶시오.");
                }
           }});
           
        
        btn5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                   if(login.userType=='G'){
                       try {
                           new courseRegister().setVisible(true);
                       } catch (IOException ex) {
                           Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                       }
                    }else{
                    popup.showMessageDialog(null, "권한이 없습니다. 로그인 상태 혹은 사용자 권한을 확인해주싶시오.");
                }
           }});
        
        f.add(p1,BorderLayout.CENTER);
        f.setVisible(true);
      
        login.loginForm(s,p,h,g);
        
         while(true){
            if(login.login_state==true){
            btn1.setText("로그아웃");
        }else{btn1.setText("로그인");}
         }
        
    }
}
