package student.registration.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class RemoveStudent extends JFrame implements ActionListener{

      JRadioButton name,id;
      JTextField text;
      JButton back,search,remove;
      JTable table1,table2,table3,table4;
      JScrollPane  jsp,jsp1,jsp2,jsp3;
      String sid="";
      
      RemoveStudent(String text1)
      {
          this.sid=text1;
          
          setLayout(null);
        
          JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
          title.setFont(new Font("Raleway",Font.BOLD,28));
          title.setBackground(Color.BLUE);
          title.setForeground(Color.WHITE);
          title.setOpaque(true);
          title.setHorizontalAlignment(JLabel.CENTER);
          title.setBounds(0,0,1000,70);
          add(title);
        
          JLabel admin=new JLabel("REMOVE STUDENT");
          admin.setFont(new Font("Raleway",Font.BOLD,22));
          admin.setBackground(Color.RED);
          admin.setForeground(Color.WHITE);
          admin.setOpaque(true);
          admin.setHorizontalAlignment(JLabel.CENTER);
          admin.setBounds(350,80,250,30);
          add(admin);
          
          
          try
          {
              Conn c=new Conn();
              ResultSet rs=c.s.executeQuery("select * from Students where Student_Id= '"+sid+"' ");
                   
              table1=new JTable();
              table1.setModel(DbUtils.resultSetToTableModel(rs));
              jsp=new JScrollPane(table1);
              jsp.setFont(new Font("Raleway",Font.BOLD,16));
              jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
              jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
              jsp.setBounds(10,140,950,130);
              add(jsp);
                    
              ResultSet rs1=c.s.executeQuery("select * from Parents where Student_Id= '"+sid+"' ");
              table2=new JTable();
              table2.setModel(DbUtils.resultSetToTableModel(rs1));
              jsp1=new JScrollPane(table2);
              jsp1.setFont(new Font("Raleway",Font.BOLD,16));
              jsp1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
              jsp1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
              jsp1.setBounds(10,280,950,130);
              add(jsp1);
          }
          catch(Exception e)
          {
              e.printStackTrace();
          }
          
          back=new JButton("BACK");
          back.setFont(new Font("Raleway",Font.BOLD,20));
          back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);
          back.setBounds(330,420,150,30);
          back.addActionListener(this);
          add(back);
          
         
          remove=new JButton("REMOVE");
          remove.setFont(new Font("Raleway",Font.BOLD,20));
          remove.setBackground(Color.BLUE);
          remove.setForeground(Color.WHITE);
          remove.setBounds(500,420,150,30);
          remove.addActionListener(this);
          add(remove); 
          
          setSize(1000,500);
          setLocation(100,100);
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
            if(ae.getSource()==remove)
            {
                
                
                
                    try{
                        Conn c=new Conn();
                        ResultSet rs=c.s.executeQuery("Select * from Students where Student_Id='"+sid+"'");
                        String query="delete from Students where Student_Id='"+sid+"'";
                        String query1="delete from Parents where Student_Id='"+sid+"'";
                        if(rs.next())
                        {
                            c.s.executeUpdate(query);
                            c.s.executeUpdate(query1);
                            JOptionPane.showMessageDialog(null,"Student Removed Successfully");
                            setVisible(false);
                            new HomePage().setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null,"Wrong Details Entered");
                        }
                    }catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                
            }
      }
      
    
      
      public static void main(String [] args)
      {
          new RemoveStudent("");
      }
      
}
