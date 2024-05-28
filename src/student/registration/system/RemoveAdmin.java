package student.registration.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;

public class RemoveAdmin extends JFrame implements ActionListener{


    JTextField text;
    JButton search,back,remove;
    JTable table1;
    JScrollPane jsp;
    RemoveAdmin()
    {
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
          title.setFont(new Font("Raleway",Font.BOLD,28));
          title.setBackground(Color.BLUE);
          title.setForeground(Color.WHITE);
          title.setOpaque(true);
          title.setHorizontalAlignment(JLabel.CENTER);
          title.setBounds(0,0,800,70);
          add(title);
        
          JLabel admin=new JLabel("REMOVE ADMIN");
          admin.setFont(new Font("Raleway",Font.BOLD,22));
          admin.setBackground(Color.RED);
          admin.setForeground(Color.WHITE);
          admin.setOpaque(true);
          admin.setHorizontalAlignment(JLabel.CENTER);
          admin.setBounds(300,80,250,30);
          add(admin);
        
          JLabel username=new JLabel("ENTER USER-NAME HERE:");
          username.setFont(new Font("Raleway",Font.BOLD,18));
          username.setBounds(30,140,250,30);
          add(username);
        
          text=new JTextField();
          text.setFont(new Font("Raleway",Font.BOLD,20));
          text.setBounds(290,140,300,30);
          add(text);
          
          search=new JButton("SEARCH");
          search.setFont(new Font("Raleway",Font.BOLD,18));
          search.setBackground(Color.GREEN);
          search.setForeground(Color.BLACK);
          search.setBounds(630,140,110,30);
          search.addActionListener(this);
          add(search);
          
          back=new JButton("BACK");
          back.setFont(new Font("Raleway",Font.BOLD,20));
          back.setBackground(Color.BLACK);
          back.setForeground(Color.WHITE);
          back.setBounds(260,300,150,30);
          back.addActionListener(this);
          add(back);
          
         
          remove=new JButton("REMOVE");
          remove.setFont(new Font("Raleway",Font.BOLD,20));
          remove.setBackground(Color.BLUE);
          remove.setForeground(Color.WHITE);
          remove.setBounds(430,300,150,30);
          remove.addActionListener(this);
          add(remove);
          
          
        setSize(800,380);
        setLocation(100,100);
        setUndecorated(true);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==search)
        {
            String text1=text.getText();
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("select * from Admin where Username= '"+text1+"' ");
                    
                table1=new JTable();
                table1.setModel(DbUtils.resultSetToTableModel(rs));
                jsp=new JScrollPane(table1);
                jsp.setFont(new Font("Raleway",Font.BOLD,16));
                jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                jsp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                jsp.setBounds(10,200,750,80);
                add(jsp);
                
                int r=table1.getRowCount();
                if(r>=1)
                {
                    JOptionPane.showMessageDialog(null,"Record Found");
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Record Not Found");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        if(ae.getSource()==back)
        {
            setVisible(false);
            new HomePage().setVisible(true);
        }
        if(ae.getSource()==remove)
        {
            String text1=text.getText();
            try
            {
                Conn c=new Conn();
                ResultSet rs=c.s.executeQuery("Select * from admin where Username='"+text1+"'");
                String query="delete from admin where Username='"+text1+"'";
                String query1="delete from login where Username='"+text1+"'";
                if(rs.next())
                {
                    c.s.executeUpdate(query);
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"Admin Account Removed Successfully");
                    setVisible(false);
                    new HomePage().setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Wrong Details Entered");
                }
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static void main(String[] args)
    {
        new RemoveAdmin();
    }
}
