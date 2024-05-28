package student.registration.system;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.toedter.calendar.JDateChooser;

public class AddStudent extends JFrame implements ActionListener{

    JButton submit,reset,back;
    JTextField pphonefield,mnamefield,idfield,namefield,emailfield,mobilefield,classfield,fnamefield;
    JTextArea addressfield;
    JDateChooser date;
    JRadioButton male,female;
    JComboBox Relegion,Category,BloodGroup,Occupation;
    ButtonGroup gendergroup;
    
    AddStudent()
    {
        setLayout(null);
        
        JLabel title=new JLabel("STUDENT MANAGEMENT SYSTEM");
        title.setFont(new Font("Raleway",Font.BOLD,28));
        title.setBackground(Color.BLUE);
        title.setForeground(Color.WHITE);
        title.setOpaque(true);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setBounds(0,0,1200,70);
        add(title);
        
        JLabel admin=new JLabel("ADD NEW STUDENT");
        admin.setFont(new Font("Raleway",Font.BOLD,22));
        admin.setBackground(Color.RED);
        admin.setForeground(Color.WHITE);
        admin.setOpaque(true);
        admin.setHorizontalAlignment(JLabel.CENTER);
        admin.setBounds(450,80,300,30);
        add(admin);
        
        JLabel id=new JLabel("STUDENT ID :");
        id.setFont(new Font("Raleway",Font.BOLD,20));
        id.setBounds(40,150,150,30);
        add(id);
        
        JLabel relegion= new JLabel("RELEGION :");
        relegion.setFont(new Font("Raleway",Font.BOLD,20));
        relegion.setBounds(600,150,200,30);
        add(relegion);
        
        JLabel name=new JLabel("STUDENT NAME :");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(40,200,180,30);
        add(name);
        
        JLabel category= new JLabel("CATEGORY : ");
        category.setFont(new Font("Raleway",Font.BOLD,20));
        category.setBounds(600,200,200,30);
        add(category);
        
        JLabel dob=new JLabel("DATE OF BIRTH :");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(40,250,180,30);
        add(dob);
        
        JLabel blood= new JLabel("BLOOD GROUP : ");
        blood.setFont(new Font("Raleway",Font.BOLD,20));
        blood.setBounds(600,250,200,30);
        add(blood);
        
        JLabel gender=new JLabel("GENDER :");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(40,300,150,30);
        add(gender);
        
        JLabel parent=new JLabel("PARENTS DETAILS");
        parent.setFont(new Font("Raleway",Font.BOLD,22));
        parent.setBackground(Color.RED);
        parent.setForeground(Color.WHITE);
        parent.setOpaque(true);
        parent.setHorizontalAlignment(JLabel.CENTER);
        parent.setBounds(750,300,230,30);
        add(parent);
        
        JLabel email=new JLabel("E-MAIL :");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(40,350,150,30);
        add(email);
        
        JLabel fname= new JLabel("FATHER NAME : ");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(600,350,200,25);
        add(fname);
        
        JLabel phone=new JLabel("MOBILE NO :");
        phone.setFont(new Font("Raleway",Font.BOLD,20));
        phone.setBounds(40,400,150,30);
        add(phone);
        
        JLabel mname= new JLabel("MOTHER NAME : ");
        mname.setFont(new Font("Raleway",Font.BOLD,20));
        mname.setBounds(600,400,200,25);
        add(mname);
        
        JLabel standard=new JLabel("CLASS :");
        standard.setFont(new Font("Raleway",Font.BOLD,20));
        standard.setBounds(40,450,150,30);
        add(standard);
        
        JLabel pphone= new JLabel("CONTACT NO : ");
        pphone.setFont(new Font("Raleway",Font.BOLD,20));
        pphone.setBounds(600,450,200,25);
        add(pphone);
        
        JLabel address=new JLabel("ADDRESS :");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(40,500,150,30);
        add(address);
        
        JLabel foccup= new JLabel("FATHER OCCUPATIONS : ");
        foccup.setFont(new Font("Raleway",Font.BOLD,20));
        foccup.setBounds(600,500,250,25);
        add(foccup);
        
        idfield=new JTextField();
        idfield.setFont(new Font("Raleway",Font.BOLD,16));
        idfield.setBounds(190,150,300,30);
        add(idfield);
        
        String valrelegion[]={"SELECT","Hindu","Muslim","Sikh","Christian","Jain","Other"};
        Relegion=new JComboBox(valrelegion);
        Relegion.setFont(new Font("Raleway",Font.BOLD,16));
        Relegion.setBounds(730,150,400,30);
        Relegion.setBackground(Color.WHITE);
        add(Relegion);
        
        namefield=new JTextField();
        namefield.setFont(new Font("Raleway",Font.BOLD,16));
        namefield.setBounds(220,200,300,30);
        add(namefield);
        
        String valcategory[]={"SELECT","General","OBC","ST","SC","Other"};
        Category=new JComboBox(valcategory);
        Category.setFont(new Font("Raleway",Font.BOLD,16));
        Category.setBounds(730,200,400,30);
        Category.setBackground(Color.WHITE);
        add(Category);
        
        date=new JDateChooser();
        date.setBounds(220,250,300,30);
        date.setFont(new Font("Raleway",Font.BOLD,16));
        date.setForeground(Color.BLUE);
        add(date);
        
        String valblood[]={"SELECT","O+","B+","AB+","AB-","Other"};
        BloodGroup=new JComboBox(valblood);
        BloodGroup.setFont(new Font("Raleway",Font.BOLD,16));
        BloodGroup.setBounds(780,250,350,30);
        BloodGroup.setBackground(Color.WHITE);
        add(BloodGroup);
        
        male=new JRadioButton("Male");
        male.setBounds(170,300,90,30);
        male.setFont(new Font("Raleway",Font.BOLD,16));
        male.setBackground(Color.WHITE);
        add(male);
        
        female=new JRadioButton("Female");
        female.setBounds(260,300,100,30);
        female.setFont(new Font("Raleway",Font.BOLD,16));
        female.setBackground(Color.WHITE);
        add(female);
        
        
        gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);
        
        emailfield=new JTextField();
        emailfield.setFont(new Font("Raleway",Font.BOLD,18));
        emailfield.setBounds(140,350,370,30);
        add(emailfield);
        
        fnamefield=new JTextField();
        fnamefield.setFont(new Font("Raleway",Font.BOLD,18));
        fnamefield.setBounds(770,350,360,30);
        add(fnamefield);
        
        mobilefield=new JTextField();
        mobilefield.setFont(new Font("Raleway",Font.BOLD,18));
        mobilefield.setBounds(180,400,340,30);
        add(mobilefield);
        
        mnamefield=new JTextField();
        mnamefield.setFont(new Font("Raleway",Font.BOLD,18));
        mnamefield.setBounds(770,400,360,30);
        add(mnamefield);
        
        classfield=new JTextField();
        classfield.setFont(new Font("Raleway",Font.BOLD,18));
        classfield.setBounds(130,450,380,30);
        add(classfield);
        
        pphonefield=new JTextField();
        pphonefield.setFont(new Font("Raleway",Font.BOLD,18));
        pphonefield.setBounds(770,450,360,30);
        add(pphonefield);
        
        addressfield=new JTextArea();
        addressfield.setFont(new Font("Raleway",Font.BOLD,18));
        addressfield.setBounds(170,500,300,100);
        addressfield.setBackground(Color.CYAN);
        add(addressfield);
        
        String valoccupation[]={"SELECT","Salaried","Self-Employed","BusinessMan","Retired","Other"};
        Occupation=new JComboBox(valoccupation);
        Occupation.setBounds(850,500,280,30);
        Occupation.setFont(new Font("Raleway",Font.BOLD,18));
        Occupation.setBackground(Color.WHITE);
        add(Occupation);
        
        reset=new JButton("RESET");
        reset.setFont(new Font("Raleway",Font.BOLD,20));
        reset.setBackground(Color.BLACK);
        reset.setForeground(Color.WHITE);
        reset.setBounds(360,620,100,30);
        reset.addActionListener(this);
        add(reset);
        
        submit=new JButton("SUBMIT");
        submit.setFont(new Font("Raleway",Font.BOLD,20));
        submit.setBackground(Color.BLUE);
        submit.setForeground(Color.WHITE);
        submit.setBounds(480,620,150,30);
        submit.addActionListener(this);
        add(submit);
        
        back=new JButton("BACK");
        back.setFont(new Font("Raleway",Font.BOLD,20));
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(650,620,150,30);
        back.addActionListener(this);
        add(back);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1200,700);
        setLocation(100,20);
        setUndecorated(true);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==reset)
        {
            idfield.setText("");
            namefield.setText("");
            date.setCalendar(null);
            gendergroup.clearSelection();
            emailfield.setText("");
            mobilefield.setText("");
            classfield.setText("");
            addressfield.setText("");
            Relegion.setSelectedIndex(0);
            Category.setSelectedIndex(0);
            BloodGroup.setSelectedIndex(0);
            Occupation.setSelectedIndex(0);
            fnamefield.setText("");
            mnamefield.setText("");
            pphonefield.setText("");
        }
        if(ae.getSource()==back)
        {
            setVisible(false);
            new HomePage().setVisible(true);
        }
        if(ae.getSource()==submit)
        {
            String studentid=idfield.getText();
            String studentname=namefield.getText();
            String dob=((JTextField)date.getDateEditor().getUiComponent()).getText();
            String gender="";
            if(male.isSelected())
            {
                gender="Male";
            }
            else if(female.isSelected())
            {
                gender="Female";
            }
            String email=emailfield.getText();
            String mobile=mobilefield.getText();
            String address=addressfield.getText();
            String standard=classfield.getText();
            String relegion=(String) Relegion.getSelectedItem();
            String category=(String) Category.getSelectedItem();
            String blood=(String) BloodGroup.getSelectedItem();
            String fname=fnamefield.getText();
            String mname=mnamefield.getText();
            String pphone=pphonefield.getText();
            String occupations=(String) Occupation.getSelectedItem();
            
            if(studentid.equals(""))
            {
                
                JOptionPane.showMessageDialog(null, "Please Enter Student Id..");
            }
            else if(studentname.equals(""))
            {
                
                JOptionPane.showMessageDialog(null, "Name is Required");
            }
            else if(dob.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Date Of Birth..");
            }
            else if(gender.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Select Gender");
            }
            else if(email.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter E-mail Id..");
            }
            else if(mobile.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill Mobile Number");
            }
            else if(standard.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill Class");
            }
            else if(address.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Address");
            }
            else if(standard.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please fill Class");
            }
            else if(relegion.equals("SELECT"))
            {
                JOptionPane.showMessageDialog(null, "Please Select Relegion");
            }
            else if(category.equals("SELECT"))
            {
                JOptionPane.showMessageDialog(null, "Please Select Category");
            }
            else if(blood.equals("SELECT"))
            {
                JOptionPane.showMessageDialog(null, "Please Select Blood Group");
            }
            else if(fname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Father Name..");
            }
            else if(mname.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Mother Name..");
            }
            else if(pphone.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Enter Contact No..");
            }
            else if(occupations.equals("SELECT"))
            {
                JOptionPane.showMessageDialog(null, "Please Select Father Occupations");
            }
            else
            {
                try
                {
                    Conn c=new Conn();
                    String query1 ="insert into Students values('"+studentid+"', '"+studentname+"', '"+dob+"', '"+gender+"', '"+email+"', '"+mobile+"', '"+standard+"', '"+address+"', '"+relegion+"', '"+category+"', '"+blood+"')";
                    c.s.executeUpdate(query1);
                    
                    String query2 ="insert into Parents values('"+studentid+"', '"+fname+"', '"+mname+"', '"+pphone+"', '"+occupations+"')";
                    c.s.executeUpdate(query2);
                    
                    JOptionPane.showMessageDialog(null,"Student Added Successfully");
                    setVisible(false);
                    new HomePage().setVisible(true);
                }
                catch(Exception e)
                {
                    System.out.println(e);                   
                }
            }
            
        }
    }
                    
    public static void main(String [] args)
    {
        new AddStudent();
    }
}  

