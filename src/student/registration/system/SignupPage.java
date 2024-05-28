package student.registration.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SignupPage extends JFrame implements ActionListener{

    JButton submit,reset,back;
    JCheckBox show;
    JPasswordField cpasswordfield,passwordfield;
    JTextField usernamefield,namefield,agefield;
    int i;
    
    SignupPage(int i)
    {
        this.i=i;
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Raleway",Font.BOLD,28));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,0,800,70);
        add(title);
        
        JLabel admin=new JLabel("NEW ADMIN ACCOUNT");
        admin.setFont(new Font("Raleway",Font.BOLD,22));
        admin.setBackground(Color.RED);
        admin.setForeground(Color.WHITE);
        admin.setOpaque(true);
        admin.setHorizontalAlignment(JLabel.CENTER);
        admin.setBounds(250,80,300,30);
        add(admin);
        
        JLabel name=new JLabel("NAME :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(180,150,150,30);
        add(name);
        
        JLabel age=new JLabel("AGE :");
        age.setFont(new Font("Raleway",Font.BOLD,20));
        age.setBounds(190,200,150,30);
        add(age);
        
        JLabel username=new JLabel("USER-NAME :");
        username.setFont(new Font("Raleway",Font.BOLD,20));
        username.setBounds(140,250,150,30);
        add(username);
        
        JLabel password=new JLabel("PASSWORD :");
        password.setFont(new Font("Raleway",Font.BOLD,20));
        password.setBounds(140,300,150,30);
        add(password);
        
        JLabel cpassword=new JLabel("CONFIRM PASSWORD :");
        cpassword.setFont(new Font("Raleway",Font.BOLD,20));
        cpassword.setBounds(40,350,230,30);
        add(cpassword);
        
        namefield=new JTextField();
        namefield.setFont(new Font("Raleway",Font.BOLD,16));
        namefield.setBounds(270,150,450,30);
        add(namefield);
        
        agefield=new JTextField();
        agefield.setFont(new Font("Raleway",Font.BOLD,16));
        agefield.setBounds(270,200,450,30);
        add(agefield);
        
        usernamefield=new JTextField();
        usernamefield.setFont(new Font("Raleway",Font.BOLD,16));
        usernamefield.setBounds(280,250,450,30);
        add(usernamefield);
        
        passwordfield=new JPasswordField();
        passwordfield.setFont(new Font("Raleway",Font.BOLD,18));
        passwordfield.setBounds(280,300,450,30);
        passwordfield.setEchoChar('*');
        add(passwordfield);
        
        cpasswordfield=new JPasswordField();
        cpasswordfield.setFont(new Font("Raleway",Font.BOLD,18));
        cpasswordfield.setBounds(280,350,450,30);
        cpasswordfield.setEchoChar('*');
        add(cpasswordfield);
        
        show=new JCheckBox("show password");
        show.setFont(new Font("Raleway",Font.BOLD,12));
        show.setBackground(Color.WHITE);
        show.setBounds(620,380,150,30);
        show.addActionListener(this);
        add(show);
        
        reset=new JButton("RESET");
        reset.setFont(new Font("Raleway",Font.BOLD,20));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setBounds(210,410,100,30);
        reset.addActionListener(this);
        add(reset);
        
        submit=new JButton("SUBMIT");
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBounds(330,410,150,30);
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(500,410,150,30);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(800,500);
        setLocation(100,100);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==reset)
        {
            namefield.setText("");
            agefield.setText("");
            usernamefield.setText("");
            passwordfield.setText("");
            cpasswordfield.setText("");
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
        if(ae.getSource()==back)
        {
            if(i==1)
            {
                setVisible(false);
                new HomePage().setVisible(true);
            }
            else
            {
                 setVisible(false);
                 new LoginPage().setVisible(true);
            }
        }
        if(ae.getSource()==submit)
        {
            String name=namefield.getText();
            String age=agefield.getText();
            String username=usernamefield.getText();
            String password=passwordfield.getText();
            String cpassword=cpasswordfield.getText();
            if(name.equals(""))
            {
                
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(age.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Age is Required");
            }
            else if(username.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Username is Required");
            }
            else if(password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Password is Required");
            }
            else if(cpassword.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill Confirm Password Field");
            }
            else
            {
                 if(password.equals(cpassword))
                 {
                    try
                    {
                        Conn c=new Conn();
                        String query1 ="insert into admin values('"+name+"', '"+age+"', '"+username+"', '"+password+"')";
                        String query2 ="insert into login values('"+username+"', '"+password+"')";
                        c.s.executeUpdate(query1);
                        c.s.executeUpdate(query2);
                        
                        JOptionPane.showMessageDialog(null,"Account Created Successfully");
                        if(i==1)
                        {
                            setVisible(false);
                            new HomePage().setVisible(true);
                        }
                        else
                        {
                            setVisible(false);
                            new LoginPage().setVisible(true);
                        }
                    }catch(Exception e)
                    {
                        System.out.println(e);
                    }
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(null, "Password and Confirm Password Does not Match");
                 }
            }
        }
    }
                        
    public static void main(String [] args)
    {
        new SignupPage(0);
    }
}
