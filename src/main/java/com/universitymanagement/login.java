package com.universitymanagement;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import com.universitymanagement.Tools.tool;
import com.universitymanagement.User.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class login {

    private static String identifyNum,name,department,socialSecurityNum,id,pw;      //개인정보 임시 저장용 변수

    static boolean login_state;    //로그인 상태
    static char userType;       //사용자 유형
    
    //static int flag;

    private static student stemp;
    private static professor ptemp;
    private static hManager htemp;
    private static gManager gtemp;
    
    static JFrame f = new JFrame();
    static JPanel p1= new JPanel();
    static JPanel p2= new JPanel();
    static JPanel p3= new JPanel();
    
    static JTextField t1 = new JTextField();
    static JTextField t2 = new JTextField();
    static JTextField t3 = new JTextField();
    
    static JTextArea ja = new JTextArea();
    
    static JButton btn1 = new JButton();
    static Image image;
    static ImageIcon ico = new ImageIcon("./로고.png");

    static JPanel jp =new JPanel();
    static JLabel img = new JLabel(ico);
    static JLabel text = new JLabel("S");
    
    static JOptionPane popup=new JOptionPane();
    
    private static String currentLoginID;
    private static String currentLoginPW;
    private static String currentLoginNAME;
    
    public String getCurrentLoginID(){
        
        return currentLoginID;
    }

    public static String getCurrentLoginPW() {
        return currentLoginPW;
    }

    public static String getCurrentLoginNAME() {
        return currentLoginNAME;
    }

    
    
    public login() 
    {
       // login_state = false;
       // flag = 0;
        //image = ico.getImage();
    }
    
    public static void loginForm(student s, professor p,hManager h,gManager g){
        stemp = s;
        ptemp = p;
        htemp = h;
        gtemp = g;
        
        f.setLayout(new GridLayout(3,1));
        f.setTitle("대학정보시스템-로그인");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(400,600);
        
       
    
        
        p1.setBackground(Color.WHITE);
        p1.setLayout(new GridLayout());
        p2.setBackground(Color.PINK);
        p2.setLayout(new GridLayout(3,1));
        p3.setBackground(Color.WHITE);
        p3.setLayout(new GridLayout());
       
        //ja.setText("동의대학교 대학정보관리 시스템");
        text.setText("동의대학교 대학정보관리 시스템");
        t2.setText("아이디");
        t3.setText("비밀번호");
        
        
        btn1.setText("로그인");
        
        
        
        p1.add(text,BorderLayout.CENTER);
        
        p2.add(t2,BorderLayout.NORTH);
        p2.add(t3,BorderLayout.NORTH);
        p2.add(btn1,BorderLayout.NORTH);
        
        p3.add(img,BorderLayout.CENTER);
        
        f.add(p1,BorderLayout.NORTH);
        f.add(p2,BorderLayout.CENTER);
        f.add(p3,BorderLayout.SOUTH);
        f.setVisible(true);
        
        btn1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                id=t2.getText();
                pw=t3.getText();
                login(stemp,ptemp,htemp,gtemp);
                if(login_state==true){
                f.setVisible(false);
                } else{
                popup.showMessageDialog(null, "로그인에 실패하였습니다.");
                }
           }});
        
        
    }

    public static void login(student s, professor p,hManager h,gManager g){          //로그인
        
        switch (id.charAt(0)) {
            case 'S':
                for(int i = 0; i < s.registeredId.size() ; i++){
                    if(s.registeredId.get(i).equals(id) && s.registeredPw.get(i).equals(pw)){
                        System.out.println("로그인에 성공하였습니다.");
                        currentLoginNAME=s.registeredName.get(s.registeredId.indexOf(id));
                        currentLoginID=id;
                        currentLoginPW=pw;
                        login_state = true;
                        userType = id.charAt(0);
                        break;
                    }
                }   break;
            case 'P':
                for(int i = 0; i < p.registeredId.size() ; i++){
                    if(p.registeredId.get(i).equals(id) && p.registeredPw.get(i).equals(pw)){
                        System.out.println("로그인에 성공하였습니다.");
                        currentLoginNAME=p.registeredName.get(p.registeredId.indexOf(id));
                        currentLoginID=id;
                        currentLoginPW=pw;
                        login_state = true;
                        userType = id.charAt(0);
                        break;
                    }
                }   break;
            case 'H':
                for(int i = 0; i < h.registeredId.size() ; i++){
                    if( h.registeredId.get(i).equals(id) && h.registeredPw.get(i).equals(pw)){
                        System.out.println("로그인에 성공하였습니다.");
                        currentLoginNAME=h.registeredName.get(h.registeredId.indexOf(id));
                        currentLoginID=id;
                        currentLoginPW=pw;
                        login_state = true;
                        userType = id.charAt(0);
                        break;
                    }
                }   break;
            case 'G':
                for(int i = 0; i < g.registeredId.size() ; i++){
                    if(g.registeredId.get(i).equals(id) && g.registeredPw.get(i).equals(pw)){
                        System.out.println("로그인에 성공하였습니다.");
                        currentLoginNAME=g.registeredName.get(g.registeredId.indexOf(id));
                        currentLoginID=id;
                        currentLoginPW=pw;
                        login_state = true;
                        userType = id.charAt(0);
                        break;
                    }
                }   break;
            default: 
                break;
        }
               if(login_state==false) {
                    System.out.println("로그인에 실패하였습니다.");
                }
          
            
     }
    
    public static void logout(){
    userType=' ';
    login_state=false;
    currentLoginID="";
    currentLoginPW="";
    currentLoginNAME="";
    }
     
                             
        public static boolean register(student s, professor p,hManager h,gManager g
       , String IDN, String NAME,String DEPART,String SSN,String ID,String PW) throws IOException{    
            tool.modifyTextFile("./IdPw.txt");
            
            
        File f = new File("./IdPw.txt");
        if(f.exists()){
            System.out.println("파일이 이미 존재합니다."); 
        }else if(f.createNewFile()){
             System.out.println("파일을 생성합니다.");
        }
        
        FileOutputStream output=new FileOutputStream("./IdPw.txt",true);
        OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
        BufferedWriter out=new BufferedWriter(writer);    
          
    
      //  System.out.println("학번/교번:");
        identifyNum = IDN;
        
     //   System.out.println("이름:");
        name = NAME;
       
  //      System.out.println("학과:");
        department = DEPART;
        
     //   System.out.println("주민등록번호:");
        socialSecurityNum  = SSN; 
        
    //    System.out.println("아이디:");
        id = ID;
        
       // System.out.println("비밀번호:");
        pw = SSN.substring(0, 6);
        //pw = SSN;
        
       
        String str[] = tool.getTextedData("./IdPw.txt");
        for(int i=0;i<=str.length-6;i+=6){
            if(ID.equals(str[i+4])){
                popup.showMessageDialog(null, "이미 등록된 사용자입니다. 사용자의 학번을 확인해주세요.");
                System.out.println("이미 등록된 사용자입니다. 사용자의 학번을 확인해주세요.");
                return false;
            }
        }
        
        
        
        

        switch (ID.charAt(0)) { //등록하려는 사용자(교수,학생,학사 담당자, 수업 담당자)에 따라 분류하여 리스트에 추가
            case 'S':
                s.registeredIdentifyNum.add(identifyNum);
                s.registeredName.add(name);
                s.registeredDepartment.add(department);
                s.registeredSocialSecurityNum.add(socialSecurityNum);
                s.registeredId.add(id);
                s.registeredPw.add(pw);
                break;
            case 'P':
                p.registeredIdentifyNum.add(identifyNum);
                p.registeredName.add(name);
                p.registeredDepartment.add(department);
                p.registeredSocialSecurityNum.add(socialSecurityNum);
                p.registeredId.add(id);
                p.registeredPw.add(pw);
                break;
            case 'H':
                h.registeredIdentifyNum.add(identifyNum);
                h.registeredName.add(name);
                h.registeredDepartment.add(department);
                h.registeredSocialSecurityNum.add(socialSecurityNum);
                h.registeredId.add(id);
                h.registeredPw.add(pw);
                break;
            case 'G':
                g.registeredIdentifyNum.add(identifyNum);
                g.registeredName.add(name);
                g.registeredDepartment.add(department);
                g.registeredSocialSecurityNum.add(socialSecurityNum); 
                g.registeredId.add(id);
                g.registeredPw.add(pw);
                break;
            default:
                popup.showMessageDialog(null, "허용되지 않은 사용자 유형입니다.");
                System.out.println("허용되지 않은 사용자 유형입니다.");
                return false;         
        }
        
        int flag=0;


        
        for(int i=0;i<s.registeredIdentifyNum.size();i++){
            if(flag==0){
                out.append(s.registeredIdentifyNum.get(i)+","+s.registeredName.get(i)+","+s.registeredDepartment.get(i)+","+s.registeredSocialSecurityNum.get(i)+","+ s.registeredId.get(i)+","+s.registeredPw.get(i)); 
                flag=1;
            }else {
            out.append(","+s.registeredIdentifyNum.get(i)+","+s.registeredName.get(i)+","+s.registeredDepartment.get(i)+","+s.registeredSocialSecurityNum.get(i)+","+ s.registeredId.get(i)+","+s.registeredPw.get(i)); 
            }   
            }
        
        for(int i=0;i<p.registeredIdentifyNum.size();i++){
            if(flag==0){
               out.append(p.registeredIdentifyNum.get(i)+","+p.registeredName.get(i)+","+p.registeredDepartment.get(i)+","+p.registeredSocialSecurityNum.get(i)+","+ p.registeredId.get(i)+","+p.registeredPw.get(i)); 
            flag=1;
            }else {
               out.append(","+p.registeredIdentifyNum.get(i)+","+p.registeredName.get(i)+","+p.registeredDepartment.get(i)+","+p.registeredSocialSecurityNum.get(i)+","+ p.registeredId.get(i)+","+p.registeredPw.get(i)); 
             }   
        }
          
        for(int i=0;i<h.registeredIdentifyNum.size();i++){
             if(flag==0){
               out.append(h.registeredIdentifyNum.get(i)+","+h.registeredName.get(i)+","+h.registeredDepartment.get(i)+","+h.registeredSocialSecurityNum.get(i)+","+ h.registeredId.get(i)+","+h.registeredPw.get(i)); 
            flag=1;
            }else {
                out.append(","+h.registeredIdentifyNum.get(i)+","+h.registeredName.get(i)+","+h.registeredDepartment.get(i)+","+h.registeredSocialSecurityNum.get(i)+","+ h.registeredId.get(i)+","+h.registeredPw.get(i)); 
             }     
        }
        
        for(int i=0;i<g.registeredIdentifyNum.size();i++){
               if(flag==0){
               out.append(g.registeredIdentifyNum.get(i)+","+g.registeredName.get(i)+","+g.registeredDepartment.get(i)+","+g.registeredSocialSecurityNum.get(i)+","+ g.registeredId.get(i)+","+g.registeredPw.get(i)); 
            flag=1;
            }else {
               out.append(","+g.registeredIdentifyNum.get(i)+","+g.registeredName.get(i)+","+g.registeredDepartment.get(i)+","+g.registeredSocialSecurityNum.get(i)+","+ g.registeredId.get(i)+","+g.registeredPw.get(i)); 
             }      
        }
       
        
        //out.append("");
        out.close(); 
        popup.showMessageDialog(null, "사용자 등록완료");
        return true;
      }
        
        public static void loginClickListener(){
        }
        
        
}
