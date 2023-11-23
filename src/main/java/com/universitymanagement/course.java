package com.universitymanagement;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.util.ArrayList;
import com.universitymanagement.Tools.tool;
import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jasuj
 */
public class course {
    
     public static tool tool = new tool();
  
     public static ArrayList<String> courseNumber;    //강좌번호
     public static ArrayList<String> courseName;      //강좌이름
     public static ArrayList<String> courseDepartment;     //강좌담당학과
     public static ArrayList<String> courseProfessor;       //과목담당교수
     public static ArrayList<String> courseCredit;       //강좌학점수
     public static ArrayList<String> courseExplanation;       //과목설명
     public static ArrayList<Integer> courseMax;       //과목최대인원
     public static ArrayList<Integer> courseMin;       //과목최소인원
     
     private static ArrayList<ArrayList> courseStudent;   //수강학생목록
     
     private static ArrayList<ArrayList> courseStudentScore;   //수강학생성적목록
     
     public static ArrayList<Integer> courseMoney = new ArrayList<>();     //수강료
     
     public static ArrayList<String> courseOpeningstatus= new ArrayList<>();     //수강료
     
     public static ArrayList<String> courseOpeningrecord = new ArrayList<>();     //수강료
    
    //전산학과 전자공학과 화학공학과 기계공학과 항공우주공학과
     
      public void reloadCourse(){ 
      }
     
     public course() throws IOException{
      courseNumber = new ArrayList<>();    //강좌번호
      courseName = new ArrayList<>();      //강좌이름
      courseDepartment = new ArrayList<>();     //강좌담당학과
      courseProfessor = new ArrayList<>();       //과목담당교수
      courseCredit = new ArrayList<>();       //강좌학점수
      courseExplanation = new ArrayList<>();       //과목설명
      courseMax = new ArrayList<>();       //과목최대인원
      courseMin = new ArrayList<>();       //과목최소인원
      
      courseStudent = new ArrayList<>();
      
      courseMoney = new ArrayList<>();   //수강료
      
      courseOpeningstatus = new ArrayList<>();     //수강료
     
      courseOpeningrecord  = new ArrayList<>();     //수강료
         
         
         
                String patch="./course.txt";
                String str[] = tool.getTextedData(patch);
                
                 if( str.length==0){
        }else{
               
       
        for(int i = 0; i <= str.length-11 ; i+=11)
                {
          courseNumber.add(str[i]);
          courseName.add(str[i+1]);
          courseDepartment.add(str[i+2]);
          courseProfessor.add(str[i+3]);
          courseCredit.add(str[i+4]);
          courseExplanation.add(str[i+5]);
          courseMax.add(parseInt(str[i+6]));
          courseMin.add(parseInt(str[i+7]));
          courseMoney.add(parseInt(str[i+8]));
          courseOpeningstatus.add(str[i+8]);
          courseOpeningrecord.add(str[i+9]);
          
          
          
          
          patch="./강의목록/"+str[i+1]+".txt";
          
          File f = new File(patch);
        if(f.exists()){
           // System.out.println("파일이 이미 존재합니다."); 
        }else try {
            if(f.createNewFile()){
               // System.out.println("파일을 생성합니다.");
            } } catch (IOException ex) {
              Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
          }
        
       
        if( tool.getTextedData(patch)==null){
        }else{
            ArrayList al = new ArrayList();
            String[] strToList = tool.getTextedData(patch);
            for(int j=0;j<strToList.length;j++){
                 al.add(strToList[j]);
            }
             courseStudent.add(al);
             
        }
   
            }    
        
         }
        
     }


    public static ArrayList<ArrayList> getCourseStudent() {
        return courseStudent;
    }
     
 
     
     
     
     
     public static void createCourse(){
         
         System.out.println("강좌번호:");
           courseNumber.add(tool.getUserInput());
           
         System.out.println("강좌이름:");
          courseName.add(tool.getUserInput());
          
         System.out.println("강좌담당학과:");
         courseDepartment.add(tool.getUserInput());
         
         System.out.println("강좌학점수:");
          courseCredit.add(tool.getUserInput());
          
         System.out.println("강좌담당교수:");
          courseProfessor.add(tool.getUserInput());
          
         System.out.println("강좌설명:");
          courseExplanation.add(tool.getUserInput());
     }
     
     
     
     //대해서는  강좌  번호,  강좌  이름 담당  학과 학점  수  및  강좌에  대한  간단한  설명이  제공될  수  있어야  한다
}
