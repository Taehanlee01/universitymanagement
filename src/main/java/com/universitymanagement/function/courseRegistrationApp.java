/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.universitymanagement.function;
import com.universitymanagement.Tools.tool;
import com.universitymanagement.course;
import com.universitymanagement.login;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class courseRegistrationApp extends javax.swing.JFrame {
    private DefaultTableModel courseListModel;
    private JLabel statusLabel;
    private JTable  jtable = new JTable();
    private int selectedRow = -1;
    
    private login login = new login();
    
    private course c;
     
    private int length=0;
    
    private JOptionPane popup=new JOptionPane();

    /**
     * Creates new form CourseRegistrationApp
     */
    public courseRegistrationApp(course course) throws IOException{
      
       c = course;
       
       // 강의 목록 초기화
        initializeCourses(course);


        // 강의 목록 스크롤 가능하도록 JScrollPane으로 감싸기
        JScrollPane courseScrollPane = new JScrollPane(jtable);

 
        // "Select Course" 버튼 및 이벤트 핸들러 설정
        JButton selectButton = new JButton("수강 신청");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                selectedRow = jtable.getSelectedRow();

                if (selectedRow != -1) {
                        String selValue = (String)jtable.getValueAt(selectedRow,1);
                        String patch = "./강의목록/"+selValue+".txt";
                       // System.out.println(patch);
                    
                        
                   
                    
                        
                        FileOutputStream output;
                    try {
                        output = new FileOutputStream(patch,true);
                        OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
                        BufferedWriter out=new BufferedWriter(writer);
                        
                        if(tool.getTextedData(patch).length==0){                     
                                        //학생명단에 추가
                             
                             for(int i=0;i<c.courseName.size();i++){            //리스트에 추가
                                 if(c.courseName.get(i).equals(selValue)){                    
                             
                                     if(c.courseMax.get(i)>0){
                                         c.getCourseStudent().get(i).add(login.getCurrentLoginID());
                                         out.append(login.getCurrentLoginID()+","+login.getCurrentLoginNAME()+",*,"); 
                                          //popup.showMessageDialog(null, c.courseName.get(i)+"에 성공적으로 수강 신청하였습니다.");
                                          statusLabel.setText(c.courseName.get(i)+"에 성공적으로 수강 신청하였습니다.");
                                     }
                                     break;
                                 }
                             }
                             
                        }else {
                            
                            for(int i=0;i<c.courseName.size();i++){            //리스트에 추가
                                 if(c.courseName.get(i).equals(selValue)){
                                    
                             String[] txtedString = tool.getTextedData(patch);
                             List<String> txtedList = new ArrayList<>(Arrays.asList(txtedString));
                             length = txtedString.length;
                             
                                     if(c.courseMax.get(i)>length && !txtedList.contains(login.getCurrentLoginID())){
                                         c.getCourseStudent().get(i).add(login.getCurrentLoginID());
                                         out.append(","+login.getCurrentLoginID()+","+login.getCurrentLoginNAME()+",*,*");
                                         statusLabel.setText(c.courseName.get(i)+"에 성공적으로 수강 신청하였습니다.");
                                         
                                          //popup.showMessageDialog(null, c.courseName.get(i)+"에 성공적으로 수강 신청하였습니다.");
                                     } else {
                                         if(txtedList.contains(login.getCurrentLoginID())){
                                              statusLabel.setText("이미 수강신청한 과목입니다."); 
                                         }else {
                                              statusLabel.setText("수강 신청 실패. 해당 강의가 이미 만석입니다."); 
                                         }
                            
                                     }
                                     break;
                                 }
                             }   
                        }
                        
                         
                        out.close();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(courseRegistrationApp.class.getName()).log(Level.SEVERE, null, ex);
                        System.out.println("error");
                    } catch (UnsupportedEncodingException ex) {
                        Logger.getLogger(courseRegistrationApp.class.getName()).log(Level.SEVERE, null, ex);
                         System.out.println("error");
                    } catch (IOException ex) {
                        Logger.getLogger(courseRegistrationApp.class.getName()).log(Level.SEVERE, null, ex);
                         System.out.println("error");
                    }
        
                          
                } else {
                    statusLabel.setText("강의를 선택해주세요.");
                }
                
                
            
            }});

        
        
        // 상태 메시지를 표시할 JLabel
        statusLabel = new JLabel();

        // 레이아웃 설정
        setLayout(new BorderLayout());
        add(courseScrollPane, BorderLayout.CENTER);
        add(selectButton, BorderLayout.SOUTH);
        add(statusLabel, BorderLayout.NORTH);

        // 프레임 설정
        setTitle("수강 신청 프로그램");
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE);
        pack();
        setSize(800, 600); // 프레임 크기 조절
        setResizable(true); // 크기 조절 가능하도록 설정
        setLocationRelativeTo(null); // 화면 중앙에 위치
        setVisible(true);
    }
    
    

    private void initializeCourses(course course) {
          
            courseListModel = new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "강좌번호", "강좌이름", "담당학과", "담당교수","학점","강좌설명 ","최대인원","최소인원"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false ,false ,false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
           
           
           jtable.setModel(courseListModel);
          
           

        for(int i=0;i<course.courseNumber.size();i++){
            Vector v = new Vector();
            v.add(course.courseNumber.get(i));
            v.add(course.courseName.get(i));
            v.add(course.courseDepartment.get(i));
            v.add(course.courseProfessor.get(i));
            v.add(course.courseCredit.get(i));  
            v.add(course.courseExplanation.get(i));
            v.add(course.courseMax.get(i));
            v.add(course.courseMin.get(i));
            courseListModel.addRow(v);
        }
       
   
    }
    
    public void stdList(){
        for(int i=0;i<c.getCourseStudent().size();i++){
             for(int j=0;j<c.getCourseStudent().get(i).size();j++){ 
       // System.out.println(c.getCourseStudent().get(i).get(j));       
             }
        }
     }
    


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
   
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
