
package com.universitymanagement.User;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.universitymanagement.Tools.tool;
import static com.universitymanagement.Tools.tool.modifyTextFile;
import com.universitymanagement.login;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;

 
/**
 *
 * @author smjjj
 */
public class hManager extends javax.swing.JFrame{
    private DefaultTableModel model;
    private int selectedRow = -1;
    private student stemp;
    private professor ptemp;
  //  private hManager htemp;
    private gManager gtemp;
    
    
    
    public ArrayList<String> registeredIdentifyNum = new ArrayList<>();           //학번/교번 리스트
    public ArrayList<String> registeredName = new ArrayList<>();                  //이름 리스트
    public ArrayList<String> registeredDepartment = new ArrayList<>();            //학과 리스트
    public ArrayList<String> registeredSocialSecurityNum = new ArrayList<>();     //주민등록번호 리스트
    public ArrayList<String> registeredId = new ArrayList<>();                    //아이디 리스트
    public ArrayList<String> registeredPw = new ArrayList<>();   
    
    JOptionPane popup=new JOptionPane();
   
     public static ArrayList datafile() {
        ArrayList<String> lines = new ArrayList<>();
        String[] line = tool.getTextedData("./IdPw.txt");
        for(int i=0;i<line.length;i++){
            lines.add(line[i]);
        }
        return lines;
    }
     
     public static String getIdentifyNum(int line){
        ArrayList<String> Data = datafile();
        return Data.get(6*line-6);
    }
     
    public static String getName(int line){
        ArrayList<String> Data = datafile();
        return Data.get(6*line-5);
    }
    
    public static String getDepartment(int line){
        ArrayList<String> Data = datafile();
        return Data.get(6*line-4);
    }
    
    public static String getSocialSecurityNum(int line){
        ArrayList<String> Data = datafile();
        return Data.get(6*line-3);
    }
    
     public static String getId(int line){
        ArrayList<String> Data = datafile();
        return Data.get(6*line-2);
    }
    
    public void fillData() {
        model = (DefaultTableModel) jTable1.getModel();
        ArrayList<String> Data = datafile();
       
        for (int i = 0; i <datafile().size()/6; i++) {
            Vector v = new Vector();       
            v.add(getIdentifyNum(i+1));
            v.add(getName(i+1));
            v.add(getDepartment(i+1));
            v.add(getSocialSecurityNum(i+1));
            v.add(getId(i+1).charAt(0));
            model.addRow(v);
        }
    }
    
    public hManager(student s,professor p,gManager g) {
     
        init();
        
        initComponents();
        fillData();
        
        stemp=s;
        ptemp=p;
       // htemp=h;
        gtemp=g; 
        
        
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
                if(str[i+4].charAt(0) == 'H'){
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
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 600));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "학번/교수번호", "이름", "학과", "주민등록번호", "사용자 유형"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
        }

        jLabel1.setText("입력 :");

        jTextField1.setText("");

        jButton1.setText("검색");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("추가");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("삭제");
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(51, 51, 51)
                                .addComponent(jButton3)
                                .addGap(60, 60, 60)
                                .addComponent(jButton4)))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  
   String inputText = jTextField1.getText();
   boolean flag=false;

    // 입력된 값이 비어있으면 처리하지 않음
    if (!inputText.isEmpty()) {
        // 입력된 값을 ','를 기준으로 나누어 배열에 저장
        String[] values = inputText.split(",");

         //형식에 맞게 입력하였는지 검사
         if(values.length==4){
             
             String[] options = {"학생", "교수", "학사담당자", "수업담당자"};
        int selectedType = JOptionPane.showOptionDialog(this, "등록할 유저의 타입을 선택하세요.", "유저 타입", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
    
        
        
       //학생정보의 마지막 인덱스까지 사용자 등록 함수로 넘겨줌
       try {
           switch(selectedType){
               case 0:
                   flag = login.register(stemp,ptemp,this,gtemp,values[0],values[1],values[2],values[3],"S"+values[0],values[3]);
                   break;
               case 1:
                   flag = login.register(stemp,ptemp,this,gtemp,values[0],values[1],values[2],values[3],"P"+values[0],values[3]);
                   break;
               case 2:
                   flag = login.register(stemp,ptemp,this,gtemp,values[0],values[1],values[2],values[3],"H"+values[0],values[3]);
                   break;
               case 3:
                   flag = login.register(stemp,ptemp,this,gtemp,values[0],values[1],values[2],values[3],"G"+values[0],values[3]);
                   break;
           }  

       } catch (IOException ex) {
           Logger.getLogger(hManager.class.getName()).log(Level.SEVERE, null, ex);
       }
        
       model.setRowCount(0);
       fillData();
       
       
        // 텍스트 필드 초기화
        jTextField1.setText("");
       
         } else {
             popup.showMessageDialog(null, "형식에 맞게 입력해주세요. (학번/교번),(이름),(학과),(주민등록번호)");
         }

         
         
    }
  
    
    
    
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        int selectedRow = jTable1.getSelectedRow();

    // 선택된 행이 있는지 확인
    if (selectedRow != -1) {
     
        String str = model.getValueAt(selectedRow, 4)+""+model.getValueAt(selectedRow, 0);
        System.out.println(str);
        int i=0;
        switch(str.charAt(0)){
            case 'S':
                i = stemp.registeredId.indexOf(str);
                stemp.registeredIdentifyNum.remove(i);
                stemp.registeredName.remove(i);
                stemp.registeredDepartment.remove(i);
                stemp.registeredSocialSecurityNum.remove(i);
                stemp.registeredId.remove(i);
                stemp.registeredPw.remove(i);
                break;
                
            case 'P':
                i = ptemp.registeredId.indexOf(str);
                ptemp.registeredIdentifyNum.remove(i);
                ptemp.registeredName.remove(i);
                ptemp.registeredDepartment.remove(i);
                ptemp.registeredSocialSecurityNum.remove(i);
                ptemp.registeredId.remove(i);
                ptemp.registeredPw.remove(i);
                 break;
                 
            case 'H':
                i = registeredId.indexOf(str);
                registeredIdentifyNum.remove(i);
                registeredName.remove(i);
                registeredDepartment.remove(i);
                registeredSocialSecurityNum.remove(i);
                registeredId.remove(i);
                registeredPw.remove(i);   
                 break;
                
            case 'G':  
                i = gtemp.registeredId.indexOf(str);
                gtemp.registeredIdentifyNum.remove(i);
                gtemp.registeredName.remove(i);
                gtemp.registeredDepartment.remove(i);
                gtemp.registeredSocialSecurityNum.remove(i);
                gtemp.registeredId.remove(i);
                gtemp.registeredPw.remove(i);
                 break;    
        }
         model.removeRow(selectedRow);
            try {
                tool.modifyTextFile("./IdPw.txt");
           } catch (IOException ex) {
                Logger.getLogger(hManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        stemp.reWriteData();
        ptemp.reWriteData();
        reWriteData();
        gtemp.reWriteData();
        
        stemp.init();
        ptemp.init();
        init();
        gtemp.init();
        
      
        System.gc();
        
    } else {
        // 선택된 행이 없는 경우에는 메시지 출력 등 필요한 처리 수행
        System.out.println("삭제할 행을 선택하세요.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     selectedRow = jTable1.getSelectedRow();

    // 선택된 행이 있는지 확인
    if (selectedRow != -1) {
        // 수정할 열을 사용자에게 선택하도록 함
        String[] options = {"학번/교수번호", "이름", "학과", "주민등록번호"};
        int selectedColumn = JOptionPane.showOptionDialog(this, "수정할 열을 선택하세요.", "열 선택", JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

        if (selectedColumn != -1) {
            // 수정할 값을 사용자에게 입력받음
            String newValue = JOptionPane.showInputDialog(this, "새로운 값을 입력하세요.");

            // 사용자가 취소하지 않았다면 수정
            if (newValue != null) {
                // 선택된 행의 해당 열 값을 수정
               
                String selVal = (String) model.getValueAt(selectedRow, selectedColumn);
                String selValId = model.getValueAt(selectedRow, 4)+""+model.getValueAt(selectedRow, 0);
                System.out.println(selValId);
                model.setValueAt(newValue, selectedRow, selectedColumn);
                int i=0;
                
                        
                switch (selValId.charAt(0)){
                    case 'S':
                        System.out.println("b");
                       i = stemp.registeredId.indexOf(selValId);
                       if(selectedColumn==0){
                           stemp.registeredIdentifyNum.set(i, newValue);
                           stemp.registeredId.set(i, "S"+newValue);
                       }else if(selectedColumn==1){
                           stemp.registeredName.set(i, newValue);
                       }else if(selectedColumn==2){
                           stemp.registeredDepartment.set(i, newValue);
                       }else if(selectedColumn==3){
                           stemp.registeredSocialSecurityNum.set(i, newValue);
                       }
                       break;
                    case 'P':
                        i = ptemp.registeredId.indexOf(selValId);
                       if(selectedColumn==0){
                           ptemp.registeredIdentifyNum.set(i, newValue);
                           ptemp.registeredId.set(i, "P"+newValue);
                       }else if(selectedColumn==1){
                           ptemp.registeredName.set(i, newValue);
                       }else if(selectedColumn==2){
                           ptemp.registeredDepartment.set(i, newValue);
                       }else if(selectedColumn==3){
                           ptemp.registeredSocialSecurityNum.set(i, newValue);
                       }
                       break;
                    
                    case 'H':
                        i = registeredId.indexOf(selValId);
                       if(selectedColumn==0){
                           registeredIdentifyNum.set(i, newValue);
                           registeredId.set(i, "H"+newValue);
                       }else if(selectedColumn==1){
                           registeredName.set(i, newValue);
                       }else if(selectedColumn==2){
                           registeredDepartment.set(i, newValue);
                       }else if(selectedColumn==3){
                           registeredSocialSecurityNum.set(i, newValue);
                       }
                       break;
                            
                    case 'G':   
                        i = gtemp.registeredId.indexOf(selValId);
                       if(selectedColumn==0){
                           gtemp.registeredIdentifyNum.set(i, newValue);
                           gtemp.registeredId.set(i, "G"+newValue);
                       }else if(selectedColumn==1){
                           gtemp.registeredName.set(i, newValue);
                       }else if(selectedColumn==2){
                           gtemp.registeredDepartment.set(i, newValue);
                       }else if(selectedColumn==3){
                           gtemp.registeredSocialSecurityNum.set(i, newValue);
                       }
                       break;
                }
                
               
            try {
                tool.modifyTextFile("./IdPw.txt");
           } catch (IOException ex) {
                Logger.getLogger(hManager.class.getName()).log(Level.SEVERE, null, ex);
            }

                 stemp.reWriteData();
                 ptemp.reWriteData();
                 reWriteData();
                 gtemp.reWriteData();
                 
                 stemp.init();
                 ptemp.init();
                 init();
                 gtemp.init();
                 
               
                 System.gc();
                
                
                
            }
        }
    } else {
        // 선택된 행이 없는 경우에는 메시지 출력
        JOptionPane.showMessageDialog(this, "수정할 행을 선택하세요.", "알림", JOptionPane.INFORMATION_MESSAGE);
    }
       
    
    
    /*    try {
            modifyTextFile("./");
        } catch (IOException ex) {
            Logger.getLogger(hManager.class.getName()).log(Level.SEVERE, null, ex);
        }
*/
    }//GEN-LAST:event_jButton4ActionPerformed
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String searchText = jTextField1.getText();

    // 텍스트 필드에 입력된 검색어가 있는 경우에만 처리
    if (!searchText.isEmpty()) {
        // DefaultTableModel에서 모든 행 제거
        model.setRowCount(0);
        // 검색어와 일치하는 행을 테이블에 추가
        for (int i = 0; i < datafile().size()/6-1; i++) {
            String value1 = getIdentifyNum(i + 1);
            String value2 = getName(i + 1);
            String value3 = getDepartment(i + 1);
            String value4 = getSocialSecurityNum(i + 1);

            // 검색어가 어느 한 열에라도 포함되어 있다면 해당 행을 테이블에 추가
            if (value1.contains(searchText) || value2.contains(searchText) || value3.contains(searchText) || value4.contains(searchText)) {
                Vector v = new Vector();
                v.add(getIdentifyNum(i + 1));
                v.add(getName(i + 1));
                v.add(getDepartment(i + 1));
                v.add(getSocialSecurityNum(i + 1));

                model.addRow(v);
            }
        }

        // 검색 결과가 없는 경우 메시지 출력
        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "검색 결과가 없습니다.", "검색 결과", JOptionPane.INFORMATION_MESSAGE);
        }
    } else {
        // 검색어가 입력되지 않은 경우 현재 표시되어있는 모든 행을 지우고 전체 행을 다시 추가
        model.setRowCount(0);
        fillData();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public String[] getHmanagerList(){
        String hmList[]= new String[registeredName.size()];
        System.out.println("<학생목록>");
        for(int i=0; i<registeredName.size();i++)
        {
        hmList[i] ="이름 : " + registeredName.get(i) + " 학번 : " + registeredIdentifyNum.get(i) + " 학과 : " + registeredDepartment.get(i);
        } 
        return hmList;
    }

    public void reWriteData(){
        try {
             
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
    
    
    
    public static void main(String args[]) { 
        //new Haksa().setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}

