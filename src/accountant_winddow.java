import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.sql.*;
class accountant_window extends JFrame implements ActionListener
{
JLabel l1,l3;
JMenuBar mb;
JMenu mn1,mn2,mn3;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7;
JPanel p1;
Connection con;
Statement stm;
java.util.Date d1=new java.util.Date();
SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");

ImageIcon i1;
String user="";
JDesktopPane pane=new JDesktopPane();
accountant_window(String jk)
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
user=jk;

setContentPane(pane);




i1=new ImageIcon("qwer.jpg");
l1=new JLabel(i1);
l3=new JLabel("");
l3.setFont(new Font("Segoe Print",Font.BOLD,20));
l3.setForeground(Color.white);

mb=new JMenuBar();

mn1=new JMenu("Admission");
mn2=new JMenu("Report");
mn3=new JMenu("Profile");

mi1=new JMenuItem("New Admission");
mi2=new JMenuItem("Re-Registration");
mi3=new JMenuItem("Pay Fee");
mi4=new JMenuItem("Session Wise Report");
mi5=new JMenuItem("Date Wise Report");
mi6=new JMenuItem("Change Password");
mi7=new JMenuItem("Logout");


mn1.setFont(new Font("Segoe Print",Font.BOLD,15));
mn2.setFont(new Font("Segoe Print",Font.BOLD,15));
mn3.setFont(new Font("Segoe Print",Font.BOLD,15));


mi1.setFont(new Font("Segoe Print",Font.BOLD,15));
mi2.setFont(new Font("Segoe Print",Font.BOLD,15));
mi3.setFont(new Font("Segoe Print",Font.BOLD,15));
mi4.setFont(new Font("Segoe Print",Font.BOLD,15));
mi5.setFont(new Font("Segoe Print",Font.BOLD,15));
mi6.setFont(new Font("Segoe Print",Font.BOLD,15));
mi7.setFont(new Font("Segoe Print",Font.BOLD,15));


mi1.setBackground(Color.white);
mi2.setBackground(Color.white);
mi3.setBackground(Color.white);
mi4.setBackground(Color.white);
mi5.setBackground(Color.white);
mi6.setBackground(Color.white);
mi7.setBackground(Color.white);

mn1.add(mi1);
mn1.add(mi2);
mn1.add(mi3);

mn2.add(mi4);
mn2.add(mi5);

mn3.add(mi6);
mn3.add(mi7);


mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
mi7.addActionListener(this);


mb.add(mn1);
mb.add(mn2);
mb.add(mn3);


mb.setBackground(Color.white);

setJMenuBar(mb);

try
{
Class.forName("com.mysql.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
stm=con.createStatement();



String name="";
ResultSet rs=stm.executeQuery("select first_name from employee_data where user_id='"+user+"'");
if(rs.next())
name=rs.getString(1);

int i=d1.getHours();

if(i<6)
l3.setText("Early Good Morning "+name);
else if((i>=6)&&(i<12))
l3.setText("Good Morning "+name);
else if((i>=12)&&(i<13))
l3.setText("Good Noon "+name);
else if((i>=13)&&(i<17))
l3.setText("Good After Noon "+name);
else if((i>=17)&&(i<20))
l3.setText("Good Evening "+name);
else if((i>=20)&&(i<24))
l3.setText("Good Night "+name);



}
catch(Exception e)
{
System.out.println(e);
}








l1.setBounds(0,0,1370,640);
add(l1);
setVisible(true);
JOptionPane.showMessageDialog(this,l3.getText());
}
public void actionPerformed(ActionEvent ae)
{
try
{
if(ae.getSource()==mi1)
{
JInternalFrame fr=new JInternalFrame("Create New Student",true,true,true,true);
fr.setSize(1365,630);
JPanel p2=new create_student();
p2.setPreferredSize(new Dimension(1370,690));
JScrollPane pane1=new JScrollPane(p2);
pane1.setPreferredSize(p2.getPreferredSize());
fr.add(pane1);
fr.setVisible(true);
pane.add(fr,"Center");
fr.moveToFront();
fr.setMaximum(true);



}

if(ae.getSource()==mi2)
{
regeneration objr=new regeneration();
pane.add(objr);
objr.moveToFront();
objr.setMaximum(true);

}

if(ae.getSource()==mi3)
{
pay_fee objpf=new pay_fee("","",0);
pane.add(objpf);
objpf.moveToFront();
objpf.setMaximum(true);

}

if(ae.getSource()==mi4)
{
adm_report objo=new adm_report();
pane.add(objo);
objo.moveToFront();
objo.setMaximum(true);

}

if(ae.getSource()==mi5)
{
adm_report_by_date objar=new adm_report_by_date();
pane.add(objar);
objar.moveToFront();
objar.setMaximum(true);

}

if(ae.getSource()==mi6)
new change_password(user,2);

if(ae.getSource()==mi7)
{
int i=JOptionPane.showConfirmDialog(this,"Are You Sure You Want To Logout");
if(i==0)
{
new login();
this.dispose();
}
}
}
catch(Exception er)
{
er.printStackTrace();
}
}
public static void main(String lk[])
{
new accountant_window("");
}
}


