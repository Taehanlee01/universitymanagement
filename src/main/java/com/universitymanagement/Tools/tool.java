package com.universitymanagement.Tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class tool {   //클래스에서 공통적으로 쓰이는 메서드들을 모아놓음
        public tool(){
        }

            public static String[] getTextedData(String parameter){    //파일에 저장된 데이터를 리스트에 읽어드림
            try{           
                File f = new File(parameter);
        if(f.exists()){
        }else if(f.createNewFile()){ 
        }
                
        FileInputStream input=new FileInputStream(parameter);
        InputStreamReader reader=new InputStreamReader(input,"UTF-8");
        BufferedReader in=new BufferedReader(reader);
  
         
            
            String[] str = in.readLine().split(","); 
             
            in.close();
         
                 return str;
        } catch (NullPointerException | IOException e){
            e.getStackTrace();
             String[] str = new String[0]; 
            return str; 
        }   
    }
        
        
           
            
            
    public static void modifyTextFile(String paramater) throws IOException{   
        
         LocalDateTime now = LocalDateTime.now(); 
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");  
         String formatedNow = now.format(formatter);
        
           File folder = new File( paramater+"_old");

           if (!folder.exists()) {
		try{
		    folder.mkdir();
	        } 
	        catch(Exception e){
		    e.getStackTrace();
		}             
         }
           String patch = paramater+"_old/"+formatedNow+".txt";
          
           File file = new File( paramater);
           File newFile = new File(patch);
           
           Files.copy(file.toPath(), newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);    
           
          while(true){  
           if (!file.exists()) {
               System.out.println("삭제완료");
		     break;
         }else{
               file.delete();     
           }
          }
           
    }
        

    public static String getUserInput() {       //유저의 입력을 받는 메서드
        String inputLine = null;
        try{
            InputStreamReader reader=new InputStreamReader(System.in,"EUC-KR");     //넷빈즈로 옮길때 주석 해제
            //InputStreamReader reader=new InputStreamReader(System.in,"UTF-8");     //넷빈즈로 옮길때 주석 처리
            BufferedReader is = new BufferedReader(reader);                                     //위의 주석내용 미시행시 한글 깨짐
            inputLine = is.readLine();
            if(inputLine.length() == 0) return null;
        } catch (IOException e){
        System.out.println("IOException"+ e);
        }
        return inputLine;
}
    
}
