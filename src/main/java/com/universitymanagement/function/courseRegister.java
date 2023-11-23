/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.universitymanagement.function;

import com.universitymanagement.Tools.tool;
import com.universitymanagement.course;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author smjjj
 */
public class courseRegister extends javax.swing.JFrame {
    private DefaultTableModel model;
    private int selectedRow = -1;
    
    private course c;
   
     public static ArrayList datafile() {
        ArrayList<String> lines = new ArrayList<>();
        String[] line = tool.getTextedData("./course.txt");
        for(int i=0;i<line.length;i++){
            lines.add(line[i]);
        }
        return lines;
    }
     
     public static String getClassnum(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-11);
    }
     
    public static String getClassname(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-10);
    }
    
    public static String getDepartment(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-9);
    }
    
    public static String getProfessor(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-8);
    }
       public static String getCredit(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-7);
    }
    
    public static String getDescription(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-6);
    }
    
    public static String getMax(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-5);
    }
    
    public static String getMin(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-4);
    }
    
     public static String getBill(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-3);
    }
    
        public static String getOpeningstatus(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-2);
    }
    
    public static String getOpeningrecord(int line){
        ArrayList<String> Data = datafile();
        return Data.get(11*line-1);
    } 
     

    public void fillData() {
        model = (DefaultTableModel) jTable1.getModel();
        ArrayList<String> Data = datafile();
       
        for (int i = 0; i <datafile().size()/11; i++) {
            Vector v = new Vector();       
            v.add(getClassnum(i+1));
            v.add(getClassname(i+1));
            v.add(getDepartment(i+1));
            v.add(getProfessor(i+1));
            v.add(getCredit(i+1));
            v.add(getDescription(i+1));
            v.add(getMax(i+1));
            v.add(getMin(i+1));
            v.add(getBill(i+1));
            v.add(getOpeningstatus(i+1));
            v.add(getOpeningrecord(i+1));
            model.addRow(v);
        }
    }
    /**
     * Creates new form gManager
     */
    public courseRegister() throws IOException {
        initComponents();
        fillData();
        c = new course();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTextField1.setText("jTextField1");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("한컴산뜻돋움", 0, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 204));
        jLabel1.setText("수강 관리 기능");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "강좌번호", "강좌이름", "담당학과", "담당교수","학점","강좌설명 ","최대인원","최소인원", "수강료(만원)", "개설여부", "개설전적"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
            jTable1.getColumnModel().getColumn(5).setResizable(false);
        }

        jButton2.setText("삭제");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("검색");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("수정");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("뒤로가기");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("등록");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addGap(91, 91, 91)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jButton3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton6)
                            .addGap(36, 36, 36)
                            .addComponent(jButton2)
                            .addGap(37, 37, 37)
                            .addComponent(jButton4)
                            .addGap(134, 134, 134)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 864, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton4)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:      // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

    // 선택된 행이 있는지 확인
    if (selectedRow != -1) {
        // DefaultTableModel에서 선택된 행 삭제
        model.removeRow(selectedRow);
    } else {
        // 선택된 행이 없는 경우에는 메시지 출력 등 필요한 처리 수행
        System.out.println("삭제할 행을 선택하세요.");
    }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
   String searchText = jTextField1.getText();

    // 텍스트 필드에 입력된 검색어가 있는 경우에만 처리
    if (!searchText.isEmpty()) {
        // DefaultTableModel에서 모든 행 제거
        model.setRowCount(0);
        // 검색어와 일치하는 행을 테이블에 추가
        for (int i = 0; i < datafile().size()/11-1; i++) {
            String value1 = getClassnum(i + 1);
            String value2 = getClassname(i + 1);
            String value3 = getDepartment(i + 1);
            String value4 = getProfessor(i + 1);
            String value5 = getCredit(i + 1);
            String value6 = getDescription(i + 1);
            String value7 = getMax(i + 1);
            String value8 = getMin(i + 1);
            String value9 = getBill(i + 1);
            String value10 = getOpeningstatus(i+1);
            String value11 = getOpeningrecord(i+1);

            // 검색어가 어느 한 열에라도 포함되어 있다면 해당 행을 테이블에 추가
            if (value1.contains(searchText) || value2.contains(searchText) || value3.contains(searchText) || value4.contains(searchText)
                    || value5.contains(searchText) || value6.contains(searchText)|| value7.contains(searchText)|| value8.contains(searchText) || value9.contains(searchText)|| value10.contains(searchText)|| value11.contains(searchText) ) {
                Vector v = new Vector();
                v.add(getClassnum(i + 1));
                v.add(getClassname(i + 1));
                v.add(getDepartment(i + 1));
                v.add(getProfessor(i + 1));
                v.add(getCredit(i + 1));
                v.add(getDescription(i + 1));
                v.add(getMax(i + 1));
                v.add(getMin(i + 1));
                v.add(getBill(i + 1));
                v.add(getOpeningstatus(i+1));
                v.add(getOpeningrecord(i + 1));


                model.addRow(v);
            }      
        }// TODO add your handling code here:
    }else {
        // 검색어가 입력되지 않은 경우 현재 표시되어있는 모든 행을 지우고 전체 행을 다시 추가
        model.setRowCount(0);
        fillData();
    }
    
    }//GEN-LAST:event_jButton3ActionPerformed
       
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  int selectedRow = jTable1.getSelectedRow();
        if (selectedRow != -1) {
        // 수정할 열을 사용자에게 선택하도록 함
        String[] options = { "강좌번호", "강좌이름", "담당학과", "담당교수","학점","강좌설명 ","최대인원","최소인원", "수강료(만원)", "개설여부", "개설전적" };
        int selectedColumn = JOptionPane.showOptionDialog(this, "수정할 열을 선택하세요.", "열 선택", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (selectedColumn != -1) {
            // 수정할 값을 사용자에게 입력받음
            String newValue = JOptionPane.showInputDialog(this, "새로운 값을 입력하세요.");

            // 사용자가 취소하지 않았다면 수정
            if (newValue != null) {
                // 선택된 행의 해당 열 값을 수정
                model.setValueAt(newValue, selectedRow, selectedColumn);
            }
        }
    } else {
        // 선택된 행이 없는 경우에는 메시지 출력
        JOptionPane.showMessageDialog(this, "수정할 행을 선택하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
    }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
              setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        

        
        String inputText = jTextField1.getText();
    if (!inputText.isEmpty()) {
        FileOutputStream output = null;
            try {
                // 입력된 값을 ','를 기준으로 나누어 배열에 저장
                String[] values = inputText.split(",");
                output = new FileOutputStream("./course.txt",true);
                OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
                BufferedWriter out=new BufferedWriter(writer);
                out.append(","+values[0]);
                out.append(","+values[1]);
                out.append(","+values[2]);
                out.append(","+values[3]);
                out.append(","+values[4]);
                out.append(","+values[5]);
                out.append(","+values[6]);
                out.append(","+values[7]);
                out.append(","+values[8]);
                out.append(","+values[8]);
                out.append(","+values[9]);
                out.close();
                // 각각의 값을 Vector에 추가
                
                Vector v = new Vector();
                for (String value : values) {
                    v.add(value.trim());   
                }  
                
                c.courseNumber.add(values[0]);
                c.courseName.add(values[1]);
                c.courseDepartment.add(values[2]);
                c.courseProfessor.add(values[3]);
                c.courseCredit.add(values[4]);
                c.courseExplanation.add(values[5]);
                c.courseMax.add(parseInt(values[6]));
                c.courseMin.add(parseInt(values[7]));
                c.courseMoney.add(parseInt(values[8]));
                
                // DefaultTableModel에 Vector 추가   
                model.addRow(v);
                // 텍스트 필드 초기화
                jTextField1.setText("");
                
                //003,수치해석학,컴소,빈기철,4,수치해석,5,3
            } catch (FileNotFoundException ex) {
                Logger.getLogger(courseRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(courseRegister.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(courseRegister.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    output.close();
                } catch (IOException ex) {
                    Logger.getLogger(courseRegister.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
    }
  
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
               
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}