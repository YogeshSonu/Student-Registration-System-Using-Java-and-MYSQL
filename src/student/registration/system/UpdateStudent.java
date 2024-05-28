package student.registration.system;
import java.sql.ResultSet;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class UpdateStudent extends JFrame implements ActionListener{
    
    
    JTextField text;
    JButton search,back;
    JRadioButton name,id;
    UpdateStudent()
    {
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
          title.setFont(new Font("Raleway",Font.BOLD,28));
          title.setBackground(Color.BLUE);
          title.setForeground(Color.WHITE);
          title.setOpaque(true);
          title.setHorizontalAlignment(JLabel.CENTER);
          title.setBounds(0,0,600,70);
          add(title);
        
          JLabel admin=new JLabel("UPDATE STUDENT DETAILS");
          admin.setFont(new Font("Raleway",Font.BOLD,22));
          admin.setBackground(Color.RED);
          admin.setForeground(Color.WHITE);
          admin.setOpaque(true);
          admin.setHorizontalAlignment(JLabel.CENTER);
          admin.setBounds(150,80,320,30);
          add(admin);
        
          
          JLabel select=new JLabel("SELECT :");
          select.setFont(new Font("Raleway",Font.BOLD,18));
          select.setBounds(20,130,100,30);
          add(select);
          
          id=new JRadioButton("STUDENT ID");
          id.setFont(new Font("Raleway",Font.BOLD,16));
          id.setBounds(120,130,140,30);
          id.addActionListener(this);
          add(id);
          
          name=new JRadioButton("STUDENT NAME");
          name.setFont(new Font("Raleway",Font.BOLD,16));
          name.setBounds(260,130,180,30);
          name.addActionListener(this);
          add(name);
          
          ButtonGroup search1=new ButtonGroup();
          search1.add(id);
          search1.add(name);
          
          JLabel eid=new JLabel("ENTER DETAILS HERE:");
          eid.setFont(new Font("Raleway",Font.BOLD,18));
          eid.setBounds(30,180,350,30);
          add(eid);
          
          text=new JTextField();
          text.setFont(new Font("Raleway",Font.BOLD,20));
          text.setBounds(280,180,270,30);
          add(text);
          
          search=new JButton("NEXT");
          search.setFont(new Font("Raleway",Font.BOLD,18));
          search.setBackground(Color.GREEN);
          search.setForeground(Color.BLACK);
          search.setBounds(280,250,110,30);
          search.addActionListener(this);
          add(search);
          
          back=new JButton("BACK");
          back.setFont(new Font("Raleway",Font.BOLD,20));
          back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);
          back.setBounds(160,250,110,30);
          back.addActionListener(this);
          add(back);
          
        setSize(600,330);
        setLocation(250,150);
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
            if(text.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter Details");
            }
            else
            {
                String text1=text.getText();
                if(id.isSelected())
                {
                    try
                    {
                
                        Conn c=new Conn();
                        ResultSet rs=c.s.executeQuery("select * from Students where Student_Id='"+text1+"'");
                        if(rs.next())
                        {
                            JOptionPane.showMessageDialog(null, "Record Found");
                            setVisible(false);
                            new UpdateStudent1(text1).setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Record Not Found");
                        }   
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else if(name.isSelected())
                {
                    String id="";
                    try
                    {
                        
                        Conn c=new Conn();
                        ResultSet rs=c.s.executeQuery("select * from Students where Student_Name='"+text1+"'");
                        while(rs.next())
                        {
                             id=rs.getString("Student_Id");
                        }
                        ResultSet rs1=c.s.executeQuery("select * from Students where Student_Id='"+id+"'");
                        if(rs1.next())
                        {
                            JOptionPane.showMessageDialog(null, "Record Found");
                            setVisible(false);
                            new UpdateStudent1(id).setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Record Not Found");
                        }
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please Choose Option");
                }
           }
        }
    }
    
    public static void main(String [] args)
    {
        new UpdateStudent();
    }
}
