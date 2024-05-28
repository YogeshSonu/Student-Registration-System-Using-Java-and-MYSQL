package student.registration.system;
import java.awt.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.sql.*;
import java.awt.event.*;

public class ShowAdmin extends JFrame implements ActionListener{
    
    JTable table1;
    JButton back;
    
    ShowAdmin()
    {
        
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Raleway",Font.BOLD,28));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,0,900,70);
        add(title);
        
        JLabel admin=new JLabel("SHOW ALL ADMINS");
        admin.setFont(new Font("Raleway",Font.BOLD,22));
        admin.setBackground(Color.RED);
        admin.setForeground(Color.WHITE);
        admin.setOpaque(true);
        admin.setHorizontalAlignment(JLabel.CENTER);
        admin.setBounds(300,75,250,30);
        add(admin);
        
        
        table1=new JTable();
        
        try
        {
            Conn c=new Conn();
            ResultSet rs=c.s.executeQuery("select * from admin");
            table1.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        table1.setBackground(Color.WHITE);
        JScrollPane  jsp=new JScrollPane(table1);
        jsp.setFont(new Font("Raleway",Font.BOLD,16));
        jsp.setBounds(10,120,850,200);
        jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jsp.setBackground(Color.WHITE);
        add(jsp);
        
        
        back=new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(350,325,150,30);
        back.addActionListener(this);
        add(back);
        
        setSize(900,400);
        setLocation(150,100);
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
    }
    
    public static void main(String[] args)
    {
        new ShowAdmin();
    }
    
}


