package student.registration.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;


public class LoginPage extends JFrame implements ActionListener{

    JTextField username;
    JPasswordField passwordfield;
    JButton login1,clear,signup,forgot,exit;
    JCheckBox show;
    
    LoginPage()
    {
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Raleway",Font.BOLD,22));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,10,500,50);
        add(title);
        
        JLabel login=new JLabel("ADMIN LOGIN");
        login.setFont(new Font("Raleway",Font.BOLD,22));
        login.setBackground(Color.RED);
        login.setForeground(Color.WHITE);
        login.setOpaque(true);
        login.setHorizontalAlignment(JLabel.CENTER);
        login.setBounds(140,70,200,30);
        add(login);
        
        JLabel user=new JLabel("USER NAME :");
        user.setFont(new Font("Raleway",Font.BOLD,18));
        user.setBounds(40,120,150,30);
        add(user);
        
        JLabel password=new JLabel("PASSWORD :");
        password.setFont(new Font("Raleway",Font.BOLD,18));
        password.setBounds(40,170,150,30);
        add(password);
        
        username=new JTextField();
        username.setFont(new Font("Raleway",Font.BOLD,16));
        username.setBounds(170,120,300,30);
        add(username);
        
        passwordfield=new JPasswordField();
        passwordfield.setFont(new Font("Raleway",Font.BOLD,18));
        passwordfield.setBounds(170,170,300,30);
        passwordfield.setEchoChar('*');
        add(passwordfield);
        
        show=new JCheckBox("show password");
        show.setFont(new Font("Raleway",Font.BOLD,12));
        show.setBackground(Color.WHITE);
        show.setBounds(350,200,150,30);
        show.addActionListener(this);
        add(show);
        
        login1=new JButton("LOGIN");
        login1.setFont(new Font("Raleway",Font.BOLD,20));
        login1.setBackground(Color.GREEN);
        login1.setForeground(Color.BLACK);
        login1.setBounds(180,230,100,30);
        login1.addActionListener(this);
        add(login1);
        
        clear=new JButton("RESET");
        clear.setFont(new Font("Raleway",Font.BOLD,20));
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.setBounds(320,230,100,30);
        clear.addActionListener(this);
        add(clear);
        
        signup=new JButton("SIGN UP");
        signup.setFont(new Font("Raleway",Font.BOLD,20));
        signup.setBackground(Color.BLUE);
        signup.setForeground(Color.WHITE);
        signup.setBounds(220,270,160,30);
        signup.addActionListener(this);
        add(signup);
        
        forgot=new JButton("FORGOT PASSWORD ? ");
        forgot.setFont(new Font("System",Font.BOLD,10));
        forgot.setBackground(Color.BLACK);
        forgot.setForeground(Color.WHITE);
        forgot.setBounds(10,270,150,30);
        forgot.addActionListener(this);
        add(forgot);
        
       exit=new JButton("EXIT");
       exit.setBackground(Color.BLACK);
       exit.setForeground(Color.WHITE);
       exit.setFont(new Font("Raleway",Font.BOLD,10));
       exit.setBounds(400,270,60,30);
       exit.addActionListener(this);
       add(exit);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(500,350);
        setLocation(200,200);
        setUndecorated(true);
        setVisible(true);
        
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==clear)
        {
            username.setText("");
            passwordfield.setText("");
        }
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        if(ae.getSource()==login1)
        {
         
            String user=username.getText();
            String password=passwordfield.getText();
            if(user.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter the User Name....");
            }
            else if(password.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Please Enter the Password....");
            }
            else
            {
                Conn c=new Conn();
                String query = "select * from login where Username='"+user+"' and Password ='"+password+"'";
                try
                {
                    ResultSet rs= c.s.executeQuery(query);
                    if(rs.next())
                    {
                        JOptionPane.showMessageDialog(null,"Login Successfully");
                         setVisible(false);
                         new HomePage().setVisible(true);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Wrong Details Entered");
                    }
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        if(ae.getSource()==signup)
        {
            setVisible(false);
            new SignupPage(0).setVisible(true);
        }
        if(ae.getSource()==forgot)
        {
            setVisible(false);
            new ForgotPassword().setVisible(true);
        }
        if(ae.getSource()==show)
        {
            if(show.isSelected())
            {
                passwordfield.setEchoChar((char)0);
            }
            else
            {
                passwordfield.setFont(new Font("Raleway",Font.BOLD,18));
                passwordfield.setEchoChar('*');
            }
        }
    }
    
    public static void main(String [] args)
    {
        new LoginPage();
    }
    
}



