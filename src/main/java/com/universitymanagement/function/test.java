package com.universitymanagement.function;

import com.universitymanagement.Tools.tool;
import com.universitymanagement.User.professor;
import com.universitymanagement.course;
import com.universitymanagement.login;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test extends JFrame {

    private JComboBox<String> lectureComboBox;
    private JTextField searchField;
    private JButton searchButton;
    private JButton modifyButton;
    private JTable studentTable;
    private String lectureListPath = "./강의목록";

    private String selectedLecturePath;
    
    public String selectedDepartmentProfessor;
     public String selectedDepartmentProfessorId;
    course c;
    
    private ArrayList<String> stdList = new ArrayList<>();  //학생리스트

    String selectedLecture;
    
    login login = new login();
    
    Vector v = new Vector();
    
    professor p = new professor();
    
    DefaultTableModel model;
    
    public test() {
        initComponents();
        updateComboBox();
        updateTable();
        try {
            c = new course();
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void initComponents() {
        setTitle("출석부");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        lectureComboBox = new JComboBox<>();
        lectureComboBox.setBounds(20, 20, 200, 30);
        add(lectureComboBox);

        searchField = new JTextField();
        searchField.setBounds(240, 20, 200, 30);
        add(searchField);

        searchButton = new JButton("검색");
        searchButton.setBounds(460, 20, 80, 30);
        
        modifyButton = new JButton("수정");
        modifyButton.setBounds(270, 375, 60, 30);
        
        
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });
        
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = studentTable.getSelectedRow();
                int selectedColumn = studentTable.getSelectedColumn();
      
                  if (selectedRow != -1) {
            // 수정할 값을 사용자에게 입력받음
            String newValue = JOptionPane.showInputDialog(this, "새로운 값을 입력하세요.");
            // 사용자가 취소하지 않았다면 수정
            if (newValue != null) {
                int index = 0; 
               if(selectedColumn==0){
                   index = stdList.indexOf(studentTable.getValueAt(selectedRow, 0));
                   stdList.set(index, newValue);
               }else if (selectedColumn==1){
                    index = stdList.indexOf(studentTable.getValueAt(selectedRow, 0));
                   stdList.set(index+1, newValue);
               }else if (selectedColumn==2){
                    index = stdList.indexOf(studentTable.getValueAt(selectedRow, 0));
                   stdList.set(index+2, newValue);
               }else if (selectedColumn==3){
                    index = stdList.indexOf(studentTable.getValueAt(selectedRow, 0));
                   stdList.set(index+3, newValue);
               }
               
               studentTable.setValueAt(newValue, selectedRow, selectedColumn);

                
                 int flag = 0;
    
                try {
                    tool.modifyTextFile("./강의목록/"+selectedLecture+".txt");
                } catch (IOException ex) {
                    Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
                }
                
        try (FileOutputStream output = new FileOutputStream("./강의목록/"+selectedLecture+".txt",true);
             OutputStreamWriter writer=new OutputStreamWriter(output,"UTF-8");
             BufferedWriter out=new BufferedWriter(writer);
                ){
            
             for(int i=0;i<stdList.size();i++){
                if(flag!=0){
                    out.append(","+stdList.get(i));
                }else{
                    out.append(stdList.get(i));
                    flag=1;
                }       
    }
             
        } catch (FileNotFoundException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(test.class.getName()).log(Level.SEVERE, null, ex);
        }   
               
               
                
                
                
                

                
            }
        }
                
                  
                  
                  
                  
                  
                  
            }
        });
        
        add(searchButton);
        add(modifyButton);
        
        

        studentTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(studentTable);
        scrollPane.setBounds(20, 70, 520, 300);
        add(scrollPane);

        lectureComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSelectedLecturePath();
                updateTable();
            }
        });

        setSize(600, 450);
        setLocationRelativeTo(null);
    }

 
    private void updateComboBox() {
     
        File directory = new File(lectureListPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                lectureComboBox.removeAllItems();
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        lectureComboBox.addItem(file.getName().replace(".txt", ""));
                    }
                }
            }
        }
    }

    private void updateSelectedLecturePath() {
        selectedLecture = Objects.requireNonNull(lectureComboBox.getSelectedItem()).toString();
        System.out.println(selectedLecture);
        selectedDepartmentProfessor = c.courseProfessor.get(c.courseName.indexOf(selectedLecture));
        System.out.println(selectedDepartmentProfessor);
        selectedLecturePath = lectureListPath + File.separator + selectedLecture + ".txt";
    }


    private void updateTable() {
    model = new DefaultTableModel();
    model.addColumn("학번");
    model.addColumn("이름");
    model.addColumn("취득 학점");
    model.addColumn("평점");

    try (BufferedReader reader = new BufferedReader(new FileReader(selectedLecturePath, StandardCharsets.UTF_8))) {
       System.out.println(selectedDepartmentProfessor +"="+login.getCurrentLoginNAME());
        if(selectedDepartmentProfessor.equals(login.getCurrentLoginNAME())){
           System.out.println("사용자일치");
        String line;
        while ((line = reader.readLine()) != null) {
            String[] students = line.split(",");
            for (int i = 0; i < students.length; i += 4) {
                if (i + 3 < students.length) {
                    String[] data = {students[i], students[i + 1], students[i + 2], students[i + 3]};
                    model.addRow(data);
                    stdList.add(students[i]);
                    stdList.add(students[i+1]);
                    stdList.add(students[i+2]);
                    stdList.add(students[i+3]);
                } else {
                    System.out.println("잘못된 형식의 데이터: " + line);
                }
            }
        }
        
        }
        
    } catch (IOException e) {
        e.printStackTrace();
    }
    studentTable.setModel(model);
}
    
    
    private void searchStudent() {
    String searchText = searchField.getText().trim().toLowerCase();
    model = new DefaultTableModel();
    model.addColumn("학번");
    model.addColumn("이름");
    model.addColumn("취득 학점");
    model.addColumn("평점");

    try (BufferedReader reader = new BufferedReader(new FileReader(selectedLecturePath, StandardCharsets.UTF_8))) {
         if(selectedDepartmentProfessor.equals(login.getCurrentLoginNAME())){
        
        String line;
        while ((line = reader.readLine()) != null) {
            String[] students = line.split(",");
            for (int i = 0; i < students.length; i += 4) {
                if (i + 3 < students.length) {
                    String[] data = {students[i], students[i + 1], students[i + 2], students[i + 3]};
                    // 검색어가 비어있거나 학번 또는 이름이 검색어와 일치하면 표시
                    if (searchText.isEmpty() || data[0].toLowerCase().contains(searchText) || data[1].toLowerCase().contains(searchText)) {
                        model.addRow(data);
                    }
                } else {
                    System.out.println("잘못된 형식의 데이터: " + line);
                }
            }
        }
         }
    } catch (IOException e) {
        e.printStackTrace();
    }

    studentTable.setModel(model);
}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new test().setVisible(true);
            }
        });
    }
}