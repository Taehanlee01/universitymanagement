package com.universitymanagement.User;

import java.util.ArrayList;

import com.universitymanagement.Tools.tool;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class student extends person{
    public ArrayList<String> registeredIdentifyNum = new ArrayList<>();           //학번/교번 리스트
    public ArrayList<String> registeredName = new ArrayList<>();                  //이름 리스트
    public ArrayList<String> registeredDepartment = new ArrayList<>();            //학과 리스트
    public ArrayList<String> registeredSocialSecurityNum = new ArrayList<>();     //주민등록번호 리스트
    public ArrayList<String> registeredId = new ArrayList<>();                    //아이디 리스트
    public ArrayList<String> registeredPw = new ArrayList<>();   
    


    public student(){
        init(); 
    }
    
    public void init(){
registeredIdentifyNum.clear();
    registeredName.clear();
    registeredDepartment.clear();
    registeredSocialSecurityNum.clear();
    registeredId.clear();
    registeredPw.clear();  
         try{
        String str[] = tool.getTextedData("./IdPw.txt");
        for(int i = 0; i <= str.length-6 ; i+=6)
                {
                if(str[i+4].charAt(0) == 'S'){
                registeredIdentifyNum.add(str[i]); 
                registeredName.add(str[i+1]); 
                registeredDepartment.add(str[i+2]); 
                registeredSocialSecurityNum.add(str[i+3]); 
                registeredId.add(str[i+4]); 
                registeredPw.add(str[i+5]); 
                }   
            }
            } catch (NullPointerException e){
                e.getStackTrace();
            }  
        
    }


    public String[] getStudentList(){
        String stList[]= new String[registeredName.size()];
        System.out.println("<학생목록>");
        for(int i=0; i<registeredName.size();i++)
        {
        stList[i] ="이름 : " + registeredName.get(i) + " 학번 : " + registeredIdentifyNum.get(i) + " 학과 : " + registeredDepartment.get(i);
        } 
        return stList;
    }
     
     
    public void reWriteData(){
        try {
            //tool.modifyTextFile("./IdPw.txt");
            
            File f = new File("./IdPw.txt");
            if(f.exists()){
                System.out.println("파일이 이미 존재합니다.");
            }else if(f.createNewFile()){
                System.out.println("파일을 생성합니다.");   
            }
            
            FileOutputStream output=new FileOutputStream("./IdPw.txt",true);
            OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
            BufferedWriter out=new BufferedWriter(writer);
            
            
            
            int flag=tool.getTextedData("./IdPw.txt").length;
            for(int i=0;i<registeredIdentifyNum.size();i++){
                if(flag==0){
                    out.append(registeredIdentifyNum.get(i)+","+registeredName.get(i)+","+registeredDepartment.get(i)+","+registeredSocialSecurityNum.get(i)+","+ registeredId.get(i)+","+registeredPw.get(i));
                    flag=1;
                }else {
                    out.append(","+registeredIdentifyNum.get(i)+","+registeredName.get(i)+","+registeredDepartment.get(i)+","+registeredSocialSecurityNum.get(i)+","+ registeredId.get(i)+","+registeredPw.get(i));
                }
            }
            out.close();
            writer.close();
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(person.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}
