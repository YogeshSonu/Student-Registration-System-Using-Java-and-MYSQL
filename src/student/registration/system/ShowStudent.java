package student.registration.system;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class ShowStudent extends JFrame implements ActionListener{
    
    JTable table1,table2;
    JButton back,search;
    
    ShowStudent()
    {
        
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Raleway",Font.BOLD,28));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,0,1150,70);
        add(title);
        
        JLabel admin=new JLabel("STUDENTS DETAILS");
        admin.setFont(new Font("Raleway",Font.BOLD,22));
        admin.setBackground(Color.RED);
        admin.setForeground(Color.WHITE);
        admin.setOpaque(true);
        admin.setHorizontalAlignment(JLabel.CENTER);
        admin.setBounds(420,75,250,30);
        add(admin);
        
        
        table1=new JTable();
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from Students");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane  jsp=new JScrollPane(table1);
        jsp.setFont(new Font("Raleway",Font.BOLD,16));
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBounds(10,110,1100,200);
        add(jsp);
        
        JLabel admin1=new JLabel("PARENTS DETAILS");
        admin1.setFont(new Font("Raleway",Font.BOLD,22));
        admin1.setBackground(Color.RED);
        admin1.setForeground(Color.WHITE);
        admin1.setOpaque(true);
        admin1.setHorizontalAlignment(JLabel.CENTER);
        admin1.setBounds(420,320,250,30);
        add(admin1);
        
        table2=new JTable();
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from Parents");
            table2.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        JScrollPane  jsp1=new JScrollPane(table2);
        jsp1.setFont(new Font("Raleway",Font.BOLD,16));
        jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp1.setBounds(10,360,1100,230);
        add(jsp1);
        
        back=new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(580,600,150,30);
        back.addActionListener(this);
        add(back);
        
        search=new JButton("PRINT");
        search.setFont(new Font("Raleway",Font.BOLD,20));
        search.setBackground(Color.GREEN);
        search.setForeground(Color.BLACK);
        search.setBounds(400,600,150,30);
        search.addActionListener(this);
        add(search);
        
        setSize(1150,680);
        setLocation(150,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new HomePage().setVisible(true);
        }
        if(ae.getSource()==search)
        {
            try{
                table1.print();
                table2.print();
            }catch(Exception e)
            {
                e.printStackTrace();
            }
            JOptionPane.showMessageDialog(null,"Details Printed Successfully");
        }
    }
    
    public static void main(String[] args)
    {
        new ShowStudent();
    }
    
}


