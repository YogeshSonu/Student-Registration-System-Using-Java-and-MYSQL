package student.registration.system;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class ForgotPassword extends JFrame implements ActionListener{
    
    JTextField usernamefield;
    JPasswordField passwordfield,cpasswordfield;
    JCheckBox show;
    JButton reset,back,submit;
    
    ForgotPassword()
    {
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Raleway",Font.BOLD,28));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,0,700,70);
        add(title);
        
        JLabel label=new JLabel("FORGOT PASSWORD");
        label.setFont(new Font("Raleway",Font.BOLD,22));
        label.setBackground(Color.RED);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(190,90,300,30);
        add(label);
        
        JLabel username=new JLabel("USER-NAME :");
        username.setFont(new Font("Raleway",Font.BOLD,20));
        username.setBounds(120,150,150,30);
        add(username);
        
        JLabel password=new JLabel("NEW PASSWORD :");
        password.setFont(new Font("Raleway",Font.BOLD,20));
        password.setBounds(90,200,190,30);
        add(password);
        
        JLabel cpassword=new JLabel("CONFIRM NEW PASSWORD :");
        cpassword.setFont(new Font("Raleway",Font.BOLD,20));
        cpassword.setBounds(10,250,290,30);
        add(cpassword);
        
        usernamefield=new JTextField();
        usernamefield.setFont(new Font("Raleway",Font.BOLD,16));
        usernamefield.setBounds(260,150,400,30);
        add(usernamefield);
        
        passwordfield=new JPasswordField();
        passwordfield.setFont(new Font("Raleway",Font.BOLD,18));
        passwordfield.setBounds(280,200,380,30);
        passwordfield.setEchoChar('*');
        add(passwordfield);
        
        cpasswordfield=new JPasswordField();
        cpasswordfield.setFont(new Font("Raleway",Font.BOLD,18));
        cpasswordfield.setBounds(300,250,360,30);
        cpasswordfield.setEchoChar('*');
        add(cpasswordfield);
        
        show=new JCheckBox("show password");
        show.setFont(new Font("Raleway",Font.BOLD,12));
        show.setBackground(Color.WHITE);
        show.setBounds(550,280,150,30);
        show.addActionListener(this);
        add(show);
        
        reset=new JButton("RESET");
        reset.setFont(new Font("Raleway",Font.BOLD,20));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setBounds(50,320,100,30);
        reset.addActionListener(this);
        add(reset);
        
        submit=new JButton("SUBMIT");
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250,320,150,30);
        submit.addActionListener(this);
        add(submit);
        
        
        back=new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(450,320,150,30);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(700,400);
        setLocation(100,100);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==reset)
        {
            usernamefield.setText("");
            passwordfield.setText("");
            cpasswordfield.setText("");
        }
        if(ae.getSource()==back)
        {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
        if(ae.getSource()==show)
        {
            if(show.isSelected())
            {
                passwordfield.setEchoChar((char)0);
                cpasswordfield.setEchoChar((char)0);
            }
            else
            {
                passwordfield.setFont(new Font("Raleway",Font.BOLD,18));
                passwordfield.setEchoChar('*');
                cpasswordfield.setFont(new Font("Raleway",Font.BOLD,18));
                cpasswordfield.setEchoChar('*');
            }
        }
        if(ae.getSource()==submit)
        {
            String username=usernamefield.getText();
            String password=passwordfield.getText();
            String cpassword=cpasswordfield.getText();
            
            if(username.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter the User Name");
            }
            else if(password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter the New Password");
            }
            else if(cpassword.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Confirm New Password");
            }
            else
            {
                if(password.equals(cpassword))
                {
                    Conn c=new Conn();
                    String query = "select * from login where Username='"+username+"'";
                    String query1 = "update admin set Password = '" +password+"' where Username = '" +username+"' ";
                    String query2 = "update login set Password = '" +password+"' where Username = '" +username+"' ";
                    try
                    {
                        ResultSet rs= c.s.executeQuery(query);
                        if(rs.next())
                        {
                            c.s.executeUpdate(query1);
                            c.s.executeUpdate(query2);
                            JOptionPane.showMessageDialog(null,"Password Changed Successfully");
                            setVisible(false);
                            new LoginPage().setVisible(true);
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "Username Does not Exist !!!!");
                        }
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Password and Confirm Pssword Does not Match");
                }
            }
        }
    }
    
    public static void main(String[] args)
    {
        new ForgotPassword();
    }
    
}

