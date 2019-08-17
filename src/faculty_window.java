import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.text.*;
import java.sql.*;
class faculty_window extends JFrame implements ActionListener
{
JLabel l1,l3;
JMenuBar mb;
JMenu mn1,mn2,mn3;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7;
ImageIcon i1;
String user="";
JPanel p1;
Connection con;
Statement stm;
java.util.Date d1=new java.util.Date();
SimpleDateFormat sdf=new SimpleDateFormat("hh:mm:ss");
JDesktopPane pane=new JDesktopPane();
faculty_window(String id)
{
setSize(1000,1000);
setLayout(null);
setExtendedState(JFrame.MAXIMIZED_BOTH);
user=id;

setContentPane(pane);

i1=new ImageIcon("qwer.jpg");
l1=new JLabel(i1);
l3=new JLabel("");
l3.setFont(new Font("Segoe Print",Font.BOLD,20));
l3.setForeground(Color.white);


mb=new JMenuBar();

mn1=new JMenu("Student_Record");
mn2=new JMenu("Student_Report");
mn3=new JMenu("Profile");

mi1=new JMenuItem("Put_Attendence");
mi2=new JMenuItem("Marks");
mi3=new JMenuItem("Attendence Report");
mi4=new JMenuItem("Marks Report");
mi6=new JMenuItem("Change Password");
mi7=new JMenuItem("Logout");


mn1.setFont(new Font("Segoe Print",Font.BOLD,15));
mn2.setFont(new Font("Segoe Print",Font.BOLD,15));
mn3.setFont(new Font("Segoe Print",Font.BOLD,15));

mi1.setFont(new Font("Segoe Print",Font.BOLD,15));
mi2.setFont(new Font("Segoe Print",Font.BOLD,15));
mi3.setFont(new Font("Segoe Print",Font.BOLD,15));
mi4.setFont(new Font("Segoe Print",Font.BOLD,15));
mi6.setFont(new Font("Segoe Print",Font.BOLD,15));
mi7.setFont(new Font("Segoe Print",Font.BOLD,15));



mi1.setBackground(Color.white);
mi2.setBackground(Color.white);
mi3.setBackground(Color.white);
mi4.setBackground(Color.white);
mi6.setBackground(Color.white);
mi7.setBackground(Color.white);


mn1.add(mi1);
mn1.add(mi2);

mn2.add(mi3);
mn2.add(mi4);

mn3.add(mi6);
mn3.add(mi7);


mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi7.addActionListener(this);
mi6.addActionListener(this);

mb.add(mn1);
mb.add(mn2);
mb.add(mn3);

mb.setBackground(Color.white);

setJMenuBar(mb);

l1.setBounds(0,0,1370,640);


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
else
l3.setText("Good Night "+name);



}
catch(Exception e)
{
System.out.println(e);
}








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
attendance obja=new attendance(user);
pane.add(obja);
obja.moveToFront();
obja.setMaximum(true);

}

if(ae.getSource()==mi2)
{
marks objm=new marks(user);
pane.add(objm);
objm.moveToFront();
objm.setMaximum(true);

}

if(ae.getSource()==mi3)
{

attendence_report objat=new attendence_report();
pane.add(objat);
objat.moveToFront();
objat.setMaximum(true);
//add(l1);
}

if(ae.getSource()==mi4)
{



marks_report objmr=new marks_report();
pane.add(objmr);
objmr.moveToFront();
objmr.setMaximum(true);

}

if(ae.getSource()==mi6)
new change_password(user,2);

if(ae.getSource()==mi7)
{
int u=JOptionPane.showConfirmDialog(this,"Are You Sure You want To Logout");
if(u==0)
{
new login();
this.dispose();
}
}
}
catch(Exception jk)
{}
}
public static void main(String lk[])
{
new faculty_window("");
}
}



