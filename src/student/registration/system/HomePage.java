package student.registration.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame implements ActionListener{
    
    JButton adds,remove,logout,modify,show,search,addadmin,removeadmin,showadmin;
    
    HomePage()
    {
        
        
        setLayout(null);
        Font f=new Font("Raleway",Font.BOLD,20);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Raleway",Font.BOLD,32));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,0,900,100);
        add(title);
        
        JLabel label=new JLabel("HOME PAGE");
        label.setFont(new Font("Raleway",Font.BOLD,22));
        label.setBackground(Color.RED);
        label.setForeground(Color.WHITE);
        label.setOpaque(true);
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setBounds(390,110,150,30);
        add(label);
        
        ImageIcon home1=new ImageIcon(ClassLoader.getSystemResource("icon/home.png"));
        JLabel home=new JLabel(home1);
        home.setBounds(350,100,50,50);
        add(home);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icon/AddStudent.png"));
        adds=new JButton(i1);
        adds.setBounds(50,170,150,120);
        adds.addActionListener(this);
        add(adds);
        
        JLabel addstudent=new JLabel("ADD STUDENT");
        addstudent.setFont(f);
        addstudent.setBounds(60,300,180,30);
        add(addstudent);
        
        ImageIcon i2=new ImageIcon(ClassLoader.getSystemResource("icon/remove.jpg"));
        remove=new JButton(i2);
        remove.setBounds(270,170,150,120);
        remove.addActionListener(this);
        add(remove);
        
        JLabel removestudent=new JLabel("REMOVE STUDENT");
        removestudent.setFont(new Font("Raleway",Font.BOLD,18));
        removestudent.setBounds(260,300,180,30);
        add(removestudent);
        
        ImageIcon i3=new ImageIcon(ClassLoader.getSystemResource("icon/modify.jpg"));
        modify=new JButton(i3);
        modify.setBounds(710,170,150,120);
        modify.addActionListener(this);
        add(modify);
        
        JLabel updatestudent=new JLabel("UPDATE STUDENTS");
        updatestudent.setFont(f);
        updatestudent.setBounds(690,300,210,30);
        add(updatestudent);
        
        
        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("icon/showstudent.png"));
        show=new JButton(i4);
        show.setBounds(490,170,150,120);
        show.addActionListener(this);
        add(show);
        
        JLabel showstudent=new JLabel("SHOW STUDENTS");
        showstudent.setFont(f);
        showstudent.setBounds(480,300,180,30);
        add(showstudent);
        
        ImageIcon i5=new ImageIcon(ClassLoader.getSystemResource("icon/addAdmin.png"));
        addadmin=new JButton(i5);
        addadmin.setBounds(50,370,150,120);
        addadmin.addActionListener(this);
        add(addadmin);
        
        JLabel adadmin=new JLabel("ADD ADMIN");
        adadmin.setFont(f);
        adadmin.setBounds(70,500,200,30);
        add(adadmin);
        
        ImageIcon i6=new ImageIcon(ClassLoader.getSystemResource("icon/removeAdmin.png"));
        removeadmin=new JButton(i6);
        removeadmin.setBounds(270,370,150,120);
        removeadmin.addActionListener(this);
        add(removeadmin);
        
        JLabel removeadmin=new JLabel("REMOVE ADMIN");
        removeadmin.setFont(f);
        removeadmin.setBounds(270,500,200,30);
        add(removeadmin);
        
        ImageIcon i7=new ImageIcon(ClassLoader.getSystemResource("icon/showAdmin.png"));
        showadmin=new JButton(i7);
        showadmin.setBounds(490,370,150,120);
        showadmin.addActionListener(this);
        add(showadmin);
        
        JLabel showadmin=new JLabel("SHOW ADMIN");
        showadmin.setFont(f);
        showadmin.setBounds(500,500,200,30);
        add(showadmin);
        
        ImageIcon i8=new ImageIcon(ClassLoader.getSystemResource("icon/logout.png"));
        logout=new JButton(i8);
        logout.setBounds(710,370,150,120);
        logout.addActionListener(this);
        add(logout);
        
        JLabel logout=new JLabel("LOGOUT");
        logout.setFont(f);
        logout.setBounds(740,500,200,30);
        add(logout);
        
       getContentPane().setBackground(Color.CYAN);
       
        setSize(900,550);
        setLocation(100,100);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==logout)
        {
            setVisible(false);
            new LoginPage().setVisible(true);
        }
        if(ae.getSource()==adds)
        {
            setVisible(false);
            new AddStudent().setVisible(true);
        }
        
        if(ae.getSource()==remove)
        {
            setVisible(false);
            new RemoveStudent1().setVisible(true);
        }
        if(ae.getSource()==modify)
        {
            setVisible(false);
            new UpdateStudent().setVisible(true);
        }
        if(ae.getSource()==show)
        {
            setVisible(false);
            new ShowStudent().setVisible(true);
        }
        if(ae.getSource()==addadmin)
        {
            setVisible(false);
            new SignupPage(1).setVisible(true);
        }
        if(ae.getSource()==showadmin)
        {
            setVisible(false);
            new ShowAdmin().setVisible(true);
        }if(ae.getSource()==removeadmin)
        {
            setVisible(false);
            new RemoveAdmin().setVisible(true);
        }
    }
    
    public static void main(String [] args)
    {
        new HomePage();
    }
    
}


